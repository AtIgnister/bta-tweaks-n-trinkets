package kami.tweaksntrinkets;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.client.sound.SoundRepository;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.io.IOException;
import java.net.URISyntaxException;


public class TweaksNTrinkets implements ModInitializer, RecipeEntrypoint, GameStartEntrypoint { ;
    public static final String MOD_ID = "tweaksntrinkets";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Block<?> NetherTorchBlockModel;

    @Override
    public void onInitialize() {
        LOGGER.info("ExampleMod initialized.");

    }



	@Override
	public void onRecipesReady() {
		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.NETHERCOAL)
			.addInput(Blocks.TORCH_COAL)
			.create("itemGroupNetherTorch", new ItemStack(kami.tweaksntrinkets.blocks.Blocks.NetherTorchBlock, 2));
	}

	@Override
	public void initNamespaces() {

	}

	@Override
	public void beforeGameStart() {
		try {
			TextureRegistry.initializeAllFiles(TweaksNTrinkets.MOD_ID, TextureRegistry.blockAtlas, true);
			TextureRegistry.initializeAllFiles(TweaksNTrinkets.MOD_ID, TextureRegistry.itemAtlas, true);
		} catch (URISyntaxException | IOException e) {
			throw new RuntimeException(e);
		}

		try {
			SoundRepository.registerNamespace(TweaksNTrinkets.MOD_ID);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public void afterGameStart() {

	}
}
