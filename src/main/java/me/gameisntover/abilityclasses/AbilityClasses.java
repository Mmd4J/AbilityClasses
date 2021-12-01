package me.gameisntover.abilityclasses;
import me.gameisntover.abilityclasses.Classes.EndermanClass;
import me.gameisntover.abilityclasses.Classes.HeatermanClass;
import me.gameisntover.abilityclasses.GameRules.GUIOnJoin;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
public final class AbilityClasses extends JavaPlugin {
    public static AbilityClasses INSTANCE;
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
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PlayerData.create(player);
    }
    }
