package com.scottkillen.mod.koresample.tree.block;

import java.util.Collection;

import com.scottkillen.mod.koresample.common.block.DefinesSlab;

// Use com.scottkillen.mod.koresample.common.block.SlabBlock instead
// This is left to honor the api contract
@SuppressWarnings({ "WeakerAccess", "ClassNameSameAsAncestorName" })
@Deprecated
public abstract class SlabBlock extends com.scottkillen.mod.koresample.common.block.SlabBlock
{
    protected SlabBlock(boolean isDouble, Collection<? extends DefinesSlab> subBlocks)
    {
        super(isDouble, subBlocks);
    }
}
