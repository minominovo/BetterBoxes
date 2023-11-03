package org.mino.bettershulker.event;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.recipe.CraftingBookCategory;

public class callbacks implements Listener {
    private boolean isShulkerBox(Material m) {
        switch (m) {
            case SHULKER_BOX:
            case LIGHT_GRAY_SHULKER_BOX:
            case BLACK_SHULKER_BOX:
            case BLUE_SHULKER_BOX:
            case BROWN_SHULKER_BOX:
            case CYAN_SHULKER_BOX:
            case GRAY_SHULKER_BOX:
            case GREEN_SHULKER_BOX:
            case LIGHT_BLUE_SHULKER_BOX:
            case LIME_SHULKER_BOX:
            case MAGENTA_SHULKER_BOX:
            case ORANGE_SHULKER_BOX:
            case PINK_SHULKER_BOX:
            case PURPLE_SHULKER_BOX:
            case RED_SHULKER_BOX:
            case WHITE_SHULKER_BOX:
            case YELLOW_SHULKER_BOX:
                return true;
            default:
                return false;
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getClickedBlock() == null && event.getAction() == Action.RIGHT_CLICK_AIR) {
            ItemStack Item = event.getItem();
            if (Item != null) {
                Material itemType = Item.getType();

                if (isShulkerBox(Item.getType())) {
                    ShulkerBox box = (ShulkerBox) ((BlockStateMeta) Item.getItemMeta()).getBlockState();
                    Inventory boxInventory = box.getInventory();
                    player.openInventory(boxInventory);
                    player.playSound(player.getLocation(), Sound.BLOCK_SHULKER_BOX_OPEN, 1, 1);
                } else if (itemType == Material.CRAFTING_TABLE) {
                    player.openWorkbench(null, true);
                } else if (itemType == Material.ENDER_CHEST) {
                    Inventory EnderChest = player.getEnderChest();
                    player.openInventory(EnderChest);
                    player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 1, 1);
                }
            }
        }
    }
}
