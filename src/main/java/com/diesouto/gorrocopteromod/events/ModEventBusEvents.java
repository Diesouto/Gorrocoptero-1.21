package com.diesouto.gorrocopteromod.events;

import com.diesouto.gorrocopteromod.GorrocopteroMod;
import com.diesouto.gorrocopteromod.entity.ModEntities;
import com.diesouto.gorrocopteromod.entity.client.DoramionModel;
import com.diesouto.gorrocopteromod.entity.custom.DoramionEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GorrocopteroMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DoramionModel.LAYER_LOCATION, DoramionModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.DORAMION.get(), DoramionEntity.createAttributes().build());
    }
}
