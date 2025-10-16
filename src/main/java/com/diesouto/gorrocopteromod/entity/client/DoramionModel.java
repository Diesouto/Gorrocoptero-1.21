package com.diesouto.gorrocopteromod.entity.client;

import com.diesouto.gorrocopteromod.GorrocopteroMod;

import com.diesouto.gorrocopteromod.entity.custom.DoramionEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class DoramionModel<T extends DoramionEntity> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(GorrocopteroMod.MODID, "doramion"), "main");
    private final ModelPart head;
    private final ModelPart body;

    public DoramionModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = body.getChild("upper").getChild("next").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, 1.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, -0.5F));

        PartDefinition collar = head.addOrReplaceChild("collar", CubeListBuilder.create().texOffs(14, 40).mirror().addBox(-5.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(14, 40).addBox(4.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(42, 7).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 9).addBox(-4.0F, -1.0F, 3.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 46).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -0.5F));

        PartDefinition head2 = head.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -5.0F, -4.5F, 12.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(0, 18).addBox(-5.0F, -6.0F, -4.5F, 10.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
                .texOffs(26, 38).mirror().addBox(-7.0F, -4.0F, -3.5F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(26, 38).addBox(6.0F, -4.0F, -3.5F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(26, 28).addBox(-5.0F, -5.0F, -5.5F, 10.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(38, 18).addBox(-5.0F, -5.0F, 4.5F, 10.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(8, 47).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 48).addBox(-0.5F, -0.5F, -0.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 46).mirror().addBox(-1.3F, -0.5F, 0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(22, 46).addBox(0.3F, -0.5F, 0.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.5F));

        PartDefinition whiskers = head.addOrReplaceChild("whiskers", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.0F, -6.5F));

        PartDefinition right_whiskers = whiskers.addOrReplaceChild("right_whiskers", CubeListBuilder.create().texOffs(0, 57).addBox(-3.0F, 0.0F, 0.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition whisker_r1 = right_whiskers.addOrReplaceChild("whisker_r1", CubeListBuilder.create().texOffs(1, 57).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.8F, 0.0F, 0.0F, 0.0F, -0.3054F));

        PartDefinition whisker_r2 = right_whiskers.addOrReplaceChild("whisker_r2", CubeListBuilder.create().texOffs(1, 57).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition left_whiskers2 = whiskers.addOrReplaceChild("left_whiskers2", CubeListBuilder.create().texOffs(0, 57).mirror().addBox(-1.0F, 0.0F, 0.0F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 0.0F, 0.0F));

        PartDefinition whisker_r3 = left_whiskers2.addOrReplaceChild("whisker_r3", CubeListBuilder.create().texOffs(1, 57).mirror().addBox(-1.0F, 0.0F, 0.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.8F, 0.0F, 0.0F, 0.0F, 0.3054F));

        PartDefinition whisker_r4 = left_whiskers2.addOrReplaceChild("whisker_r4", CubeListBuilder.create().texOffs(1, 57).mirror().addBox(-1.0F, 0.0F, 0.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.8F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 28).addBox(-4.0F, -3.0F, -2.5F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 40).addBox(-3.0F, -3.0F, 2.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(42, 42).addBox(-2.0F, 0.0F, -3.5F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -0.5F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 2.0F));

        PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(48, 28).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.3F, 1.0F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(48, 31).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.5F, 3.0F, -0.2182F, 0.0F, 0.0F));

        PartDefinition arms = root.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, -0.5F));

        PartDefinition left_arm = arms.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition left_hand_r1 = left_arm.addOrReplaceChild("left_hand_r1", CubeListBuilder.create().texOffs(42, 0).addBox(-1.0F, 1.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(14, 46).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5376F, -2.4089F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition right_arm = arms.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, -6.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition right_hand_r1 = right_arm.addOrReplaceChild("right_hand_r1", CubeListBuilder.create().texOffs(42, 0).mirror().addBox(-2.0F, 1.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(14, 46).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5376F, -2.4089F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition legs = root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, -1.0F));

        PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(42, 38).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(42, 11).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 47).addBox(2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(42, 16).addBox(-1.0F, -1.0F, 2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

        PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(42, 38).mirror().addBox(-2.0F, -2.0F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(42, 11).mirror().addBox(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 47).mirror().addBox(-3.0F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(42, 16).mirror().addBox(-2.0F, -1.0F, 2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(DoramionEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

//        FALTA POR METER ANIMACIONES AQUI (WALKING IDLE ETC ETC)
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float) Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}
