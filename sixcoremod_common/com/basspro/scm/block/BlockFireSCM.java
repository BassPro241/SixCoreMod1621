package com.basspro.scm.block;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.UP;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.Random;

import com.basspro.scm.SixCoreMod;
import com.basspro.scm.lib.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockFireSCM extends BlockFire {

    protected BlockFireSCM(int par1) {
        super(par1);
        this.setTickRandomly(true);
//        setCreativeTab(SixCoreMod.tabSixCoreModBlock);
    }

    @SideOnly(Side.CLIENT)
    private Icon[] blockIconArray;

    @Override
    @SideOnly(Side.CLIENT)
    /*
     * A randomly called display update to be able to add particles or other
     * items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3,
            int par4, Random par5Random) {
        if (par5Random.nextInt(24) == 0) {
            par1World.playSound((double) ((float) par2 + 0.5F),
                    (double) ((float) par3 + 0.5F),
                    (double) ((float) par4 + 0.5F), "fire.fire",
                    1.0F + par5Random.nextFloat(),
                    par5Random.nextFloat() * 0.7F + 0.3F, false);
        }

        int l;
        float f;
        float f1;
        float f2;

        if (!par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4)
                && !SixCoreModBlocks.fireSCM.canBlockCatchFire(par1World, par2, par3 - 1,
                        par4, UP)) {
            if (SixCoreModBlocks.fireSCM.canBlockCatchFire(par1World, par2 - 1, par3, par4,
                    EAST)) {
                for (l = 0; l < 2; ++l) {
                    f = (float) par2 + par5Random.nextFloat() * 0.1F;
                    f1 = (float) par3 + par5Random.nextFloat();
                    f2 = (float) par4 + par5Random.nextFloat();
                    par1World.spawnParticle("largesmoke", (double) f,
                            (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
                }
            }

            if (SixCoreModBlocks.fireSCM.canBlockCatchFire(par1World, par2 + 1, par3, par4,
                    WEST)) {
                for (l = 0; l < 2; ++l) {
                    f = (float) (par2 + 1) - par5Random.nextFloat() * 0.1F;
                    f1 = (float) par3 + par5Random.nextFloat();
                    f2 = (float) par4 + par5Random.nextFloat();
                    par1World.spawnParticle("largesmoke", (double) f,
                            (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
                }
            }

            if (SixCoreModBlocks.fireSCM.canBlockCatchFire(par1World, par2, par3, par4 - 1,
                    SOUTH)) {
                for (l = 0; l < 2; ++l) {
                    f = (float) par2 + par5Random.nextFloat();
                    f1 = (float) par3 + par5Random.nextFloat();
                    f2 = (float) par4 + par5Random.nextFloat() * 0.1F;
                    par1World.spawnParticle("largesmoke", (double) f,
                            (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
                }
            }

            if (SixCoreModBlocks.fireSCM.canBlockCatchFire(par1World, par2, par3, par4 + 1,
                    NORTH)) {
                for (l = 0; l < 2; ++l) {
                    f = (float) par2 + par5Random.nextFloat();
                    f1 = (float) par3 + par5Random.nextFloat();
                    f2 = (float) (par4 + 1) - par5Random.nextFloat() * 0.1F;
                    par1World.spawnParticle("largesmoke", (double) f,
                            (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
                }
            }

            if (SixCoreModBlocks.fireSCM.canBlockCatchFire(par1World, par2, par3 + 1, par4,
                    DOWN)) {
                for (l = 0; l < 2; ++l) {
                    f = (float) par2 + par5Random.nextFloat();
                    f1 = (float) (par3 + 1) - par5Random.nextFloat() * 0.1F;
                    f2 = (float) par4 + par5Random.nextFloat();
                    par1World.spawnParticle("largesmoke", (double) f,
                            (double) f1, (double) f2, 0.0D, 0.0D, 0.0D);
                }
            }
        } else {
            for (l = 0; l < 3; ++l) {
                f = (float) par2 + par5Random.nextFloat();
                f1 = (float) par3 + par5Random.nextFloat() * 0.5F + 0.5F;
                f2 = (float) par4 + par5Random.nextFloat();
                par1World.spawnParticle("largesmoke", (double) f, (double) f1,
                        (double) f2, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        blockIconArray = new Icon[] {iconRegister.registerIcon(Textures.TEXTURE_PATH
                + this.getUnlocalizedName().substring(5) + "_layer_0"), iconRegister.registerIcon(Textures.TEXTURE_PATH
                        + this.getUnlocalizedName().substring(5) + "_layer_1")};
    }
    
}
