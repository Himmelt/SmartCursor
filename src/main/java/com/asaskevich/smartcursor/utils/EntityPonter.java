package com.asaskevich.smartcursor.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

import java.util.List;

public class EntityPonter {
    public static Minecraft mc = Minecraft.getMinecraft();
    public static Entity pointedEntity;
    public static long lastSuccessfulSearch = 0L;

    public static void getEntityLookingAt(float par1) {
        if ((mc.getRenderViewEntity() != null) &&
                (mc.theWorld != null)) {
            mc.pointedEntity = null;
            double d0 = Setting.lookDistance;
            mc.objectMouseOver = mc.getRenderViewEntity().rayTrace(d0, par1);
            double d1 = d0;
            Vec3 vec3 = mc.getRenderViewEntity().getPositionEyes(par1);
            if (mc.objectMouseOver != null) d1 = mc.objectMouseOver.hitVec.distanceTo(vec3);
            Vec3 vec31 = mc.getRenderViewEntity().getLook(par1);
            Vec3 vec32 = vec3.addVector(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0);
            pointedEntity = System.currentTimeMillis() - Setting.delta < lastSuccessfulSearch ? pointedEntity : null;
            Vec3 vec33 = null;
            float f1 = 1.0F;
            List list = mc.theWorld.getEntitiesWithinAABBExcludingEntity(mc.getRenderViewEntity(), mc.getRenderViewEntity().getEntityBoundingBox().addCoord(vec31.xCoord * d0, vec31.yCoord * d0, vec31.zCoord * d0).expand(f1, f1, f1));
            double d2 = d1;
            for (int i = 0; i < list.size(); i++) {
                Entity entity = (Entity) list.get(i);
                float f2 = entity.getCollisionBorderSize();
                AxisAlignedBB axisalignedbb = entity.getEntityBoundingBox().expand(f2, f2, f2);
                MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec32);
                if (axisalignedbb.isVecInside(vec3)) {
                    if ((0.0D < d2) || (d2 == 0.0D)) {
                        pointedEntity = entity;
                        vec33 = movingobjectposition == null ? vec3 : movingobjectposition.hitVec;
                        d2 = 0.0D;
                    }
                } else if (movingobjectposition != null) {
                    double d3 = vec3.distanceTo(movingobjectposition.hitVec);
                    if ((d3 < d2) || (d2 == 0.0D)) {
                        if ((entity == mc.getRenderViewEntity().ridingEntity) && (!entity.canRiderInteract())) {
                            if (d2 == 0.0D) {
                                pointedEntity = entity;
                                vec33 = movingobjectposition.hitVec;
                            }
                        } else {
                            pointedEntity = entity;
                            vec33 = movingobjectposition.hitVec;
                            d2 = d3;
                        }
                    }
                }
            }
            if ((pointedEntity != null) && ((d2 < d1) || (mc.objectMouseOver == null))) {
                mc.objectMouseOver = new MovingObjectPosition(pointedEntity, vec33);
                mc.pointedEntity = pointedEntity;
                lastSuccessfulSearch = System.currentTimeMillis();
            }
        }
    }
}