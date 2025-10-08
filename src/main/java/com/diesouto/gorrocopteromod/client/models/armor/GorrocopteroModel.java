package com.diesouto.gorrocopteromod.client.models.armor;

import com.diesouto.gorrocopteromod.GorrocopteroMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class GorrocopteroModel<T extends LivingEntity> extends HumanoidArmorModel<T> {
    private final ModelPart propeller;

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(GorrocopteroMod.MODID, "gorrocoptero"), "main");

    public GorrocopteroModel(ModelPart root) {
        super(root);
        this.propeller = root.getChild("head").getChild("propeller_geo");
    }

    public static LayerDefinition createBodyLayer() {
        // Create base humanoid mesh
        MeshDefinition mesh = HumanoidArmorModel.createBodyLayer(new CubeDeformation(0.5f));
        PartDefinition root = mesh.getRoot();

        // Create both head and hat parts explicitly
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);

        // Add our gorrocopter parts to the head
        head.addOrReplaceChild("base_geo",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-2F, -9F, -2F, 4F, 1F, 4F),
                PartPose.ZERO);

        head.addOrReplaceChild("tube_geo",
                CubeListBuilder.create()
                        .texOffs(0, 5)
                        .addBox(-0.5F, -14F, -0.5F, 1F, 5F, 1F),
                PartPose.ZERO);

        head.addOrReplaceChild("propeller_geo",
                CubeListBuilder.create()
                        .texOffs(8, 0)
                        .addBox(-5F, -14.5F, -0.5F, 10F, 1F, 1F),
                PartPose.ZERO);

        return LayerDefinition.create(mesh, 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int rgb) {
        super.renderToBuffer(poseStack, buffer, packedLight, packedOverlay, rgb);

        propeller.yRot += 2f;
    }
}
