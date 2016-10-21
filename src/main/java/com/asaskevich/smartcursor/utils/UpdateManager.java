package com.asaskevich.smartcursor.utils;

import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.URL;

public class UpdateManager {
    public PlayerLoggedInEvent event;

    public static String makeRequest(String address)
            throws Exception {
        URL url = new URL(address);
        InputStream is = url.openStream();
        DataInputStream br = new DataInputStream(is);
        byte[] b = new byte[br.available()];
        for (int i = 0; i < b.length; i++) {
            b[i] = br.readByte();
        }
        is.close();
        return new String(b, "UTF-8");
    }

    public static IChatComponent generateClickableMessage() {
        ChatComponentText fileLink = new ChatComponentText("Update SmartCursor on mods.io!");
        fileLink.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://mods.io/mods/1089-smartcursor"));
        fileLink.getChatStyle().setUnderlined(Boolean.valueOf(true));
        return fileLink;
    }

    @net.minecraftforge.fml.common.eventhandler.SubscribeEvent
    public void onEnterWorld(PlayerLoggedInEvent event) {
        this.event = event;
        new Thread() {
            public void run() {
                try {
                    String page = UpdateManager.makeRequest("https://mods.io/mods/1089-smartcursor");
                    int l = page.indexOf("<td><strong>");
                    if (l < 0) throw new Exception("");
                    int r = page.indexOf("</strong>", l + 10);
                    if (r < 0) throw new Exception("");
                    String localVersion = "1.5.0";
                    String globalVersion = page.substring(l + 12, r);
                    if (localVersion.compareToIgnoreCase(globalVersion) < 0) {
                        UpdateManager.this.event.player.addChatComponentMessage(new ChatComponentText("SmartCursor is out-of-date. Your version - " + localVersion + ", latest version - " + globalVersion));
                        UpdateManager.this.event.player.addChatComponentMessage(generateClickableMessage());
                    }
                } catch (Exception e) {
                    System.out.println("Unable to fetch information about updates!");
                }
            }
        }.start();
    }
}