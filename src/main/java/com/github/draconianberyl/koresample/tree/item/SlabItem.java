package com.github.draconianberyl.koresample.tree.item;

import com.github.draconianberyl.koresample.common.block.SlabBlock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

@SuppressWarnings("WeakerAccess")
public abstract class SlabItem extends ItemSlab
{
    // This provides a reminder that you must extend this class and change the constructor to accept your extension of
    // SlabBlock in the second and third  parameters
    protected SlabItem(Block block, SlabBlock singleSlab, SlabBlock doubleSlab, Boolean isDouble)
    {
        super(block, singleSlab, doubleSlab, isDouble);
    }
}
