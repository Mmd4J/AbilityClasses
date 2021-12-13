package me.gameisntover.abilityclasses.Classes;

import me.gameisntover.abilityclasses.API.AbilityClassPlayer;
import me.gameisntover.abilityclasses.GameRules.ClassCooldowns;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class EndermanClass implements Listener {
    @EventHandler
    public void onPlayerAction(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        PlayerData.load(player);
        if (AbilityClassPlayer.hasAbility(player,"Enderman")) {
            if (AbilityClassPlayer.ableToUseAbility(player,1)) {
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                    if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                        PlayerData.load(player);
                        AbilityClassPlayer.toggleAbility(player,1,false);
                        PlayerData.save();
                        player.getWorld().spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 12);
                        player.launchProjectile(EnderPearl.class);
                        ClassCooldowns.enderManCooldown1(player);
                    }
                }
            }
            if (AbilityClassPlayer.ableToUseAbility(player,2)) {
                if (e.getAction().equals(Action.LEFT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_AIR)) {
                    PlayerData.load(player);
                    AbilityClassPlayer.toggleAbility(player,2,false);
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
        if (AbilityClassPlayer.hasAbility((Player) player,"Enderman")) {
                if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                    e.setCancelled(true);
                }
            }
        }
    }
    }
