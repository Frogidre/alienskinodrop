package com.example.alienmod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlienMod implements ModInitializer {
    public static final String MOD_ID = "alienmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Alien Mod initializing...");
    }
}
