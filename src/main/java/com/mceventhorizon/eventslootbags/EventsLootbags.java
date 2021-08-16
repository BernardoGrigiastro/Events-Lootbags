package com.mceventhorizon.eventslootbags;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mceventhorizon.eventslootbags.core.init.BlockInit;
import com.mceventhorizon.eventslootbags.core.init.ItemInit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(EventsLootbags.MOD_ID)
public class EventsLootbags {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "eventslootbags";


	public EventsLootbags() {
		
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
		
	}

	private void setup(final FMLCommonSetupEvent event) {
		
	}
	

}
