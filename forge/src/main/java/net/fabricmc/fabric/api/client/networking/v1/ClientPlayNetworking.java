package net.fabricmc.fabric.api.client.networking.v1;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.fabricmc.fabric.api.networking.v1.NetworkHandler;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.PacketWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class ClientPlayNetworking {
    public static Map<ResourceLocation, PlayChannelHandler> HANDLERS = new HashMap<>();

    public static boolean registerGlobalReceiver(ResourceLocation id, PlayChannelHandler handler){
        HANDLERS.put(id, handler);
        return true;
    }

    public static void send(ResourceLocation id, FriendlyByteBuf forwardBuffer) {
        NetworkHandler.INSTANCE.sendToServer(new PacketWrapper(false, id, forwardBuffer));
    }

    public static void handle(PacketWrapper msg) {
        HANDLERS.get(msg.packetType).receive(Minecraft.getInstance(), Minecraft.getInstance().getConnection(), new FriendlyByteBuf(msg.data), null);
    }

    public interface PlayChannelHandler {
        void receive(Minecraft client, ClientPacketListener handler, FriendlyByteBuf buf, PacketSender responseSender);
    }
}
