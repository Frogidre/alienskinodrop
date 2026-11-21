package com.example.alienmod;

import com.maxhenkel.simplevoicechat.api.VoiceChatPlayer;
import com.maxhenkel.simplevoicechat.api.VoiceChatPlayerEvents;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;

public class SimpleVoiceChatIntegration {

    public static void init() {
        VoiceChatPlayerEvents.PLAYER_SPEAKING.register((player, speaking) -> {
            // Trigger jaw animation when a player starts/stops speaking
            if (player.getWorld().isClient) {
                AlienMod.LOGGER.debug("Player {} speaking: {}", player.getName().getString(), speaking);
                // The renderer reads speaking state each frame, so no extra work needed here
            }
        });
    }
}
