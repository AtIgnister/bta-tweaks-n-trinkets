package kami.tweaksntrinkets.items;

import kami.tweaksntrinkets.TweaksNTrinkets;
import net.minecraft.core.Timer;
import net.minecraft.core.item.Item;
import net.minecraft.core.util.collection.NamespaceID;
import turniplabs.halplibe.helper.ItemBuilder;

import java.rmi.registry.Registry;

import static kami.tweaksntrinkets.IDs.newID;

public class Items {
	public static Item MagicMirror;
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
	}
}
