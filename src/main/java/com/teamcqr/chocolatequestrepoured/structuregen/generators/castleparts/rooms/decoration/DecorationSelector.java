package com.teamcqr.chocolatequestrepoured.structuregen.generators.castleparts.rooms.decoration;

import com.teamcqr.chocolatequestrepoured.util.WeightedRandom;

import java.util.Random;

public class DecorationSelector
{
    private WeightedRandom<RoomDecorBase> edgeDecor;
    private WeightedRandom<RoomDecorBase> midDecor;

    public DecorationSelector(Random random)
    {
        this.edgeDecor = new WeightedRandom<>(random);
        this.midDecor = new WeightedRandom<>(random);
    }

    public void registerEdgeDecor(EnumRoomDecor decor, int weight)
    {
        edgeDecor.add(decor.createInstance(), weight);
    }

    public RoomDecorBase randomEdgeDecor()
    {
        return edgeDecor.next();
    }
}