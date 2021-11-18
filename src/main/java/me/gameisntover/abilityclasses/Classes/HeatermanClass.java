package me.gameisntover.abilityclasses.Classes;

import me.gameisntover.abilityclasses.configurationfiles.PlayerConfiguration;
import org.bukkit.Material;
import org.bukkit.Particle;
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
        if (e.getAction().equals(Action.LEFT_CLICK_AIR)) {
            if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                PlayerConfiguration.load(player);
                PlayerConfiguration.save();
                if (PlayerConfiguration.get().getString("Class").equalsIgnoreCase("Heaterman")) {
                    PlayerConfiguration.load(player);
                    PlayerConfiguration.save();
                    if (PlayerConfiguration.get().getString("Ability1").equalsIgnoreCase("true")) {
                        PlayerConfiguration.load(player);
                        PlayerConfiguration.get().set("Ability1", "false");
                        PlayerConfiguration.save();
                        player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), 12);
                        LargeFireball fireball = (LargeFireball) player.launchProjectile(LargeFireball.class);
                        fireball.setIsIncendiary(true);
                        fireball.setYield(0);
                        fireball.setShooter(player);
                        fireball.setVelocity(player.getLocation().getDirection().multiply(5));
                        fireball.setBounce(false);
                        fireball.setCustomName("Fireball");
                        fireball.setCustomNameVisible(true);
                        fireball.setFireTicks(100);
                        player.launchProjectile(fireball.getClass());
                    } else if (PlayerConfiguration.get().getString("Ability1").equalsIgnoreCase("false") && player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {


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
