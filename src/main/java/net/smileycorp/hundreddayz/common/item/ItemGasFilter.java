package net.smileycorp.hundreddayz.common.item;

import net.minecraft.item.Item;
import net.smileycorp.hundreddayz.common.ModContent;
import net.smileycorp.hundreddayz.common.ModDefinitions;

public class ItemGasFilter extends Item {
	
	public ItemGasFilter() {
		String name = "Gas_Filter";
		this.setCreativeTab(ModContent.CREATIVE_TAB);
		this.setUnlocalizedName(ModDefinitions.getName(name));
		this.setRegistryName(ModDefinitions.getResource(name));
	}

}