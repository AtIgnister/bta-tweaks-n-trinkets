package kami.tweaksntrinkets.mixins;

import kami.tweaksntrinkets.items.MagicMirror;
import net.minecraft.core.WeightedRandomBag;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeatureLabyrinth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = WorldFeatureLabyrinth.class, remap = false)
public class LabyrinthMixin {
	@Shadow
	public WeightedRandomBag<WeightedRandomLootObject> chestLoot;

	@Inject(method="pickCheckLootItem", at = @At("HEAD"))
	private void injectLoot(Random random, CallbackInfoReturnable<ItemStack> cir) {
		this.chestLoot.addEntry(new WeightedRandomLootObject(MagicMirror.getDefaultItemStack(), 1), 0.5F);
	}
}
