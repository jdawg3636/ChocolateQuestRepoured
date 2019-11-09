package com.teamcqr.chocolatequestrepoured.structuregen.generators.castleparts.rooms.decoration;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public class RoomDecorCraftingTable extends RoomDecorBase
{
    public RoomDecorCraftingTable()
    {
        super();
    }

    @Override
    protected void makeSchematic()
    {
        IBlockState blockType = Blocks.CRAFTING_TABLE.getDefaultState();
        schematic.add(new DecoPlacement(0, 0, 0, blockType));
    }
}