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
        // Create base humanoid mesh with default deformation
        MeshDefinition mesh = HumanoidArmorModel.createBodyLayer(new CubeDeformation(0.5f));
        PartDefinition root = mesh.getRoot();

        // Define head and hat (armor model convention)
        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO);
        root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);

        // ─────────────────────────────
        // 1. Helix_geo  (propeller blades)
        // ─────────────────────────────

        head.addOrReplaceChild("propeller_geo",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(3.0F - 8.0F, 6.5F - 20.0F, 7.5F - 8.0F, 10.0F, 1.0F, 1.0F),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));

        // ─────────────────────────────
        // 2. Top_geo  (center cap)
        // ─────────────────────────────

        head.addOrReplaceChild("top_geo",
                CubeListBuilder.create()
                        .texOffs(0, 2)
                        .addBox(7.0F - 8.0F, 6.0F - 25.0F, 7.0F - 8.0F, 2.0F, 2.0F, 2.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // ─────────────────────────────
        // 3. Tube_geo  (vertical shaft)
        // ─────────────────────────────

        head.addOrReplaceChild("tube_geo",
                CubeListBuilder.create()
                        .texOffs(0, 6)
                        .addBox(7.5F - 8.0F, 1.0F - 6.0F, 7.5F - 8.0F, 1.0F, 5.0F, 1.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        // ─────────────────────────────
        // 4. Base_geo  (hat base)
        // ─────────────────────────────

        head.addOrReplaceChild("base_geo",
                CubeListBuilder.create()
                        .texOffs(0, 12)
                        .addBox(6.0F - 8.0F, 0.0F - 12.0F, 6.0F - 8.0F, 4.0F, 1.0F, 4.0F),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(mesh, 32, 32);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int rgb) {
        super.renderToBuffer(poseStack, buffer, packedLight, packedOverlay, rgb);

        propeller.yRot += 2f;
    }
}