package kami.tweaksntrinkets.blocks;

import net.minecraft.core.block.Block;
import kami.tweaksntrinkets.TweaksNTrinkets;
import turniplabs.halplibe.helper.BlockBuilder;

public class Blocks {
	private static int currentBlockID = 2000;
	public static Block<BlockLogicNetherTorch> NetherTorchBlock = new BlockBuilder(TweaksNTrinkets.MOD_ID)
		.setLuminance(14)
		.build("nether_torch",
			newBlockID(),
			BlockLogicNetherTorch::new
		);

	private static int newBlockID() {
		return currentBlockID++;
	}
}
