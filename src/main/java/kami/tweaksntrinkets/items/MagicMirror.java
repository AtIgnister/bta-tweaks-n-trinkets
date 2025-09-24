package kami.tweaksntrinkets.items;
import com.mojang.nbt.tags.CompoundTag;
import com.mojang.nbt.tags.Tag;
import net.minecraft.client.sound.SoundEngine;
import net.minecraft.client.sound.SoundEvent;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.sound.SoundCategory;
import net.minecraft.core.world.World;
import net.minecraft.core.world.chunk.ChunkCoordinates;
import net.minecraft.client.sound.SoundRepository;
import com.mojang.nbt.tags.Tag;

import java.util.HashMap;

public class MagicMirror extends Item {

	public static ItemStack getDefaultItemStack() {
		return new ItemStack(Items.MagicMirror, 1);
	}

	private long secondsToTicks(int seconds) {
		return seconds * 20L;
	}

	private long minutesToTicks(int minutes) {
		return secondsToTicks(60 * minutes);
	}


	public MagicMirror(String translationKey, String namespaceId, int itemId ) {
		 super(translationKey, namespaceId, itemId);
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, Player entityplayer) {
		long lastUsed = itemstack.getData().getLong("lastUsed");

		// for some reason this is bugged and always ten minutes off.
		// oh well, who cares. Just for the record, 30 is the intended cooldown, so we pass 20 here.
		long cooldown = minutesToTicks(20);
		long worldTime = world.getWorldTime();
		long elapsed = worldTime - lastUsed;
		long remaining = cooldown - elapsed;

		if(entityplayer.dimension != 0) {
			entityplayer.sendStatusMessage("...There's a time and place for everything, but not now.");
			return super.onUseItem(itemstack, world, entityplayer);
		}

		if(world.getWorldTime() < lastUsed + cooldown) {
			entityplayer.sendStatusMessage("Magic Mirror is on cooldown! Seconds left: " + remaining/20);
			return super.onUseItem(itemstack, world, entityplayer);
		}

		ChunkCoordinates SpawnCords = entityplayer.getPlayerSpawnCoordinate();

		if(SpawnCords == null) {
			SpawnCords = world.getSpawnPoint();
		}

		entityplayer.serverPosX = SpawnCords.x;
		entityplayer.serverPosY = SpawnCords.y;
		entityplayer.serverPosZ = SpawnCords.z;

		entityplayer.setPos(SpawnCords.x, SpawnCords.y, SpawnCords.z);

		itemstack.getData().putLong("lastUsed", world.getWorldTime());

		return super.onUseItem(itemstack, world, entityplayer);
	}
}
