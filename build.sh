#!/bin/bash

# Build script for Alien Mod (Minecraft 1.21.11 Fabric)
# Usage: ./build.sh

echo "Building Alien Mod for Minecraft 1.21.11..."

# Check if Java is available
if ! command -v java &> /dev/null; then
    echo "Error: Java not found. Please install Java 17+."
    exit 1
fi

# Check Java version
JAVA_VERSION=$(java -version 2>&1 | head -1)
echo "Using Java: $JAVA_VERSION"

# Create build directory if it doesn't exist
mkdir -p build/libs

# Compile the project
echo "Compiling source files..."
javac -cp "mods/*" -d build/classes \
    $(find src/main/java -name "*.java") \
    -source 17 -target 17

# Create JAR file
echo "Creating JAR file..."
jar --create --file build/libs/alienmod-1.0.0.jar -C build/classes .

echo "Build completed successfully!"
echo "JAR file created at: build/libs/alienmod-1.0.0.jar"
echo "To install: Copy this JAR to your .minecraft/mods folder"