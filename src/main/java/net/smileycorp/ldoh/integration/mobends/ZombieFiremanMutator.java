package net.smileycorp.ldoh.integration.mobends;

import goblinbob.mobends.core.data.IEntityDataFactory;
import goblinbob.mobends.standard.mutators.ZombieMutatorBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelZombie;
import net.smileycorp.ldoh.common.entity.EntityZombieFireman;

public class ZombieFiremanMutator extends ZombieMutatorBase<ZombieFiremanData, EntityZombieFireman, ModelZombie> {

	public ZombieFiremanMutator(IEntityDataFactory<EntityZombieFireman> dataFactory) {
		super(dataFactory);
	}

	@Override
	public void storeVanillaModel(ModelZombie model) {
		ModelZombie vanillaModel = new ModelZombie(0.0F, this.halfTexture);
		this.vanillaModel = vanillaModel;
		super.storeVanillaModel(model);
	}

	@Override
	public boolean shouldModelBeSkipped(ModelBase model) {
		return false;
	}

}