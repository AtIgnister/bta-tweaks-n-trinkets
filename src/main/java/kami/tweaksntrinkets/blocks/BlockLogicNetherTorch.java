package kami.tweaksntrinkets.blocks;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicTorch;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockLogicNetherTorch extends BlockLogicTorch {

	public BlockLogicNetherTorch(Block<?> block) {
		super(block);
	}

	@Override
	public void animationTick(World world, int x, int y, int z, Random rand) {

		double xPos = (double)x + (double)0.5F;
		double yPos = (double)y + 0.7;
		double zPos = (double)z + (double)0.5F;
		double d3 = 0.22;
		double d4 = 0.27;
		int side = world.getBlockMetadata(x, y, z) & 7;
		switch (side) {
			case 1:
				world.spawnParticle("reddust", xPos - d4, yPos + d3, zPos, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("fireflyRed", xPos - d4, yPos + d3, zPos, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				break;
			case 2:
				world.spawnParticle("reddust", xPos + d4, yPos + d3, zPos, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("fireflyRed", xPos + d4, yPos + d3, zPos, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				break;
			case 3:
				world.spawnParticle("reddust", xPos, yPos + d3, zPos - d4, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("fireflyRed", xPos, yPos + d3, zPos - d4, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				break;
			case 4:
				world.spawnParticle("reddust", xPos, yPos + d3, zPos + d4, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("fireflyRed", xPos, yPos + d3, zPos + d4, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				break;
			case 5:
				world.spawnParticle("reddust", xPos, yPos, zPos, (double)0.0F, (double)0.0F, (double)0.0F, 0);
				world.spawnParticle("fireflyRed", xPos, yPos, zPos, (double)0.0F, (double)0.0F, (double)0.0F, 0);
		}
	}
}
