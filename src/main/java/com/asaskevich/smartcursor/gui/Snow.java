package com.asaskevich.smartcursor.gui;

class Snow {
    public int x;
    public int y;
    public int lifeTime;

    public Snow(int w) {
        x = ((int) (Math.random() * w));
        y = 0;
        lifeTime = 0;
    }

    public void moveDraw(int h) {
        y += 1;
        y = Math.min(y, h - 10);
        lifeTime += 1;
    }
}