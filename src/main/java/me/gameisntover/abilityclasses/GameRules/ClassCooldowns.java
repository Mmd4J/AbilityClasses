package me.gameisntover.abilityclasses.GameRules;

import me.gameisntover.abilityclasses.API.AbilityClassPlayer;
import me.gameisntover.abilityclasses.AbilityClasses;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
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
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&eAbility Ready!")));
                AbilityClassPlayer.toggleAbility(player,1,true);
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
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&eJump Ready!")));
                AbilityClassPlayer.toggleAbility(player,2,true);
                PlayerData.save();
                player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_AMBIENT, 1, 1);

            }
        }, 100);
    }

    public static void enderManCooldown1(OfflinePlayer player1) {
        Player player = player1.getPlayer();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        int i = scheduler.scheduleSyncDelayedTask(AbilityClasses.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerData.load(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aAbility Ready!")));
                AbilityClassPlayer.toggleAbility(player,1,true);
                PlayerData.save();
                player.playSound(player.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_TELEPORT, 1, 2);
            }
        }, 100);
    }

    public static void enderManCooldown2(OfflinePlayer player1) {
        Player player = player1.getPlayer();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        int i = scheduler.scheduleSyncDelayedTask(AbilityClasses.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerData.load(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aEnderBall Ready!")));
                AbilityClassPlayer.toggleAbility(player,2,true);
                PlayerData.save();
                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, 1, 2);
            }
        }, 100);
    }

    public static void frostyCooldown1(OfflinePlayer player1) {
        Player player = player1.getPlayer();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        int i = scheduler.scheduleSyncDelayedTask(AbilityClasses.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerData.load(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&bICE Ready!")));
                AbilityClassPlayer.toggleAbility(player,1,true);
                PlayerData.save();
                player.playSound(player.getLocation(), Sound.ENTITY_SNOW_GOLEM_AMBIENT, 1, 1);

            }
        }, 120);
    }
    public static void frostyCooldown3(OfflinePlayer player1) {
        Player player = player1.getPlayer();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        int i = scheduler.scheduleSyncDelayedTask(AbilityClasses.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerData.load(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&bJump Ready!")));
                AbilityClassPlayer.toggleAbility(player,3,true);
                PlayerData.save();
                player.playSound(player.getLocation(), Sound.BLOCK_SNOW_PLACE, 1, 0.5f);

            }
        }, 80);
    }

    public static void frostyCooldown2(OfflinePlayer player1) {
        Player player = player1.getPlayer();
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        int i = scheduler.scheduleSyncDelayedTask(AbilityClasses.getInstance(), new Runnable() {
            @Override
            public void run() {
                PlayerData.load(player);
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.translateAlternateColorCodes('&', "&bAbility Ready!")));
                AbilityClassPlayer.toggleAbility(player,2,true);
                PlayerData.save();
                player.playSound(player.getLocation(), Sound.ENTITY_SNOW_GOLEM_SHOOT, 1, 1);

            }
        }, 100);
    }
    public static void frostyTrapBreak(Entity target, Block minBlock, Block maxBlock,Player  player) {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        int i = scheduler.scheduleSyncDelayedTask(AbilityClasses.getInstance(), new Runnable() {
            @Override
            public void run() {
                for (int x = minBlock.getX(); x <= maxBlock.getX(); x++) {
                    for (int y = minBlock.getY(); y <= maxBlock.getY(); y++) {
                        for (int z = minBlock.getZ(); z <= maxBlock.getZ(); z++) {
                            Block block = target.getWorld().getBlockAt(x, y, z);
                            if (block.getType().equals(Material.BLUE_ICE)) {
                                block.setType(Material.AIR);
                                player.playSound(target.getLocation(), Sound.BLOCK_GLASS_BREAK, 1, 1);

                            }
                        }
                    }
                }
            }
        }, 100);
    }

}


