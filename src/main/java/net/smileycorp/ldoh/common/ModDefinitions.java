package net.smileycorp.ldoh.common;

import net.minecraft.util.ResourceLocation;

public class ModDefinitions {

	//mod constants
	public static final String MODID = "sight_to_see";
	public static final String NAME = "Sight to See Tweaks";
	public static final String VERSION = "1.0.0";
	public static final String DEPENDENCIES = "required-after:tektopia;required-after:atlaslib@1.1.5;required-after:rafradek_tf2_weapons;required-after:hordes@1.1.4;required-after:srparasites;"
			+ "required-after:mod_lavacow;required-after:firstaid;required-after:animania;required-after:wastelands;required-after:biomesoplenty;"
			+ "required-after:cfm;required-after:realistictorches;required-after:xlfoodmod;required-after:cookingforblockheads;"
			+ "required-after:bibliocraft;after:biometweaker;required-after:animania;required-after:followme;required-after:gamestages;"
			+ "required-after:reccomplex;before:vanillafix";
	public static final String LOCATION = "net.smileycorp.ldoh.";
	public static final String CLIENT = LOCATION + "client.ClientProxy";
	public static final String COMMON = LOCATION + "common.CommonProxy";

	//translation keys
	public static final String JOIN_TEAM_MESSAGE = "message.sight_to_see.JoinTeam";
	public static final String POST_JOIN_TEAM_MESSAGE = "message.sight_to_see.PostJoinTeam";
	public static final String OTHER_JOIN_TEAM_MESSAGE = "message.sight_to_see.OtherJoinTeam";
	public static final String DAY_COUNT_MESSAGE = "message.sight_to_see.DayCount";
	public static final String DAY_100_MESSAGE = "message.sight_to_see.FinalDay";
	public static final String APOCALYPSE_MESSAGE = "message.sight_to_see.WorldsEnd";
	public static final String GAS_MESSAGE = "message.sight_to_see.Gas";
	public static final String LAVA_PICKUP_MESSAGE = "message.sight_to_see.Lava.Pickup";
	public static final String LAVA_BREAK_MESSAGE = "message.sight_to_see.Lava.Break";
	public static final String ZOMBIE_EVOLUTION_MESSAGE_0 = "message.sight_to_see.Evolution_0";
	public static final String ZOMBIE_EVOLUTION_MESSAGE_1 = "message.sight_to_see.Evolution_1";
	public static final String VILLAGER_MESSAGE = "message.sight_to_see.VillagerMessage";

	//sounds
	public static final ResourceLocation TF_ENEMY_SOUND = getResource("tf_enemy");
	public static final ResourceLocation TF_ALLY_SOUND = getResource("tf_ally");
	public static final ResourceLocation LANDMINE_BEEP = getResource("landmine_beep");

	//loot tables
	public static final ResourceLocation SAFEHOUSE_CHEST = getResource("chests/safehouse_chest");
	public static final ResourceLocation SAFEHOUSE_CABINET = getResource("chests/safehouse_cabinet");
	public static final ResourceLocation SAFEHOUSE_FRIDGE = getResource("chests/safehouse_fridge");
	public static final ResourceLocation SAFEHOUSE_VEGGIES = getResource("chests/safehouse_veggies");
	public static final ResourceLocation SAFEHOUSE_MEDICAL_FRIDGE = getResource("chests/safehouse_medical_fridge");
	public static final ResourceLocation SAFEHOUSE_CRATE = getResource("chests/safehouse_crate");
	public static final ResourceLocation NEST_CRATE = getResource("chests/nest_crate");
	public static final ResourceLocation MILITARY_CRATE = getResource("chests/military_crate");
	public static final ResourceLocation MILITARY_AMMO = getResource("chests/military_ammo");
	public static final ResourceLocation MILITARY_TREASURE = getResource("chests/military_treasure");

	//helper methods
	public static String getName(String name) {
		return MODID + "." + name.replace("_", "");
	}

	public static ResourceLocation getResource(String name) {
		return new ResourceLocation(MODID, name.toLowerCase());
	}

}
