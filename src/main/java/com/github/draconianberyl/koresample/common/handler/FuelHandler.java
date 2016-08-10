package com.github.draconianberyl.koresample.common.handler;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;
import javax.annotation.Nullable;

import com.github.draconianberyl.koresample.common.events.FuelBurnTimeEvent;
import com.github.draconianberyl.koresample.common.events.KoreEventBusDispatcher;

public class FuelHandler implements IFuelHandler
{
    @Override
    public int getBurnTime(@Nullable ItemStack fuel)
    {
        if (fuel == null) return 0;

        final FuelBurnTimeEvent event = new FuelBurnTimeEvent(fuel);
        new KoreEventBusDispatcher().broadcast(event);
        return event.getBurnTime();
    }
}
