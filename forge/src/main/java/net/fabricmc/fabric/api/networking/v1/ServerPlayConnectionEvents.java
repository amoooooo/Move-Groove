package net.fabricmc.fabric.api.networking.v1;

import net.fabricmc.fabric.api.event.Event;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;

import java.util.ArrayList;
import java.util.List;

public class ServerPlayConnectionEvents {
    public static List<Join> onPlayerJoined = new ArrayList<>();
    public static final Event<Join> JOIN = new PlayerJoinEvent();

    public static class PlayerJoinEvent extends Event<Join> {
        public void register(Join listener){
            onPlayerJoined.add(listener);
        }
    }

    public interface Join {
        void onPlayReady(ServerGamePacketListenerImpl handler, PacketSender sender, MinecraftServer server);
    }
}
