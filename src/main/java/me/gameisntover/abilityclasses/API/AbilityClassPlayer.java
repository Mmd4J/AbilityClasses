package me.gameisntover.abilityclasses.API;
import me.gameisntover.abilityclasses.GameRules.JoinGUI;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AbilityClassPlayer {
    public static boolean hasAbility(Player player) {
        PlayerData.load(player);
        if (PlayerData.get().getString("Class") != null) {
            return true;
        } else if (PlayerData.get().getString("Class") == null) {
            return false;
        } else {
            return false;
        }
    }

    public static boolean hasAbility(Player player, String className) {
        PlayerData.load(player);
        if (hasAbility(player)) {
            if (PlayerData.get().getString("Class").equalsIgnoreCase(className)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }



    public static String getAbilityClass(Player player) {
        PlayerData.load(player);
        return PlayerData.get().getString("Class");
    }


    public static void setAbilityClass(Player player, String className) {
        PlayerData.load(player);
        PlayerData.get().set("Class", className);
        PlayerData.save();
    }


    public static boolean ableToUseAbility(Player player, int abilitynumber) {
        PlayerData.load(player);
        return PlayerData.get().getBoolean("Ability" + abilitynumber);
    }
    public static void toggleAbility(Player player, int abilitynumber, boolean abilitytoggle) {
        PlayerData.load(player);
        PlayerData.get().set("Ability" + abilitynumber, abilitytoggle);
        PlayerData.save();
    }
}