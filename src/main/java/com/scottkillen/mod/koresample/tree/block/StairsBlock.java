package com.scottkillen.mod.koresample.tree.block;

import com.scottkillen.mod.koresample.common.block.DefinesStairs;

// Use com.scottkillen.mod.koresample.common.block.StairsBlock instead
// This is left to honor the api contract
@SuppressWarnings({ "WeakerAccess", "ClassNameSameAsAncestorName" })
@Deprecated
public abstract class StairsBlock extends com.scottkillen.mod.koresample.common.block.StairsBlock
{
    protected StairsBlock(DefinesStairs model)
    {
        super(model);
    }
}
