package com.diesouto.gorrocopteromod.entity.custom;

import com.diesouto.gorrocopteromod.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class DoramionEntity extends PathfinderMob {

    // Data syncher for visual effects (optional)
    private static final EntityDataAccessor<Integer> DORAYAKIS_FED =
            SynchedEntityData.defineId(DoramionEntity.class, EntityDataSerializers.INT);

    // Number of dorayakis needed (set randomly)
    private int dorayakisNeeded;
    private int dorayakisFed;

    public DoramionEntity(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
        // Sets a random number between 30 and 50 dorayakis
        this.dorayakisNeeded = 30 + this.random.nextInt(21); // 30-50
        this.dorayakisFed = 0;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DORAYAKIS_FED, 0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Monster.class, 8.0F, 1.2D, 1.5D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.2D, stack -> stack.is(ModItems.DORAYAKI.get()), false));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemInHand = player.getItemInHand(hand);

        // If the player has a dorayaki
        if (itemInHand.is(ModItems.DORAYAKI.get())) {
            if (!this.level().isClientSide) {
                // Consume the dorayaki
                if (!player.getAbilities().instabuild) {
                    itemInHand.shrink(1);
                }

                // Increment the counter
                this.dorayakisFed++;
                this.entityData.set(DORAYAKIS_FED, this.dorayakisFed);

                // Sound and particle effects
                this.playSound(SoundEvents.GENERIC_EAT, 1.0F, 1.0F);
                this.level().broadcastEntityEvent(this, (byte) 7); // Heart particles

                // Heal the Doramion a bit
                this.heal(1.0F);

                // Check if it reached the required number
                if (this.dorayakisFed >= this.dorayakisNeeded) {
                    this.dropGorrocoptero();
                    // Reset the counter and set a new goal
                    this.dorayakisFed = 0;
                    this.dorayakisNeeded = 30 + this.random.nextInt(21); // 30-50
                    this.entityData.set(DORAYAKIS_FED, 0);
                }

                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }

        return super.mobInteract(player, hand);
    }

    private void dropGorrocoptero() {
        if (!this.level().isClientSide && this.level() instanceof ServerLevel) {
            // Create the gorrocoptero item
            ItemStack gorrocoptero = new ItemStack(ModItems.GORROCOPTERO.get());

            // Position slightly above the Doramion
            Vec3 dropPos = this.position().add(0, 1, 0);

            // Create the item entity
            ItemEntity itemEntity = new ItemEntity(
                    this.level(),
                    dropPos.x,
                    dropPos.y,
                    dropPos.z,
                    gorrocoptero
            );

            // Add a small upward impulse
            itemEntity.setDeltaMovement(0, 0.3, 0);
            itemEntity.setDefaultPickUpDelay();

            // Spawn the item in the world
            this.level().addFreshEntity(itemEntity);

            // Special sound
            this.playSound(SoundEvents.PLAYER_LEVELUP, 1.0F, 1.0F);

            // Celebration particles
            this.level().broadcastEntityEvent(this, (byte) 20); // Smoke/happiness particles
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("DorayakisFed", this.dorayakisFed);
        tag.putInt("DorayakisNeeded", this.dorayakisNeeded);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.dorayakisFed = tag.getInt("DorayakisFed");
        this.dorayakisNeeded = tag.getInt("DorayakisNeeded");
        this.entityData.set(DORAYAKIS_FED, this.dorayakisFed);
    }

    public int getDorayakisFed() {
        return this.entityData.get(DORAYAKIS_FED);
    }

    public int getDorayakisNeeded() {
        return this.dorayakisNeeded;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, 20.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, 0.25D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE, 16.0D);
    }
}