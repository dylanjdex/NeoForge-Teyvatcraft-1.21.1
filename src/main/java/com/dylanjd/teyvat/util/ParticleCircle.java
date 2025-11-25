package com.dylanjd.teyvat.util;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class ParticleCircle {
    public static void serverParticleCircle(ServerLevel serverLevel, Player player, SimpleParticleType particle, double radius, int points) {
        double cx = player.getX();
        double cy = player.getZ();

        List<Point2D> pointList = new ArrayList<>();

        for (int i = 0; i < points; i++) {
            double angle = (2 * Math.PI) * i / points;
            double x = cx + radius * Math.cos(angle);
            double y = cy + radius * Math.sin(angle);
            pointList.add(new Point2D.Double(x,y));
        }

        for (Point2D point : pointList) {
            serverLevel.sendParticles(particle, point.getX(), player.getY() + 1, point.getY(), 1, 0f, 0f, 0f, 0);
        }
    }
}
