package me.gameisntover.abilityclasses.Classes;

import me.gameisntover.abilityclasses.GameRules.ClassCooldowns;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import javax.xml.soap.Text;


public class EndermanClass implements Listener {
    @EventHandler
    public void onPlayerAction(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (PlayerData.get().getString("Class").equalsIgnoreCase("Enderman")) {
            PlayerData.load(player);
            if (PlayerData.get().getString("Ability1").equalsIgnoreCase("true")) {
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                    if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                        PlayerData.load(player);
                        PlayerData.get().set("Ability1", "false");
                        PlayerData.save();
                        player.getWorld().spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 12);
                        player.launchProjectile(EnderPearl.class);
                        ClassCooldowns.enderManCooldown1(player);
                    }
                }
            }
            if (PlayerData.get().getString("Ability2").equalsIgnoreCase("true")) {
                if (e.getAction().equals(Action.LEFT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_AIR)) {
                    PlayerData.load(player);
                    PlayerData.get().set("Ability2", "false");
                    PlayerData.save();
                    player.getWorld().spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 12);
                    DragonFireball dragonFireball = player.launchProjectile(DragonFireball.class);
                    dragonFireball.setIsIncendiary(true);
                    ClassCooldowns.enderManCooldown2(player);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerPearlDamage(EntityDamageEvent e) {
        Entity player = e.getEntity();
        if (player instanceof Player) {
            PlayerData.load((Player) player);
        if (PlayerData.get().getString("Class").equalsIgnoreCase("Enderman")) {
                if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                    e.setCancelled(true);
                }
            }
        }
    }
    }
