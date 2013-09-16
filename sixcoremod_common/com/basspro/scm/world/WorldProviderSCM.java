package com.basspro.scm.world;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

import com.basspro.scm.SixCoreMod;
import com.basspro.scm.world.biome.SixCoreModBiomes;
import com.basspro.scm.world.gen.ChunkProviderSCM;

public class WorldProviderSCM extends WorldProvider {

    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(
                SixCoreModBiomes.highlands, 0.7F, 1.0F);
        this.dimensionId = SixCoreMod.dimension;
    }

    public String getSaveFolder() {
        return "DIM-SCM";
    }

    public String getDimensionName() {
        return "Pandora";
    }

    public String getWelcomeMessage() {
        return "Welcome to Pandora Kiddo!";
    }

    public String getDepartMessage() {
        return "Now Leaving Pandora";
    }

    public boolean canRespawnHere() {
        return true;
    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderSCM(worldObj, worldObj.getSeed(), true);
    }

    public ChunkCoordinates getEntrancePortalLocation() {
        return null;
    }

    public boolean canDoLightning(Chunk chunk) {
        return true;
    }

    public boolean canDoRainSnowIce(Chunk chunk) {
        return true;
    }
}
