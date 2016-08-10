package com.github.draconianberyl.koresample.tree.loader;

import com.github.draconianberyl.koresample.common.block.DefinesSlab;
import com.github.draconianberyl.koresample.common.block.DefinesStairs;
import com.github.draconianberyl.koresample.common.block.SlabBlock;
import com.github.draconianberyl.koresample.common.util.slab.SingleDoubleSlab;
import com.github.draconianberyl.koresample.common.util.slab.TheSingleSlabRegistry;
import com.github.draconianberyl.koresample.tree.DefinesLeaves;
import com.github.draconianberyl.koresample.tree.DefinesLog;
import com.github.draconianberyl.koresample.tree.DefinesSapling;
import com.github.draconianberyl.koresample.tree.DefinesWood;
import com.github.draconianberyl.koresample.tree.TreeBlockFactory;
import com.github.draconianberyl.koresample.tree.TreeTaxonomy;
import com.github.draconianberyl.koresample.tree.block.LeavesBlock;
import com.github.draconianberyl.koresample.tree.block.LogBlock;
import com.github.draconianberyl.koresample.tree.block.SaplingBlock;
import com.github.draconianberyl.koresample.tree.block.WoodBlock;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.util.List;

@SuppressWarnings("WeakerAccess")
public class TreeSpeciesLoader
{
    private final TreeTaxonomy taxonomy;
    private final TheSingleSlabRegistry slabRegistry = TheSingleSlabRegistry.REFERENCE;

    public TreeSpeciesLoader(TreeTaxonomy taxonomy)
    {
        this.taxonomy = taxonomy;
    }

    public void load(TreeBlockFactory factory)
    {
        loadLogBlocks(factory);
        loadLeavesBlocks(factory);
        loadWoodBlocks(factory);
        loadSaplingBlocks(factory);
        loadSlabBlocks(factory);
        loadStairsBlocks(factory);
    }

    private void loadLeavesBlocks(TreeBlockFactory factory)
    {
        final List<DefinesLeaves> subBlocks = Lists.newArrayListWithCapacity(LeavesBlock.CAPACITY);
        for (final DefinesLeaves definition : taxonomy.leavesDefinitions())
        {
            definition.assignLeavesSubBlockIndex(subBlocks.size());

            subBlocks.add(definition);
            if (subBlocks.size() == LeavesBlock.CAPACITY)
            {
                factory.createLeavesBlock(subBlocks);
                subBlocks.clear();
            }
        }
        if (!subBlocks.isEmpty()) factory.createLeavesBlock(subBlocks);
    }

    private void loadLogBlocks(TreeBlockFactory factory)
    {
        final List<DefinesLog> subBlocks = Lists.newArrayListWithCapacity(LogBlock.CAPACITY);
        for (final DefinesLog definition : taxonomy.logDefinitions())
        {
            definition.assignLogSubBlockIndex(subBlocks.size());

            subBlocks.add(definition);
            if (subBlocks.size() == LogBlock.CAPACITY)
            {
                factory.createLogBlock(subBlocks);
                subBlocks.clear();
            }
        }
        if (!subBlocks.isEmpty()) factory.createLogBlock(subBlocks);
    }

    private void loadSaplingBlocks(TreeBlockFactory factory)
    {
        final List<DefinesSapling> subBlocks = Lists.newArrayListWithCapacity(SaplingBlock.CAPACITY);
        for (final DefinesSapling definition : taxonomy.saplingDefinitions())
        {
            definition.assignSaplingSubBlockIndex(subBlocks.size());

            subBlocks.add(definition);
            if (subBlocks.size() == SaplingBlock.CAPACITY)
            {
                factory.createSaplingBlock(subBlocks);
                subBlocks.clear();
            }
        }
        if (!subBlocks.isEmpty()) factory.createSaplingBlock(subBlocks);
    }

    private void loadSlabBlocks(TreeBlockFactory factory)
    {
        final List<DefinesSlab> subBlocks = Lists.newArrayList();
        for (final DefinesSlab definition : taxonomy.slabDefinitions())
        {
            definition.assignSlabSubBlockIndex(subBlocks.size());

            subBlocks.add(definition);
            if (subBlocks.size() == SlabBlock.CAPACITY)
            {
                final SingleDoubleSlab slabs = factory.createSlabBlocks(subBlocks);
                slabRegistry.add(slabs.singleSlab());

                subBlocks.clear();
            }
        }
        if (!subBlocks.isEmpty())
        {
            final SingleDoubleSlab slabs = factory.createSlabBlocks(subBlocks);
            slabRegistry.add(slabs.singleSlab());
        }
    }

    private void loadStairsBlocks(TreeBlockFactory factory)
    {
        for (final DefinesStairs definition : taxonomy.stairsDefinitions())
        {
            factory.createStairsBlock(definition);
        }
    }

    private void loadWoodBlocks(TreeBlockFactory factory)
    {
        final List<DefinesWood> subBlocks = Lists.newArrayListWithCapacity(WoodBlock.CAPACITY);
        for (final DefinesWood definition : taxonomy.woodDefinitions())
        {
            definition.assignWoodSubBlockIndex(subBlocks.size());

            subBlocks.add(definition);
            if (subBlocks.size() == WoodBlock.CAPACITY)
            {
                factory.createWoodBlock(subBlocks);
                subBlocks.clear();
            }
        }
        if (!subBlocks.isEmpty()) factory.createWoodBlock(subBlocks);
    }

    @Override
    public String toString()
    {
        return Objects.toStringHelper(this).add("taxonomy", taxonomy).add("slabRegistry", slabRegistry).toString();
    }
}
