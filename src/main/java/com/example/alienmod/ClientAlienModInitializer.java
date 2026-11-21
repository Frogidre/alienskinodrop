package com.example.alienmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.entity.player.PlayerEntity;

public class ClientAlienModInitializer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AlienMod.LOGGER.info("Alien Mod client initializing...");

        // Register custom player renderer so every player looks like an alien
        EntityRendererRegistry.register(PlayerEntity.class, AlienPlayerRenderer::new);
    }
}
