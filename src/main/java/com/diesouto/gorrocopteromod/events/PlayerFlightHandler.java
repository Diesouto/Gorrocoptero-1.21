package com.diesouto.gorrocopteromod.events;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import com.diesouto.gorrocopteromod.item.Gorrocoptero;

@Mod.EventBusSubscriber
public class PlayerFlightHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        // Only run on server-side
        if (player.level().isClientSide) return;

        ItemStack helmet = player.getInventory().armor.get(3); // 0=boots,1=legs,2=chest,3=helmet

        if (helmet.getItem() instanceof Gorrocoptero) {
            // Give flight
            if (!player.getAbilities().mayfly) {
                player.getAbilities().mayfly = true;
                player.onUpdateAbilities();
            }
        } else {
            // Remove flight if not in creative/spectator
            if (!player.isCreative() && !player.isSpectator() && player.getAbilities().mayfly) {
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
                player.onUpdateAbilities();
            }
        }
    }
}
