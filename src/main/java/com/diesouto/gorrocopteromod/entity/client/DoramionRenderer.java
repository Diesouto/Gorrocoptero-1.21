package com.diesouto.gorrocopteromod.entity.client;

import com.diesouto.gorrocopteromod.GorrocopteroMod;
import com.diesouto.gorrocopteromod.entity.custom.DoramionEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DoramionRenderer extends MobRenderer<DoramionEntity, DoramionModel<DoramionEntity>> {

    public DoramionRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DoramionModel<>(pContext.bakeLayer(DoramionModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(DoramionEntity doramionEntity) {
        return ResourceLocation.fromNamespaceAndPath(GorrocopteroMod.MODID, "textures/entity/doramion/doramion.png");
    }

    @Override
    public void render(DoramionEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
