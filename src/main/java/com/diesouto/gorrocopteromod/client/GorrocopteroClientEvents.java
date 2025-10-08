package com.diesouto.gorrocopteromod.client;

import com.diesouto.gorrocopteromod.item.Gorrocoptero;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class GorrocopteroClientEvents {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        Player player = mc.player;
        ItemStack helmet = player.getInventory().armor.get(3);

        if (helmet.getItem() instanceof Gorrocoptero) {
            if (mc.options.keyJump.isDown()) {
                double ascendSpeed = 0.15D;
                player.setDeltaMovement(player.getDeltaMovement().x, ascendSpeed, player.getDeltaMovement().z);
            }
        }
    }
}
