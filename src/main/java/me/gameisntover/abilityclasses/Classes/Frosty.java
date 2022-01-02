package me.gameisntover.abilityclasses.Classes;

import me.gameisntover.abilityclasses.API.AbilityKeysAPI;
import me.gameisntover.abilityclasses.API.AbilityClassPlayer;
import me.gameisntover.abilityclasses.AbilityClasses;
import me.gameisntover.abilityclasses.GameRules.ClassCooldowns;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;

import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;


public class Frosty implements Listener {
    @EventHandler
    public void onPlayerAction(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        PlayerData.load(player);
        if (AbilityClassPlayer.hasAbility(player, "Frosty")) {
            if (AbilityClassPlayer.ableToUseAbility(player, 1)) {
                if (AbilityKeysAPI.Sneaking(player) && AbilityKeysAPI.LeftClick(e, player)) {
                    if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
                        FallingBlock ice = player.getWorld().spawnFallingBlock(player.getLocation(), Material.PACKED_ICE, (byte) 0);
                        ice.setDropItem(false);
                        ice.setVelocity(player.getLocation().getDirection().multiply(1.5));
                        ice.setHurtEntities(true);
                        ice.setInvulnerable(true);
                        player.getLocation().setY(2);
                        player.spawnParticle(Particle.FIREWORKS_SPARK, player.getLocation(), 10);
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, 1, 1.4f);
                        AbilityClassPlayer.toggleAbility(player, 1, false);
                        ClassCooldowns.frostyCooldown1(player);
                    }
                }
            }
            if (AbilityClassPlayer.ableToUseAbility(player, 2)) {
                if (AbilityKeysAPI.LeftClick(e, player) && !AbilityKeysAPI.Sneaking(player)) {
                    PlayerData.load(player);
                    AbilityClassPlayer.toggleAbility(player, 2, false);
                    PlayerData.save();
                    Snowball snowball = player.launchProjectile(Snowball.class);
                    snowball.setCustomName("SnowBall");
                    ClassCooldowns.frostyCooldown2(player);
                }
            }
            if (AbilityClassPlayer.ableToUseAbility(player, 3)) {
                if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
                    if (AbilityKeysAPI.RightClick(e, player)) {
                        player.setVelocity(player.getLocation().getDirection().setY(0.5));
                        AbilityClassPlayer.toggleAbility(player, 3, false);
                        ClassCooldowns.frostyCooldown3(player);
                    }
                }
            }
        }
    }
    @EventHandler
    public void onFallingBlockLand(EntityChangeBlockEvent e) {
        Entity entity = e.getEntity();
        if (e.getEntityType() == EntityType.FALLING_BLOCK) {
            if (e.getTo() == Material.PACKED_ICE) {
                entity.getWorld().createExplosion(entity.getLocation(), 1);
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onFrostyFallDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            PlayerData.load(player);
            if (AbilityClassPlayer.hasAbility(player, "Frosty")) {
                if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                    e.setDamage(1);
                    player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1, 1);
                    player.spawnParticle(Particle.SNOW_SHOVEL, player.getLocation(), 10);
                }
            }
        }

    }
}
