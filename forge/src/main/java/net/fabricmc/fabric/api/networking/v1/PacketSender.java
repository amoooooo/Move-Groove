package net.fabricmc.fabric.api.networking.v1;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public interface PacketSender {
    void sendPacket(ResourceLocation channel, FriendlyByteBuf buf);
}
