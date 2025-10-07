package com.diesouto.gorrocopteromod.item;

import com.diesouto.gorrocopteromod.GorrocopteroMod;
import com.diesouto.gorrocopteromod.client.ModClientSetup;
import com.diesouto.gorrocopteromod.client.models.armor.GorrocopteroModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static com.diesouto.gorrocopteromod.client.ModClientSetup.GORROCOPTERO_LAYER;

public class Gorrocoptero extends ArmorItem {

    public Gorrocoptero(Holder<ArmorMaterial> armorMaterialHolder, Type type, Properties props) {
        super(armorMaterialHolder, type, props);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GorrocopteroModel<?> cachedModel;

            @Override
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack stack,
                                                          EquipmentSlot slot, HumanoidModel<?> original) {
                if (slot == EquipmentSlot.HEAD && stack.is(ModItems.GORROCOPTERO.get())) {
                    if (cachedModel == null) {
                        ModelPart root = Minecraft.getInstance().getEntityModels().bakeLayer(GORROCOPTERO_LAYER);
                        cachedModel = new GorrocopteroModel<>(root);
                    }
                    return cachedModel;
                }
                return original;
            }
        });
    }

    @Override
    public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean inner) {
        if (slot == EquipmentSlot.HEAD && stack.is(ModItems.GORROCOPTERO.get())) {
            return ResourceLocation.parse(GorrocopteroMod.MODID + ":textures/models/armor/gorrocoptero.png");
        }
        return super.getArmorTexture(stack, entity, slot, layer, inner);
    }
}
