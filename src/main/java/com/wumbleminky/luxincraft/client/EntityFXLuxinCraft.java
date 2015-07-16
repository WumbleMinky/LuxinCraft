package com.wumbleminky.luxincraft.client;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

import java.util.Random;

public class EntityFXLuxinCraft extends EntityFX {

    private int[] defaultTextureIndices = new int[]{1,2,3};

    public EntityFXLuxinCraft(World world, double x, double y, double z, float red, float green, float blue) {
        super(world, x, y, z, 0, 0, 0);
        this.particleRed = red;
        this.particleGreen = green;
        this.particleBlue = blue;
        Random rnd = new Random();
        this.setParticleTextureIndex(defaultTextureIndices[rnd.nextInt(defaultTextureIndices.length)]);
        this.particleGravity = 0;
        this.setSize(0.5f, 0.5f);
        this.motionY = rnd.nextFloat() * 0.3;
        this.particleMaxAge = ((Double)(this.motionY * 24)).intValue();
        this.motionX = this.motionZ = 0;
    }
}
