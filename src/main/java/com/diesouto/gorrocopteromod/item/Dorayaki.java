package com.diesouto.gorrocopteromod.item;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class Dorayaki extends Item {

    // Food properties - delicious Japanese pancake filled with sweet red bean paste
    private static final FoodProperties DORAYAKI_FOOD = new FoodProperties.Builder()
            .nutrition(2)  // Restores 1 hunger bar (2 points)
            .saturationModifier(0.4f)  // Moderate saturation
            .build();  // Can only eat when hungry

    public Dorayaki() {
        super(new Item.Properties().food(DORAYAKI_FOOD));
    }
}