package kami.tweaksntrinkets.blocks;

import kami.tweaksntrinkets.items.Items;
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
		if(dropCause == EnumDropCause.SILK_TOUCH || dropCause == EnumDropCause.EXPLOSION) {
			return new ItemStack[]{new ItemStack(Blocks.ObsidianGlass, 1)};
		};

		Random rand = new Random();
		int randomInt = rand.nextInt(11);
		if(randomInt == 3) {
			int amount = rand.nextInt(3);
			return new ItemStack[]{new ItemStack(Items.ObsidianGlassShard, amount)};
		}

		return null;
	}
}
