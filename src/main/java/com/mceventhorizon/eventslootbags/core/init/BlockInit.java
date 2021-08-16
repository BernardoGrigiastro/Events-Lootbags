package com.mceventhorizon.eventslootbags.core.init;

import com.mceventhorizon.eventslootbags.EventsLootbags;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EventsLootbags.MOD_ID);
	
	public static final RegistryObject<Block> BAG_OPENER = BLOCKS.register("bag_opener", 
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLUE)
					.hardnessAndResistance(1f, 1f)
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(0)
					.sound(SoundType.WOOD)
					));
}
