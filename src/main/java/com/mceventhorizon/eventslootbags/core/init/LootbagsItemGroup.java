package com.mceventhorizon.eventslootbags.core.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class LootbagsItemGroup extends ItemGroup{

	public static final ItemGroup LOOTBAGS_GROUP = new LootbagsItemGroup("lootbagstab");
	
	public LootbagsItemGroup(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack createIcon() {
		// TODO Auto-generated method stub
		return ItemInit.RARE_LOOTBAG.get().getDefaultInstance();
	}

}
