package com.github.draconianberyl.koresample.tree.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.item.ItemLeaves;

@SuppressWarnings("WeakerAccess")
public final class LeavesItem extends ItemLeaves
{
    public LeavesItem(Block block) { super((BlockLeaves) block); }
}
