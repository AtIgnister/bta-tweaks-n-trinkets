package kami.tweaksntrinkets.items;

import net.minecraft.core.entity.Mob;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemToolSword;

public class ObsidianDagger extends ItemToolSword {
	public ObsidianDagger(String name, String namespaceId, int id, ToolMaterial enumtoolmaterial) {
		super(name, namespaceId, id, enumtoolmaterial);
	}

	@Override
	public boolean hitEntity(ItemStack itemstack, Mob target, Mob attacker) {
		itemstack.damageItem(1, target);
		return super.hitEntity(itemstack, target, attacker);
	}
}
