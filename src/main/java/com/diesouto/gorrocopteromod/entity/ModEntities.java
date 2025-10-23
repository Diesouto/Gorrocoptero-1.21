package com.diesouto.gorrocopteromod.entity;

import com.diesouto.gorrocopteromod.GorrocopteroMod;
import com.diesouto.gorrocopteromod.entity.custom.DoramionEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GorrocopteroMod.MODID);

    public static final RegistryObject<EntityType<DoramionEntity>> DORAMION =
            ENTITY_TYPES.register("doramion", () -> EntityType.Builder.of(DoramionEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.3f).build("doramion"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
