package com.basspro.scm.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.basspro.scm.lib.Reference;
import com.basspro.scm.lib.Textures;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSCM extends Block
{
    public BlockSCM(int id, Material material)
    {

        super(id, material);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {

        blockIcon = iconRegister.registerIcon(Textures.TEXTURE_PATH
                + this.getUnlocalizedName().substring(5));
    }
}
