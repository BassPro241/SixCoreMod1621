package com.basspro.scm.world.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenHighlands extends BiomeGenBase
{
    protected BiomeGenHighlands(int par1)
    {
        super(par1);
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 10;
    }

}
