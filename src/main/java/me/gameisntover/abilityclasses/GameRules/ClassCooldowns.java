package me.gameisntover.abilityclasses.GameRules;

import me.gameisntover.abilityclasses.AbilityClasses;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
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
                PlayerData.load(player);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aAbility Ready!")));
                    PlayerData.get().set("Ability1", "true");
                    PlayerData.save();
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
                PlayerData.load(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aJump Ready!")));
                PlayerData.get().set("Ability2", "true");
                PlayerData.save();
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
                PlayerData.load(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aAbility Ready!")));
                PlayerData.get().set("Ability1", "true");
                PlayerData.save();
                player.playSound(player.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_TELEPORT, 1, 2);
            }
        }, 100);
    }    public static void enderManCooldown2(OfflinePlayer player1){
        Player player = player1.getPlayer();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        int i = scheduler.scheduleSyncDelayedTask(AbilityClasses.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerData.load(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aEnderBall Ready!")));
                PlayerData.get().set("Ability2", "true");
                PlayerData.save();
                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, 1, 2);
            }
        }, 100);
    }


}
