package com.example.alienmod;

import com.maxhenkel.simplevoicechat.api.VoiceChatPlayerEvents;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;

public class VoiceChatAlienIntegration implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        try {
            VoiceChatPlayerEvents.PLAYER_SPEAKING.register((player, speaking) -> {
                if (player != null && player.getWorld().isClient) {
                    AlienMod.LOGGER.debug("Voice chat event: {} speaking={}", player.getName().getString(), speaking);
                    // The AlienPlayerRenderer reads speaking state each render frame,
                    // so mouth opens/closes automatically while speaking.
                }
            });
        } catch (Throwable t) {
            AlienMod.LOGGER.warn("Simple Voice Chat integration failed: {}", t.getMessage());
        }
    }
}
