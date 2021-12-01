package me.gameisntover.abilityclasses.Classes;

import me.gameisntover.abilityclasses.GameRules.ClassCooldowns;
import me.gameisntover.abilityclasses.configurationfiles.PlayerConfiguration;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

public class HeatermanClass implements Listener {

    @EventHandler
    public void onPlayerAction(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                PlayerConfiguration.load(player);
                PlayerConfiguration.save();
                if (PlayerConfiguration.get().getString("Class").equalsIgnoreCase("Heaterman")) {
                    PlayerConfiguration.load(player);
                    if (PlayerConfiguration.get().getString("Ability1").equalsIgnoreCase("true")) {
                        PlayerConfiguration.load(player);
                        PlayerConfiguration.get().set("Ability1", "false");
                        ClassCooldowns.heaterManCooldown1(player);
                        PlayerConfiguration.save();
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
                    } else if (PlayerConfiguration.get().getString("Ability1").equalsIgnoreCase("false") && player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                    }
                }
            }
        }
          else  if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                    PlayerConfiguration.load(player);
                    if (PlayerConfiguration.get().getString("Class").equalsIgnoreCase("Heaterman")) {
                        PlayerConfiguration.load(player);
                        if (PlayerConfiguration.get().getString("Ability2").equalsIgnoreCase("true")) {
                            PlayerConfiguration.load(player);
                            PlayerConfiguration.get().set("Ability2", "false");
                            PlayerConfiguration.save();
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
        Entity player = e.getEntity();
        if (player instanceof Player) {
            if (e.getCause()==EntityDamageEvent.DamageCause.LAVA ) {
                e.setCancelled(true);
            }else if ( e.getCause()==EntityDamageEvent.DamageCause.FIRE){
                e.setCancelled(true);
            }    else if ( e.getCause()==EntityDamageEvent.DamageCause.FIRE_TICK){
            e.setCancelled(true);
        }
            else {
                e.setCancelled(false);
            }
        }
    }

}
