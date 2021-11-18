package me.gameisntover.abilityclasses;
import me.gameisntover.abilityclasses.Classes.EndermanClass;
import me.gameisntover.abilityclasses.Classes.HeatermanClass;
import me.gameisntover.abilityclasses.GameRules.AbilityCooldown;
import me.gameisntover.abilityclasses.GameRules.GUIOnJoin;
import me.gameisntover.abilityclasses.configurationfiles.PlayerConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Warning;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Resource;
import javax.xml.ws.Action;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public final class AbilityClasses extends JavaPlugin {
     public static AbilityClasses INSTANCE;
    // Cooldown hashmap
    private final Map<String, Long> cooldown = new HashMap<>();
    @Override
    public void onEnable() {
        INSTANCE=this;
        getServer().getPluginManager().registerEvents(new GUIOnJoin(),this);
        getServer().getPluginManager().registerEvents(new EndermanClass(),this);
        getServer().getPluginManager().registerEvents(new HeatermanClass(),this);
        saveDefaultConfig();
    }
    public static AbilityClasses getInstance(){
        return INSTANCE;
    }
    @Override
    public void onDisable(String player) {
        // apply cooldown to player
        cooldown.put(player, System.currentTimeMillis() + (3 * 10));

        // check if player is in cooldown
        if (cooldown.containsKey(player)) {
            if (cooldown.get(player) > System.currentTimeMillis()) {

            }   else {
                Player player1 = Bukkit.getPlayer(player);
                PlayerConfiguration.load(player1);
                if (PlayerConfiguration.get().getString("Class").equalsIgnoreCase("Enderman")) {
                    PlayerConfiguration.load(player1);
                    player1.sendMessage(ChatColor.GREEN + "EnderPearl is Ready!");
                    PlayerConfiguration.load(player1);
                }

                else if (PlayerConfiguration.get().getString("Class").equalsIgnoreCase("Heaterman")) {
                    PlayerConfiguration.load(player1);
                    if (PlayerConfiguration.get().getString("Ability1").equalsIgnoreCase("false")) {
                        player1.sendMessage(ChatColor.GREEN + "Fireball is Ready!");
                        PlayerConfiguration.load(player1);
                        PlayerConfiguration.get().set("Ability1", "true");
                        PlayerConfiguration.save();
                    }
                    else if(PlayerConfiguration.get().getString("Ability1").equalsIgnoreCase(null)) {
                        PlayerConfiguration.get().set("Ability1","true");
                    }

                }
            }
        }
    }
}
