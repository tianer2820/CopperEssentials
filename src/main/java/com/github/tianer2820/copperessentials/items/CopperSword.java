package com.github.tianer2820.copperessentials.items;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import com.github.tianer2820.copperessentials.constants.CommonConstants;
import com.github.tianer2820.copperessentials.utils.TextHelpers;
import com.google.common.collect.ImmutableList;

import net.kyori.adventure.text.format.NamedTextColor;

public class CopperSword {

  public static @Nonnull ItemStack getItemStack(int count){
    ItemStack stack = new ItemStack(Material.GOLDEN_SWORD, count);

    ItemMeta meta = stack.getItemMeta();
    meta.displayName(TextHelpers.normalText("Copper Sword"));
    meta.lore(ImmutableList.of(TextHelpers.italicText("Start the head hunt!", NamedTextColor.GREEN)));
    
    meta.getPersistentDataContainer().set(CommonConstants.ITEM_ID_KEY, PersistentDataType.STRING, CommonConstants.COPPER_TOOLS);
    
    stack.setItemMeta(meta);
    return stack;
  }

  public static boolean isItem(ItemStack stack){
    if(stack.getType() != Material.GOLDEN_SWORD){
      return false;
    }
    return CommonConstants.COPPER_TOOLS.equals(
            stack.getItemMeta().getPersistentDataContainer().get(CommonConstants.ITEM_ID_KEY, PersistentDataType.STRING));
  }

}