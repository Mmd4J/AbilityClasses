package me.gameisntover.abilityclasses;
import fr.xephi.authme.api.v3.AuthMeApi;
import jdk.nashorn.internal.objects.annotations.Function;
import me.gameisntover.abilityclasses.Classes.EndermanClass;
import me.gameisntover.abilityclasses.Classes.HeatermanClass;
import me.gameisntover.abilityclasses.GameRules.AbilityCooldown;
import me.gameisntover.abilityclasses.GameRules.GUIOnJoin;
import me.gameisntover.abilityclasses.configurationfiles.PlayerConfiguration;
import me.gameisntover.kbffa.knockbackffa.KnockbackFFA;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
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
    private final Map<Player, Long> cooldown = new HashMap<>();
    @Override
    public void onEnable() {
        if (AuthMeApi.getInstance().getPlugin().getServer().getPluginManager().getPlugin("AuthMe") != null) {
            System.out.println(ChatColor.GREEN + "AuthMe plugin detected!");
        }
        INSTANCE=this;
        getServer().getPluginManager().registerEvents(new GUIOnJoin(),this);
        getServer().getPluginManager().registerEvents(new EndermanClass(),this);
        getServer().getPluginManager().registerEvents(new HeatermanClass(),this);
        saveDefaultConfig();
    }
    public void uwu(Player player) {
        // apply cooldown to player
        cooldown.put(player, System.currentTimeMillis() + (10));

        // check if player is in cooldown
        if (cooldown.containsKey(player)) {
            if (cooldown.get(player) > System.currentTimeMillis()) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.RED + "Ability cooldown "+cooldown.get(player)));
                return;
            } else if (cooldown.get(player) < System.currentTimeMillis()) {

                PlayerConfiguration.load(player);
                if (PlayerConfiguration.get().getString("Class").equalsIgnoreCase("Enderman")) {
                    PlayerConfiguration.load(player);
                    player.sendMessage(ChatColor.GREEN + "EnderPearl is Ready!");
                    PlayerConfiguration.load(player);
                } else if (PlayerConfiguration.get().getString("Class").equalsIgnoreCase("Heaterman")) {
                    PlayerConfiguration.load(player);
                    if (PlayerConfiguration.get().getString("Ability1").equalsIgnoreCase("false")) {
                        player.sendMessage(ChatColor.GREEN + "Fireball is Ready!");
                        PlayerConfiguration.load(player);
                        PlayerConfiguration.get().set("Ability1", "true");
                        PlayerConfiguration.save();
                    } else if (PlayerConfiguration.get().getString("Ability1").equalsIgnoreCase(null)) {
                        PlayerConfiguration.get().set("Ability1", "true");
                    }

                }
            }
        }
        }
    public static AbilityClasses getInstance(){
        return INSTANCE;
    }
}
