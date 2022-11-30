package net.fabricmc.fabric.api.networking.v1;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

import java.util.Collection;

public class PlayerLookup {
    public static Collection<ServerPlayer> tracking(Entity player) {
        return (Collection<ServerPlayer>) player.level.getServer().getPlayerList().getPlayers(); // TODO
    }

    public static Collection<ServerPlayer> around(ServerLevel world, Vec3 origin, double distance) {
        return world.getPlayers((player) -> player.position().distanceTo(origin) <= distance);
    }
}
