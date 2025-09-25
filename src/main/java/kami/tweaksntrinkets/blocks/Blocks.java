package kami.tweaksntrinkets.blocks;

import kami.tweaksntrinkets.items.Items;
import net.minecraft.core.block.Block;
import kami.tweaksntrinkets.TweaksNTrinkets;
import net.minecraft.core.block.BlockLogicGlassTinted;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.BlockBuilder;

public class Blocks {
	private static int currentBlockID = 2000;
	public static Block<BlockLogicNetherTorch> NetherTorchBlock = new BlockBuilder(TweaksNTrinkets.MOD_ID)
		.setLuminance(14)
		.build("nether_torch",
			newBlockID(),
			BlockLogicNetherTorch::new
		);
	public static Block<BlockLogicObsidianGlass> ObsidianGlass = new BlockBuilder(TweaksNTrinkets.MOD_ID)
		.setResistance(50)
		.setLightOpacity(15)
		.setUseInternalLight()
		.build("obsidian_glass",
			newBlockID(),
			BlockLogicObsidianGlass::new
		);

	private static int newBlockID() {
		return currentBlockID++;
	}
}
