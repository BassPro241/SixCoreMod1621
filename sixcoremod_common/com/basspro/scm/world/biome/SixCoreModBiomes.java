package com.basspro.scm.world.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class SixCoreModBiomes {
    
    public static BiomeGenBase highlands;
    
    public static void init()
    {
        highlands = new BiomeGenHighlands(60).setBiomeName("Highlands");
    }

}
