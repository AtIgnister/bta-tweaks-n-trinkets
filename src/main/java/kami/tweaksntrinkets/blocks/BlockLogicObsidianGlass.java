package kami.tweaksntrinkets.blocks;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicGlassTinted;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockLogicObsidianGlass extends BlockLogicGlassTinted {
	public BlockLogicObsidianGlass(Block<?> block) {
		super(block);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int meta, TileEntity tileEntity) {
		//TODO: make this have a 1 in 3 chance to drop glass shards you can use to craft tools when broken normally
		if(dropCause == EnumDropCause.SILK_TOUCH || dropCause == EnumDropCause.EXPLOSION) {
			return new ItemStack[]{new ItemStack(Blocks.ObsidianGlass, 1)};
		};

		return null;
	}
}
