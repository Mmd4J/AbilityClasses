package me.gameisntover.abilityclasses;
import com.google.common.util.concurrent.AbstractScheduledService;
import me.gameisntover.abilityclasses.Classes.EndermanClass;
import me.gameisntover.abilityclasses.Classes.HeatermanClass;
import me.gameisntover.abilityclasses.GameRules.GUIOnJoin;
import me.gameisntover.abilityclasses.configurationfiles.PlayerConfiguration;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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
        PlayerConfiguration.create(player);
    }
    }
