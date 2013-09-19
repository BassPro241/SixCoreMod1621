package com.basspro.scm.world;

import net.minecraftforge.common.DimensionManager;

public class DimensionSCM {

    public static int dimension = 2;
    
    
    public static void init()
    {
        DimensionManager.registerProviderType(dimension, WorldProviderSCM.class, false);
        DimensionManager.registerDimension(dimension, dimension);
    }

}
