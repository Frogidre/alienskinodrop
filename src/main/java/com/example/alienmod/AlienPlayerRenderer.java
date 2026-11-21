package com.example.alienmod;

import com.maxhenkel.simplevoicechat.api.VoiceChatPlayer;
import com.maxhenkel.simplevoicechat.api.VoiceChatPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.AbstractFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class AlienPlayerRenderer extends PlayerEntityRenderer {

    private static final float JAW_SPEED = 15.0f;
    private static final float MAX_JAW_OPEN = 0.4f;

    public AlienPlayerRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, false);
    }

    @Override
    public void render(PlayerEntity player, float entityYaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        // Scale player down to alien proportions
        matrices.push();
        matrices.scale(0.85f, 0.9f, 0.85f);

        // Jaw animation: open mouth when speaking through voice chat
        if (isPlayerSpeaking(player)) {
            float openAmount = MAX_JAW_OPEN * (float) Math.abs(Math.sin(System.currentTimeMillis() / 100.0));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(openAmount * 90.0f));
        }

        super.render(player, entityYaw, tickDelta, matrices, vertexConsumers, light);
        matrices.pop();
    }

    private boolean isPlayerSpeaking(PlayerEntity player) {
        try {
            VoiceChatPlayer voiceChatPlayer = VoiceChatPlayer.fromPlayer(player);
            if (voiceChatPlayer != null) {
                return voiceChatPlayer.isSpeaking();
            }
        } catch (Exception e) {
            // Voice Chat mod not installed or API unavailable — skip silently
            AlienMod.LOGGER.debug("Simple Voice Chat API not available: " + e.getMessage());
        }
        return false;
    }

    // Extra cosmetic tweaks to match the alien look from DrDonut's images
    @Override
    protected void renderArm(PlayerEntity player, float swingProgress, MatrixStack matrices,
                             VertexConsumerProvider vertexConsumers, int light, boolean leftArm) {
        matrices.push();
        // Aliens have longer, thinner arms
        matrices.scale(0.9f, 1.15f, 0.9f);
        super.renderArm(player, swingProgress, matrices, vertexConsumers, light, leftArm);
        matrices.pop();
    }
}
