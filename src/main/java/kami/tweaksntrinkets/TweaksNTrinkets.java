package kami.tweaksntrinkets;

import kami.tweaksntrinkets.items.ObsidianDagger;
import kami.tweaksntrinkets.items.ObsidianGlassShard;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryBlastFurnace;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderBlastFurnace;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.LinkedList;
import java.util.List;

public class TweaksNTrinkets implements ModInitializer, RecipeEntrypoint, GameStartEntrypoint { ;
    public static final String MOD_ID = "tweaksntrinkets";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public final RecipeNamespace TWEAKSNTRINKETS = new RecipeNamespace();
	public final RecipeBuilderBlastFurnace BlastRecipeBuilder = new RecipeBuilderBlastFurnace(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("ExampleMod initialized.");
    }


	@Override
	public void onRecipesReady() {
		RecipeGroup<RecipeEntryCrafting<?,?>> WORKBENCH = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Blocks.WORKBENCH)));
		TWEAKSNTRINKETS.register("blocks", WORKBENCH);
		TWEAKSNTRINKETS.register("items", WORKBENCH);

		RecipeGroup<RecipeEntryBlastFurnace> BLASTFURNACE = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Blocks.FURNACE_BLAST_ACTIVE)));
		TWEAKSNTRINKETS.register("blast_furnace", BLASTFURNACE);

		List<ItemStack> itemStacks = new LinkedList<>();
		itemStacks.add(new ItemStack(kami.tweaksntrinkets.blocks.Blocks.NetherTorchBlock.withLightEmission(14)));
		itemStacks.add(new ItemStack(kami.tweaksntrinkets.blocks.Blocks.ObsidianGlass
			.withBlastResistance(50)
			.withHardness(0)
		));
		Registries.ITEM_GROUPS.register("blocks", itemStacks);

		itemStacks.clear();
		itemStacks.add(new ItemStack(kami.tweaksntrinkets.items.Items.ObsidianGlassShard));
		itemStacks.add(new ItemStack(kami.tweaksntrinkets.items.Items.ObsidianDagger));
		Registries.ITEM_GROUPS.register("items", itemStacks);


		DataLoader.loadRecipesFromFile("/assets/tweaksntrinkets/recipe/workbench.json");
		DataLoader.loadRecipesFromFile("/assets/tweaksntrinkets/recipe/blast_furnace.json");

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Items.NETHERCOAL)
			.addInput(Blocks.TORCH_COAL)
			.create("itemGroupNetherTorch", new ItemStack(kami.tweaksntrinkets.blocks.Blocks.NetherTorchBlock, 4));

		// TODO: add serverside recipe
		RecipeBuilder.Shaped(MOD_ID)
			.addInput('S', Items.STICK)
			.addInput('O', kami.tweaksntrinkets.items.Items.ObsidianGlassShard)
			.setShape(
				"_OO",
				"OOO",
				"SO_"
			)
			.create("itemGroupObsidianDagger", new ItemStack(kami.tweaksntrinkets.items.Items.ObsidianDagger, 4));

		BlastRecipeBuilder
			.setInput(Blocks.COBBLE_NETHERRACK_IGNEOUS)
			.create(MOD_ID + ":ObsidianGlass", kami.tweaksntrinkets.blocks.Blocks.ObsidianGlass);
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
