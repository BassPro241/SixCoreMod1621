package com.basspro.scm.item;

import com.basspro.scm.SixCoreMod;
import com.basspro.scm.lib.Strings;

public class ItemFoodApplePie extends ItemFoodSCM
{
    public ItemFoodApplePie(int par1, int par2, float par3, boolean par4)
    {
        super(par1, par2, par3, par4);

        this.setUnlocalizedName(Strings.APPLE_PIE_NAME);
        this.setCreativeTab(SixCoreMod.tabSixCoreFood);
        maxStackSize = 64;
    }

}
