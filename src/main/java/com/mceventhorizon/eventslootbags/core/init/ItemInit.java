package com.mceventhorizon.eventslootbags.core.init;

import com.mceventhorizon.eventslootbags.EventsLootbags;
import com.mceventhorizon.eventslootbags.common.items.ItemLootbag;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EventsLootbags.MOD_ID);

	public static final RegistryObject<ItemLootbag> COMMON_LOOTBAG = ITEMS.register("common_lootbag",
			()-> new ItemLootbag(new Item.Properties().group(LootbagsItemGroup.LOOTBAGS_GROUP)));
	public static final RegistryObject<ItemLootbag> UNCOMMON_LOOTBAG = ITEMS.register("uncommon_lootbag",
			()-> new ItemLootbag(new Item.Properties().group(LootbagsItemGroup.LOOTBAGS_GROUP)));//add colors
	public static final RegistryObject<ItemLootbag> RARE_LOOTBAG = ITEMS.register("rare_lootbag",
			()-> new ItemLootbag(new Item.Properties().group(LootbagsItemGroup.LOOTBAGS_GROUP)));
	public static final RegistryObject<ItemLootbag> EPIC_LOOTBAG = ITEMS.register("epic_lootbag",
			()-> new ItemLootbag(new Item.Properties().group(LootbagsItemGroup.LOOTBAGS_GROUP)));
	public static final RegistryObject<ItemLootbag> LEGENDARY_LOOTBAG = ITEMS.register("legendary_lootbag",
			()-> new ItemLootbag(new Item.Properties().group(LootbagsItemGroup.LOOTBAGS_GROUP)));
	
	// Block Items
	public static final RegistryObject<BlockItem> BAG_OPENER = ITEMS.register("bag_opener", 
			() -> new BlockItem(BlockInit.BAG_OPENER.get(), new Item.Properties().group(LootbagsItemGroup.LOOTBAGS_GROUP)));

}
