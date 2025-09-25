package kami.tweaksntrinkets;

import kami.tweaksntrinkets.items.Items;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.BlockModelTorch;
import net.minecraft.client.render.block.model.BlockModelTransparent;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import kami.tweaksntrinkets.blocks.Blocks;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.core.block.BlockLogicGlassTinted;
import turniplabs.halplibe.helper.ModelHelper;
import turniplabs.halplibe.util.ModelEntrypoint;

public class ModModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {
		ModelHelper.setBlockModel(Blocks.NetherTorchBlock,() ->
			new BlockModelTorch<>(Blocks.NetherTorchBlock)
				.setAllTextures(0, TweaksNTrinkets.MOD_ID + ":block/nethertorch"));

		ModelHelper.setBlockModel(Blocks.ObsidianGlass, () ->
			new BlockModelTransparent<>(Blocks.ObsidianGlass, false)
				.setAllTextures(0, TweaksNTrinkets.MOD_ID + ":block/obsidianglass"));
	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {
		ModelHelper.setItemModel(Items.MagicMirror,() ->
			new ItemModelStandard(Items.MagicMirror, "TweaksNTrinkets.MagicMirror").setIcon(TweaksNTrinkets.MOD_ID + ":block/magicmirror"));

		ModelHelper.setItemModel(Items.ObsidianGlassShard, () ->
			new ItemModelStandard(Items.ObsidianGlassShard, "TweaksNTrinkets.ObsidianGlassShard").setIcon(TweaksNTrinkets.MOD_ID + ":block/obsidianglassshard"));
	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}
}
