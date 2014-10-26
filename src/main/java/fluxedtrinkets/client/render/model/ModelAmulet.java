

package fluxedtrinkets.client.render.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAmulet extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
    ModelRenderer Shape22;
    ModelRenderer Shape23;
    ModelRenderer Shape24;
    ModelRenderer Shape25;
    ModelRenderer Shape26;
    ModelRenderer Shape27;
    ModelRenderer Shape28;
    ModelRenderer Shape29;
    ModelRenderer Shape30;
    ModelRenderer Shape31;
  
  public ModelAmulet()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape1 = new ModelRenderer(this, 0, 59);
      Shape1.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape1.setRotationPoint(-6F, -1F, -2F);
      Shape1.setTextureSize(128, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 10, 59);
      Shape2.addBox(0F, 0F, 0F, 1, 1, 4);
      Shape2.setRotationPoint(5F, -1F, -2F);
      Shape2.setTextureSize(128, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 57);
      Shape3.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape3.setRotationPoint(-6F, 0F, -3F);
      Shape3.setTextureSize(128, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 4, 57);
      Shape4.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape4.setRotationPoint(5F, 0F, -3F);
      Shape4.setTextureSize(128, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 8, 57);
      Shape5.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape5.setRotationPoint(4F, 1F, -3F);
      Shape5.setTextureSize(128, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 12, 57);
      Shape6.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape6.setRotationPoint(4F, 1F, -3F);
      Shape6.setTextureSize(128, 64);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 16, 57);
      Shape7.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape7.setRotationPoint(-4F, 2F, -3F);
      Shape7.setTextureSize(128, 64);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 55);
      Shape8.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape8.setRotationPoint(3F, 2F, -3F);
      Shape8.setTextureSize(128, 64);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 4, 55);
      Shape9.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape9.setRotationPoint(-3F, 3F, -3F);
      Shape9.setTextureSize(128, 64);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 8, 55);
      Shape10.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape10.setRotationPoint(2F, 3F, -3F);
      Shape10.setTextureSize(128, 64);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 12, 55);
      Shape11.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape11.setRotationPoint(-2F, 4F, -3F);
      Shape11.setTextureSize(128, 64);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 16, 55);
      Shape12.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape12.setRotationPoint(1F, 4F, -3F);
      Shape12.setTextureSize(128, 64);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 0, 52);
      Shape13.addBox(0F, 0F, 0F, 2, 2, 1);
      Shape13.setRotationPoint(-1F, 5F, -3F);
      Shape13.setTextureSize(128, 64);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 0, 50);
      Shape14.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape14.setRotationPoint(4.5F, 0.5F, -3F);
      Shape14.setTextureSize(128, 64);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 4, 50);
      Shape15.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape15.setRotationPoint(-4.5F, 1.5F, -3F);
      Shape15.setTextureSize(128, 64);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 8, 50);
      Shape16.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape16.setRotationPoint(-3.5F, 2.5F, -3F);
      Shape16.setTextureSize(128, 64);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0F, 0F);
      Shape17 = new ModelRenderer(this, 12, 50);
      Shape17.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape17.setRotationPoint(-2.5F, 3.5F, -3F);
      Shape17.setTextureSize(128, 64);
      Shape17.mirror = true;
      setRotation(Shape17, 0F, 0F, 0F);
      Shape18 = new ModelRenderer(this, 16, 50);
      Shape18.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape18.setRotationPoint(-1.5F, 4.5F, -3F);
      Shape18.setTextureSize(128, 64);
      Shape18.mirror = true;
      setRotation(Shape18, 0F, 0F, 0F);
      Shape19 = new ModelRenderer(this, 0, 48);
      Shape19.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape19.setRotationPoint(5F, -0.5F, -2.5F);
      Shape19.setTextureSize(128, 64);
      Shape19.mirror = true;
      setRotation(Shape19, 0F, 0F, 0F);
      Shape20 = new ModelRenderer(this, 4, 48);
      Shape20.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape20.setRotationPoint(-5F, 1F, -3F);
      Shape20.setTextureSize(128, 64);
      Shape20.mirror = true;
      setRotation(Shape20, 0F, 0F, 0F);
      Shape21 = new ModelRenderer(this, 8, 48);
      Shape21.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape21.setRotationPoint(-5.5F, 0.5F, -3F);
      Shape21.setTextureSize(128, 64);
      Shape21.mirror = true;
      setRotation(Shape21, 0F, 0F, 0F);
      Shape22 = new ModelRenderer(this, 12, 48);
      Shape22.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape22.setRotationPoint(-6F, -0.5F, -2.5F);
      Shape22.setTextureSize(128, 64);
      Shape22.mirror = true;
      setRotation(Shape22, 0F, 0F, 0F);
      Shape23 = new ModelRenderer(this, 16, 48);
      Shape23.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape23.setRotationPoint(3.5F, 1.5F, -3F);
      Shape23.setTextureSize(128, 64);
      Shape23.mirror = true;
      setRotation(Shape23, 0F, 0F, 0F);
      Shape24 = new ModelRenderer(this, 0, 46);
      Shape24.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape24.setRotationPoint(2.5F, 2.5F, -3F);
      Shape24.setTextureSize(128, 64);
      Shape24.mirror = true;
      setRotation(Shape24, 0F, 0F, 0F);
      Shape25 = new ModelRenderer(this, 4, 46);
      Shape25.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape25.setRotationPoint(1.5F, 3.5F, -3F);
      Shape25.setTextureSize(128, 64);
      Shape25.mirror = true;
      setRotation(Shape25, 0F, 0F, 0F);
      Shape26 = new ModelRenderer(this, 8, 46);
      Shape26.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape26.setRotationPoint(0.5F, 4.5F, -3F);
      Shape26.setTextureSize(128, 64);
      Shape26.mirror = true;
      setRotation(Shape26, 0F, 0F, 0F);
      Shape27 = new ModelRenderer(this, 12, 46);
      Shape27.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape27.setRotationPoint(5F, -0.5F, 1.5F);
      Shape27.setTextureSize(128, 64);
      Shape27.mirror = true;
      setRotation(Shape27, 0F, 0F, 0F);
      Shape28 = new ModelRenderer(this, 16, 46);
      Shape28.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape28.setRotationPoint(-6F, -0.5F, 1.5F);
      Shape28.setTextureSize(128, 64);
      Shape28.mirror = true;
      setRotation(Shape28, 0F, 0F, 0F);
      Shape29 = new ModelRenderer(this, 0, 44);
      Shape29.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape29.setRotationPoint(5F, 0F, 2F);
      Shape29.setTextureSize(128, 64);
      Shape29.mirror = true;
      setRotation(Shape29, 0F, 0F, 0F);
      Shape30 = new ModelRenderer(this, 4, 44);
      Shape30.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape30.setRotationPoint(-6F, 0F, 2F);
      Shape30.setTextureSize(128, 64);
      Shape30.mirror = true;
      setRotation(Shape30, 0F, 0F, 0F);
      Shape31 = new ModelRenderer(this, 0, 42);
      Shape31.addBox(0F, 0F, 0F, 11, 1, 1);
      Shape31.setRotationPoint(-5.5F, 0.5F, 2F);
      Shape31.setTextureSize(128, 64);
      Shape31.mirror = true;
      setRotation(Shape31, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
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
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
    Shape16.render(f5);
    Shape17.render(f5);
    Shape18.render(f5);
    Shape19.render(f5);
    Shape20.render(f5);
    Shape21.render(f5);
    Shape22.render(f5);
    Shape23.render(f5);
    Shape24.render(f5);
    Shape25.render(f5);
    Shape26.render(f5);
    Shape27.render(f5);
    Shape28.render(f5);
    Shape29.render(f5);
    Shape30.render(f5);
    Shape31.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
