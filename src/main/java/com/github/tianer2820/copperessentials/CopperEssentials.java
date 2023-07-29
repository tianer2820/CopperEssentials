package com.github.tianer2820.copperessentials;



import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.tianer2820.copperessentials.constants.CommonConstants;
import com.github.tianer2820.copperessentials.items.CopperAxe;
import com.github.tianer2820.copperessentials.items.CopperPickaxe;
import com.github.tianer2820.copperessentials.listeners.AxeListener;
import com.github.tianer2820.copperessentials.listeners.PickaxeListener;



public class CopperEssentials extends JavaPlugin implements Listener{
    static private CopperEssentials instance;


    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;

        CommonConstants.initializeConstants(this);

        registerCommands();
        registerListeners();
        registerRecipies();
    }

    public static CopperEssentials getInstance(){
        return instance;
    }
    
    private void registerCommands(){
    }

    private void registerListeners(){
        PluginManager manager = getServer().getPluginManager();

        manager.registerEvents(new PickaxeListener(), this);
        manager.registerEvents(new AxeListener(), this);
    }

    private void registerRecipies(){
        // copper pickaxe
        ShapedRecipe recipe = new ShapedRecipe(CommonConstants.COPPER_PICKAXE_RECIPE_KEY, CopperPickaxe.getItemStack(1));
        recipe.shape(
                "CCC",
                " I ",
                " I ");
        recipe.setIngredient('C', Material.COPPER_INGOT);
        recipe.setIngredient('I', Material.STICK);
        getServer().addRecipe(recipe);

        // copper axe
        recipe = new ShapedRecipe(CommonConstants.COPPER_AXE_RECIPE_KEY, CopperAxe.getItemStack(1));
        recipe.shape(
            " CC",
            " IC",
            " I ");
        recipe.setIngredient('C', Material.COPPER_INGOT);
        recipe.setIngredient('I', Material.STICK);
        getServer().addRecipe(recipe);

    }
}