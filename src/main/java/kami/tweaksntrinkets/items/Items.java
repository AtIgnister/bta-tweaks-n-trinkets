package kami.tweaksntrinkets.items;

import kami.tweaksntrinkets.TweaksNTrinkets;
import kami.tweaksntrinkets.materials.ToolMaterial;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.tool.ItemToolSword;
import turniplabs.halplibe.helper.ItemBuilder;

public class Items {
	public static Item MagicMirror;
	public static Item ObsidianGlassShard;
	public static ItemToolSword ObsidianDagger;
	private static int currentItemID = 30000;
	ItemBuilder ib = new ItemBuilder(TweaksNTrinkets.MOD_ID);

	private static int newItemID() {
		return currentItemID++;
	}

	public void Initialize() {
		MagicMirror = ib
			.setStackSize(1)
			.setMaxDamage(100)
			.build(new MagicMirror("magicmirror", TweaksNTrinkets.MOD_ID + ":MagicMirror",newItemID()));

		ObsidianGlassShard = ib
			.setStackSize(16)
			.build(new ObsidianGlassShard("obsidian_glass_shard", TweaksNTrinkets.MOD_ID + ":ObsidianGlassShard", newItemID()));

		ObsidianDagger = ib
			.setStackSize(1)
			.setMaxDamage(5)
			.build(new ObsidianDagger("obsidianDagger", TweaksNTrinkets.MOD_ID + ":ObsidianDagger", newItemID(), ToolMaterial.ObsidianGlass));
	}
}
