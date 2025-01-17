package net.smileycorp.ldoh.common.entity;

import com.vicmatskiv.mw.Guns;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.smileycorp.ldoh.common.item.LDOHItems;

public class EntitySwatZombie extends EntityProfessionZombie {

	private static final ItemStack MACHINE_PISTOL = createGun();
	private static final ItemStack SHOTGUN = createShotgun();
	private static final ItemStack PISTOL = createPistol();

	protected static final DataParameter<ItemStack> BACK_ITEM = EntityDataManager.createKey(EntitySwatZombie.class, DataSerializers.ITEM_STACK);
	protected static final DataParameter<ItemStack> HOLSTER_ITEM = EntityDataManager.createKey(EntitySwatZombie.class, DataSerializers.ITEM_STACK);

	public EntitySwatZombie(World world) {
		super(world);
	}

	@Override
	protected void setEquipment() {
		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, MACHINE_PISTOL);
		setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(LDOHItems.GAS_MASK));
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(BACK_ITEM, SHOTGUN);
		dataManager.register(HOLSTER_ITEM, PISTOL);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(8.0D);
	}

	public ItemStack getBackItem() {
		return dataManager.get(BACK_ITEM);
	}

	public ItemStack getHolsterItem() {
		return dataManager.get(HOLSTER_ITEM);
	}

	public void setBackItem(ItemStack stack) {
		dataManager.set(BACK_ITEM, stack);
	}

	public void setHolsterItem(ItemStack stack) {
		dataManager.set(HOLSTER_ITEM, stack);
	}

	private static ItemStack createGun() {
		return new ItemStack(Guns.M4A1);
	}

	private static ItemStack createShotgun() {
		return new ItemStack(Guns.Spas12);
	}

	private static ItemStack createPistol() {
		return new ItemStack(Guns.DesertEagle);
	}

}
