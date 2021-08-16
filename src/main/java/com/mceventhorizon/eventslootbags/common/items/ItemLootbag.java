package com.mceventhorizon.eventslootbags.common.items;

import java.util.List;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ItemLootbag extends Item{

	public ItemLootbag(Properties properties) {
		super(properties);
	}

	private final ResourceLocation COMMON_LOOTBAG_LOCATION = new ResourceLocation("eventslootbags:eventslootbags/common_lootbag");
	private final ResourceLocation UNCOMMON_LOOTBAG_LOCATION = new ResourceLocation("eventslootbags:eventslootbags/uncommon_lootbag");
	private final ResourceLocation RARE_LOOTBAG_LOCATION = new ResourceLocation("eventslootbags:eventslootbags/rare_lootbag");
	private final ResourceLocation EPIC_LOOTBAG_LOCATION = new ResourceLocation("eventslootbags:eventslootbags/epic_lootbag");
	private final ResourceLocation LEGENDARY_LOOTBAG_LOCATION = new ResourceLocation("eventslootbags:eventslootbags/legendary_lootbag");
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) { //replace with onUse sometime
		if(!worldIn.isRemote) {
			switch (playerIn.getHeldItemMainhand().getItem().getRegistryName().toString()) {
			
			case "eventslootbags:common_lootbag":
				createLootTable(worldIn, playerIn, handIn, COMMON_LOOTBAG_LOCATION);
				return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
			case "eventslootbags:uncommon_lootbag":
				createLootTable(worldIn, playerIn, handIn, UNCOMMON_LOOTBAG_LOCATION);
				return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
			case "eventslootbags:rare_lootbag":
				createLootTable(worldIn, playerIn, handIn, RARE_LOOTBAG_LOCATION);
				return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
			case "eventslootbags:epic_lootbag":
				createLootTable(worldIn, playerIn, handIn, EPIC_LOOTBAG_LOCATION);
				return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
			case "eventslootbags:legendary_lootbag":
				createLootTable(worldIn, playerIn, handIn, LEGENDARY_LOOTBAG_LOCATION);
				return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
			}
			
		}
		return ActionResult.resultFail(playerIn.getHeldItem(handIn));  //replaced with fail
	}
	
	public void createLootTable(World worldIn, PlayerEntity playerIn, Hand handIn, ResourceLocation location) {//change to action result
		LootTable table = worldIn.getServer().getLootTableManager()
				.getLootTableFromLocation(location);
		LootContext ctx = new LootContext.Builder((ServerWorld) worldIn)
				.withLuck(playerIn.getLuck())
				.withRandom(worldIn.getRandom())
				.build(LootParameterSets.EMPTY);
		List<ItemStack> stacks = table.generate(ctx);
		
		for(ItemStack item : stacks) {
			ItemEntity entity_item = new ItemEntity(worldIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), item);
			entity_item.setNoPickupDelay();
			worldIn.addEntity(entity_item);
		}
		if(!playerIn.isCreative()) {
			playerIn.getHeldItemMainhand().shrink(1);
		}
		
	}

}
