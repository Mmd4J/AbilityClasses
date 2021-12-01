package me.gameisntover.abilityclasses.GameRules;

import me.gameisntover.abilityclasses.AbilityClasses;
import me.gameisntover.abilityclasses.configurationfiles.PlayerConfiguration;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class ClassCooldowns {
    public static void heaterManCooldown1(OfflinePlayer player1) {
        Player player = player1.getPlayer();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        int i = scheduler.scheduleSyncDelayedTask(AbilityClasses.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerConfiguration.load(player);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aAbility Ready!")));
                    PlayerConfiguration.get().set("Ability1", "true");
                    PlayerConfiguration.save();
                    player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1, 1);

            }
        }, 100);
    }
    public static void heaterManCooldown2(OfflinePlayer player1) {
        Player player = player1.getPlayer();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        int i = scheduler.scheduleSyncDelayedTask(AbilityClasses.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerConfiguration.load(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aJump Ready!")));
                PlayerConfiguration.get().set("Ability2", "true");
                PlayerConfiguration.save();
                player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1, 1);

            }
        },100);
    }
    public static void enderManCooldown1(OfflinePlayer player1){
        Player player = player1.getPlayer();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        int i = scheduler.scheduleSyncDelayedTask(AbilityClasses.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerConfiguration.load(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aAbility Ready!")));
                PlayerConfiguration.get().set("Ability1", "true");
                PlayerConfiguration.save();
                player.playSound(player.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_TELEPORT, 1, 2);
            }
        }, 100);
    }    public static void enderManCooldown2(OfflinePlayer player1){
        Player player = player1.getPlayer();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        int i = scheduler.scheduleSyncDelayedTask(AbilityClasses.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerConfiguration.load(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aEnderBall Ready!")));
                PlayerConfiguration.get().set("Ability2", "true");
                PlayerConfiguration.save();
                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, 1, 2);
            }
        }, 100);
    }


}
