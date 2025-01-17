package net.smileycorp.ldoh.client.tesr;

import java.util.List;

import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.ForgeHooksClient;
import net.smileycorp.ldoh.client.entity.model.ModelTurret;
import net.smileycorp.ldoh.common.ModDefinitions;

public class TESRTurretItem extends TileEntityItemStackRenderer {

	public static ModelResourceLocation BASE_LOC = new ModelResourceLocation(ModDefinitions.getResource("turret"), "facing=up");

	protected ModelTurret turret = new ModelTurret();

	protected TransformType transforms;

	public class WrappedBakedModel implements IBakedModel {

		private final IBakedModel original;

		public WrappedBakedModel(IBakedModel original) {
			this.original = original;
		}

		@Override
		public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, long rand) {
			return original.getQuads(state, side, rand);
		}

		@Override
		public boolean isAmbientOcclusion() {
			return original.isAmbientOcclusion();
		}

		@Override
		public boolean isGui3d() {
			return original.isGui3d();
		}

		@Override
		public boolean isBuiltInRenderer() {
			return true;
		}

		@Override
		public TextureAtlasSprite getParticleTexture() {
			return original.getParticleTexture();
		}

		@Override
		@SuppressWarnings("deprecation")
		public ItemCameraTransforms getItemCameraTransforms() {
			return original.getItemCameraTransforms();
		}

		@Override
		public ItemOverrideList getOverrides() {
			return original.getOverrides();
		}

		@Override
		public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType transforms) {
			TESRTurretItem.this.transforms = transforms;
			return Pair.of(this, null);
		}

	}

	@Override
	public void renderByItem(ItemStack stack) {
		Minecraft mc = Minecraft.getMinecraft();
		GlStateManager.pushMatrix();
		switch (transforms) {
		case GUI:
			GlStateManager.scale(1.15, 1.15, 1.15);
			GlStateManager.translate(0.43, 0.53, 0);
			break;
		case FIXED:
			GlStateManager.rotate(90, 0, 1, 0);
			GlStateManager.scale(2, 2, 2);
			GlStateManager.translate(-0.25, 0.25, 0.25);
			break;
		case GROUND:
			GlStateManager.scale(1.5, 1.5, 1.5);
			GlStateManager.translate(0.34, 0.3, 0.34);
			break;
		case FIRST_PERSON_RIGHT_HAND:
			GlStateManager.scale(2, 2, 2);
			GlStateManager.rotate(90, 0, 1, 0);
			GlStateManager.translate(0, 0.2, 0.5);
			break;
		case FIRST_PERSON_LEFT_HAND:
			GlStateManager.scale(2, 2, 2);
			GlStateManager.rotate(180, 0, 1, 0);
			GlStateManager.translate(0, 0.2, 0);
			break;
		case THIRD_PERSON_RIGHT_HAND:
			GlStateManager.scale(1.3, 1.3, 1.3);
			GlStateManager.rotate(90, 0, 0, 1);
			GlStateManager.rotate(22.5f, 1, 0, 0);
			GlStateManager.translate(0.42, -0.2, 0.6);
			break;
		case THIRD_PERSON_LEFT_HAND:
			GlStateManager.scale(1.3, 1.3, 1.3);
			GlStateManager.translate(0.43, 0.35, 0.48);
			break;
		default: break;
		}
		IBakedModel base = mc.getRenderItem().getItemModelMesher().getModelManager().getModel(BASE_LOC);
		mc.getRenderItem().renderItem(stack, ForgeHooksClient.handleCameraTransforms(base, transforms, false));
		GlStateManager.rotate(90, 0, 1, 0);
		GlStateManager.rotate(180, 1, 0, 0);
		GlStateManager.translate(0, -0.9, 0);
		turret.render(mc.player, 0, 0, mc.world.getTotalWorldTime(), 0, 0, 0.05f);
		GlStateManager.popMatrix();
	}

}
