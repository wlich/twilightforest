package twilightforest.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleGhastTear extends Particle
{
    public ParticleGhastTear(World par1World, double par2, double par4, double par6, Item par8Item)
    {
        super(par1World, par2, par4, par6, 0.0D, 0.0D, 0.0D);
        this.particleTexture = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(par8Item);
        this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
        this.particleGravity = Blocks.SNOW.blockParticleGravity * 2F;
        this.particleScale = 16.0F;
        
        this.particleMaxAge = 20 + rand.nextInt(40);
    }

    public ParticleGhastTear(World par1World, double par2, double par4, double par6, double par8, double par10, double par12, Item par14Item)
    {
        this(par1World, par2, par4, par6, par14Item);
        this.motionX *= 0.10000000149011612D;
        this.motionY *= 0.10000000149011612D;
        this.motionZ *= 0.10000000149011612D;
        this.motionX += par8;
        this.motionY += par10;
        this.motionZ += par12;
    }

    @Override
    public int getFXLayer()
    {
        return 2;
    }

    @Override
    public void onUpdate()
    {
	    super.onUpdate();    
    	
        if (this.isCollided && rand.nextBoolean())
        {
        	//world.playSoundEffect(this.posX, this.posY + 1D, this.posZ, "random.fizz", 2.0F, 2.0F);
            //world.spawnParticle("lava", this.posX, this.posY, this.posZ, 0, 0, 0);
			//world.playAuxSFXAtEntity(null, 2001, (int)this.posX, (int)this.posY + 1, (int)this.posZ, 0);
    		//this.world.playAuxSFXAtEntity((EntityPlayer)null, 2002, (int)this.posX, (int)this.posY, (int)this.posZ, 4037);
        	
        	world.playSound(null, this.posX, this.posY + 1D, this.posZ, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.HOSTILE, 0.5F, 1.0F);

    		for (int var1 = 0; var1 < 50; ++var1)
    		{
    		    double gaussX = rand.nextGaussian() * 0.1D;
    		    double gaussY = rand.nextGaussian() * 0.2D;
    		    double gaussZ = rand.nextGaussian() * 0.1D;
    		    Item popItem = Items.GHAST_TEAR;
    		    
    		    
    		    world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX + rand.nextFloat() - rand.nextFloat(), this.posY + 0.5F, this.posZ + rand.nextFloat(), gaussX, gaussY, gaussZ, Item.getIdFromItem(popItem));
    		}
            this.setExpired();
        }
    }
}
