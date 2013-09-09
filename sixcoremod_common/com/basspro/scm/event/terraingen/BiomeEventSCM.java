package com.basspro.scm.event.terraingen;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.Event;

import com.basspro.scm.world.biome.BiomeDecoratorSCM;
import com.basspro.scm.world.biome.BiomeGenBaseSCM;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEventSCM extends Event{
    public final BiomeGenBaseSCM biome;

    public BiomeEventSCM(BiomeGenBaseSCM biome)
    {
        this.biome = biome;
    }
    
    public static class CreateDecorator extends BiomeEventSCM
    {
        public final BiomeDecoratorSCM originalBiomeDecorator;
        public BiomeDecoratorSCM newBiomeDecorator;
        
        public CreateDecorator(BiomeGenBaseSCM biome, BiomeDecoratorSCM original)
        {
            super(biome);
            originalBiomeDecorator = original;
            newBiomeDecorator = original;
        }
    }

    public static class BlockReplacement extends BiomeEventSCM
    {
        public final int original;
        public int replacement;

        public BlockReplacement(BiomeGenBaseSCM biome, int original, int replacement)
        {
            super(biome);
            this.original = original;
            this.replacement = replacement;
        }
    }
    

    @SideOnly(Side.CLIENT)
    public static class BiomeColor extends BiomeEventSCM
    {
        public final int originalColor;
        public int newColor;
        
        public BiomeColor(BiomeGenBaseSCM biome, int original)
        {
            super(biome);
            originalColor = original;
            newColor = original;
        }
    }
    
    /**
     * This event is fired when the village generator attempts to choose a block ID
     * based on the village's biome.
     * 
     * You can set the result to DENY to prevent the default block ID selection.
     */
    @HasResult
    public static class GetVillageBlockID extends BlockReplacement
    {
        public GetVillageBlockID(BiomeGenBaseSCM biome, int original, int replacement)
        {
            super(biome, original, replacement);
        }
    }
    
    /**
     * This event is fired when the village generator attempts to choose a block
     * metadata based on the village's biome.
     * 
     * You can set the result to DENY to prevent the default block metadata selection.
     */
    @HasResult
    public static class GetVillageBlockMeta extends BlockReplacement
    {
        public GetVillageBlockMeta(BiomeGenBaseSCM biome, int original, int replacement)
        {
            super(biome, original, replacement);
        }
    }
    
    /**
     * This event is fired when a biome is queried for its grass color. 
     */

    @SideOnly(Side.CLIENT)
    public static class GetGrassColor extends BiomeColor
    {
        public GetGrassColor(BiomeGenBaseSCM biome, int original)
        {
            super(biome, original);
        }
    }
    
    /**
     * This event is fired when a biome is queried for its grass color. 
     */
    @SideOnly(Side.CLIENT)
    public static class GetFoliageColor extends BiomeColor
    {
        public GetFoliageColor(BiomeGenBaseSCM biome, int original)
        {
            super(biome, original);
        }
    }
    
    /**
     * This event is fired when a biome is queried for its water color. 
     */
    @SideOnly(Side.CLIENT)
    public static class GetWaterColor extends BiomeColor
    {
        public GetWaterColor(BiomeGenBaseSCM biome, int original)
        {
            super(biome, original);
        }
    }
}
