package fluxedtrinkets.client.render.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSolderingStation extends ModelBase {
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;

	public ModelSolderingStation() {
		textureWidth = 128;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 0, 54);
		Shape1.addBox(0F, 0F, 0F, 2, 8, 2);
		Shape1.setRotationPoint(-8F, 16F, 6F);
		Shape1.setTextureSize(128, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 8, 54);
		Shape2.addBox(0F, 0F, 0F, 2, 8, 2);
		Shape2.setRotationPoint(6F, 16F, 6F);
		Shape2.setTextureSize(128, 64);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 16, 54);
		Shape3.addBox(0F, 0F, 0F, 2, 8, 2);
		Shape3.setRotationPoint(-8F, 16F, -8F);
		Shape3.setTextureSize(128, 64);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 24, 54);
		Shape4.addBox(0F, 0F, 0F, 2, 8, 2);
		Shape4.setRotationPoint(6F, 16F, -8F);
		Shape4.setTextureSize(128, 64);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 32, 46);
		Shape5.addBox(0F, 0F, 0F, 16, 2, 16);
		Shape5.setRotationPoint(-8F, 14F, -8F);
		Shape5.setTextureSize(128, 64);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 49);
		Shape6.addBox(0F, 0F, 0F, 1, 2, 3);
		Shape6.setRotationPoint(-6F, 12F, 2F);
		Shape6.setTextureSize(128, 64);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 8, 49);
		Shape7.addBox(0F, 0F, 0F, 1, 2, 3);
		Shape7.setRotationPoint(-4F, 12F, 2F);
		Shape7.setTextureSize(128, 64);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 16, 50);
		Shape8.addBox(0F, 0F, 0F, 3, 3, 1);
		Shape8.setRotationPoint(-6F, 11F, 1F);
		Shape8.setTextureSize(128, 64);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 0, 47);
		Shape9.addBox(0F, 0F, 0F, 3, 1, 1);
		Shape9.setRotationPoint(-6F, 13F, 5F);
		Shape9.setTextureSize(128, 64);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
	}

	public void render(float f5) {
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
