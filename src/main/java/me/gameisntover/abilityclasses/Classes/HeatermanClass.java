package me.gameisntover.abilityclasses.Classes;

import me.gameisntover.abilityclasses.API.AbilityClassPlayer;
import me.gameisntover.abilityclasses.GameRules.ClassCooldowns;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class HeatermanClass implements Listener {

    @EventHandler
    public void onPlayerAction(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                PlayerData.load(player);
                if (AbilityClassPlayer.hasAbility(player, "Heaterman")) {
                    if (AbilityClassPlayer.ableToUseAbility(player, 1)) {
                        PlayerData.load(player);
                        AbilityClassPlayer.toggleAbility(player,1,false);
                        ClassCooldowns.heaterManCooldown1(player);
                        PlayerData.save();
                        player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), 12);
                        player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1, 1);
                        LargeFireball fireball = (LargeFireball) player.launchProjectile(LargeFireball.class);
                        fireball.setIsIncendiary(true);
                        fireball.setYield(0);
                        fireball.setShooter(player);
                        fireball.setVelocity(player.getLocation().getDirection().multiply(5));
                        fireball.setBounce(false);
                        fireball.setFireTicks(100);
                        player.launchProjectile(fireball.getClass());
                    } else if (!AbilityClassPlayer.ableToUseAbility(player,1) && player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                    }
                }
            }
        } else if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                PlayerData.load(player);
                if (AbilityClassPlayer.hasAbility(player, "Heaterman")) {
                    PlayerData.load(player);
                    if (AbilityClassPlayer.ableToUseAbility(player,2)) {
                        PlayerData.load(player);
                        AbilityClassPlayer.toggleAbility(player,2,false);
                        PlayerData.save();
                        player.spawnParticle(Particle.FLAME, player.getLocation(), 12);
                        player.setVelocity(player.getLocation().getDirection().setY(1));
                        ClassCooldowns.heaterManCooldown2(player);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerBurnDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            PlayerData.load(player);
            if (AbilityClassPlayer.hasAbility(player, "Heaterman")) {
                if (e.getCause() == EntityDamageEvent.DamageCause.LAVA) {
                    e.setCancelled(true);
                } else if (e.getCause() == EntityDamageEvent.DamageCause.FIRE) {
                    e.setCancelled(true);
                } else if (e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                    e.setCancelled(true);
                } else {
                    e.setCancelled(false);
                }
            }
        }
    }
}