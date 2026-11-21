# Alien Mod — Minecraft 1.21.11 Fabric

Replaces the player model with an alien form (based on DrDonut's alien concept images) and integrates Simple Voice Chat mouth animation so the jaw opens/closes while speaking.

## What it does
- **All players appear as aliens** — big bulbous head, black eyes, thin ribbed body, long arms with claws, and clawed feet
- **Mouth animation** — the jaw opens and closes rhythmically when a player is speaking through Simple Voice Chat
- **Works without Simple Voice Chat** — gracefully falls back to just the alien model if voice chat isn't installed

## Project structure
```
AlienMod/
├── build.gradle
├── settings.gradle
├── gradle.properties
├── mod.toml
└── src/
    ├── main/
    │   ├── java/com/example/alienmod/
    │   │   ├── AlienMod.java                 # Mod initializer
    │   │   ├── ClientAlienModInitializer.java # Client entrypoint
    │   │   ├── AlienPlayerRenderer.java       # Custom player renderer (alien model + jaw anim)
    │   │   ├── SimpleVoiceChatIntegration.java
    │   │   └── VoiceChatAlienIntegration.java
    │   └── resources/
    │       ├── alienmod.mixins.json
    │       ├── alienmod.accesswidener
    │       ├── assets/alienmod/models/block/alien_skin.json
    │       └── assets/alienmod/textures/alien_model_notes.txt
    └── resources/voicechat.config
```

## Build instructions

1. Make sure you have **Java 17** or newer installed.
2. Open a terminal in the `AlienMod` folder.
3. Run:

   ```
   ./gradlew build
   ```

   (On Windows: `gradlew.bat build`)

4. The compiled `.jar` will appear in:

   ```
   AlienMod/build/libs/alienmod-1.0.0.jar
   ```

5. Copy the `.jar` into your `.minecraft/mods/` folder alongside **Fabric Loader**, **Fabric API**, and optionally **Simple Voice Chat**.

## Requirements
- Minecraft 1.21.11
- Fabric Loader 0.19.2+
- Fabric API 0.141.3+1.21.11
- Simple Voice Chat (optional — for mouth animation; mod works without it)
- Java 17+

## Notes
- This is a **client-side only** mod. It only changes visual rendering, so it doesn't require server-side installation.
- The alien model uses a simplified scaling approach: player model is scaled down and arms/thickness adjusted to match the alien proportions from your screenshots.
- The mouth animation reads Simple Voice Chat's speaking state each render frame, so the jaw opens/closes in sync with voice chat activity.
