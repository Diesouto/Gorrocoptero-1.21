package com.diesouto.gorrocopteromod.client;

import com.diesouto.gorrocopteromod.GorrocopteroMod;
import com.diesouto.gorrocopteromod.client.models.armor.GorrocopteroModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "gorrocopteromod", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModClientSetup {

    public static final ModelLayerLocation GORROCOPTERO_LAYER =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(GorrocopteroMod.MODID, "gorrocoptero"), "main");

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GorrocopteroModel.LAYER_LOCATION, GorrocopteroModel::createBodyLayer);
    }
}
