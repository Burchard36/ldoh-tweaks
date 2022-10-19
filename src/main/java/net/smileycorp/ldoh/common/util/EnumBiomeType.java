package net.smileycorp.ldoh.common.util;

import biomesoplenty.common.biome.BOPBiome;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import biomesoplenty.api.biome.BOPBiomes;

import com.google.common.base.Optional;
import com.legacy.wasteland.world.WastelandWorld;
import net.minecraftforge.common.BiomeDictionary;

@SuppressWarnings("unchecked")
public enum EnumBiomeType {

	WASTELAND(
			Optional.of(WastelandWorld.apocalypse),
			Optional.of(BOPBiomes.wasteland.get()),
			Optional.of(BOPBiomes.dead_forest.get())
	),
	DESERT(
			Optional.of(BOPBiomes.cold_desert.get()),
			Optional.of(BOPBiomes.lush_desert.get()),
			Optional.of(Biomes.DESERT)
	),
	BADLANDS(
			BOPBiomes.wasteland
	),
	OCEAN(Optional.of(Biomes.DEEP_OCEAN), Optional.of(Biomes.OCEAN)),
	CITY(Optional.of(WastelandWorld.apocalypse_city));

	private final Optional<Biome>[] biomes;


	private EnumBiomeType(Optional<Biome>... biomes) {
		this.biomes = biomes;
	}

	public boolean matches(Biome biome) {
		for (Optional<Biome> optional : biomes) {
			if (optional.isPresent()) if (optional.get() == biome) return true;
		}
		return false;
	}

}
