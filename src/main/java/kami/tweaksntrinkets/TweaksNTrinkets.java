package kami.tweaksntrinkets;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TweaksNTrinkets implements ModInitializer, RecipeEntrypoint, GameStartEntrypoint { ;
    public static final String MOD_ID = "tweaksntrinkets";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Block<?> NetherTorchBlockModel;

	public final RecipeNamespace TWEAKSNTRINKETS = new RecipeNamespace();

    @Override
    public void onInitialize() {
        LOGGER.info("ExampleMod initialized.");

    }



	@Override
	public void onRecipesReady() {
		RecipeGroup<RecipeEntryCrafting<?,?>> WORKBENCH = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Blocks.WORKBENCH)));
		TWEAKSNTRINKETS.register("blocks", WORKBENCH);

		List<ItemStack> itemStacks = new LinkedList<>();
		itemStacks.add(new ItemStack(kami.tweaksntrinkets.blocks.Blocks.NetherTorchBlock));
		Registries.ITEM_GROUPS.register("blocks", itemStacks);


		DataLoader.loadRecipesFromFile("/assets/tweaksntrinkets/recipe/workbench.json");

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.NETHERCOAL)
			.addInput(Blocks.TORCH_COAL)
			.create("itemGroupNetherTorch", new ItemStack(kami.tweaksntrinkets.blocks.Blocks.NetherTorchBlock, 4));
	}

	@Override
	public void initNamespaces() {
		Registries.RECIPES.register("tweaksntrinkets", this.TWEAKSNTRINKETS);
	}

	@Override
	public void beforeGameStart() {
		new kami.tweaksntrinkets.items.Items().Initialize();
	}


	@Override
	public void afterGameStart() {

	}
}
