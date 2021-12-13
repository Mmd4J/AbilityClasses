package me.gameisntover.abilityclasses.API;

import me.gameisntover.abilityclasses.GameRules.JoinGUI;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AbilityClassAPI {
    public static Map<ItemStack, String> abilityMap = new HashMap<>();
    public static Map<String, ItemStack> abilityIconMap = new HashMap<>();
    public static Map <ItemStack,Integer> abilitiesMap = new HashMap<>();
    public static void create(String className, ItemStack icon, ItemMeta iconMeta, List lore, String configClassName, int abilities) {
        if (!JoinGUI.classGUI.contains(icon)) {
            iconMeta.setDisplayName(className);
            iconMeta.setLore(lore);
            icon.setItemMeta(iconMeta);
            JoinGUI.classGUI.addItem(icon);
            abilityIconMap.put(iconMeta.getDisplayName(), icon);
            abilityMap.put(icon, configClassName);
            abilitiesMap.put(icon,abilities);
        } else {
        }
    }
    public static void setAbilitiesClass(Player player, boolean abilitytoggle, int abilitynumber ) {
        PlayerData.load(player);
        for (int a = 1; a <= abilitynumber; a++) {
            PlayerData.get().set("Ability" + a, abilitytoggle);
            PlayerData.save();
        }
    }

}
