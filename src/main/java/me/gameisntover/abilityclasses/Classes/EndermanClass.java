package me.gameisntover.abilityclasses.Classes;

import me.gameisntover.abilityclasses.AbilityClasses;
import me.gameisntover.abilityclasses.GameRules.ClassCooldowns;
import me.gameisntover.abilityclasses.configurationfiles.PlayerConfiguration;
import org.bukkit.*;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.scheduler.BukkitScheduler;

public class EndermanClass implements Listener {
    @EventHandler
    public void onPlayerAction(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_AIR)) {
            if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                PlayerConfiguration.load(player);
                PlayerConfiguration.save();
                if (PlayerConfiguration.get().getString("Class").equalsIgnoreCase("Enderman")) {
                    PlayerConfiguration.load(player);
                    PlayerConfiguration.save();
                    if (PlayerConfiguration.get().getString("Ability1").equalsIgnoreCase("true")) {
                        PlayerConfiguration.load(player);
                        PlayerConfiguration.get().set("Ability1", "false");
                        PlayerConfiguration.save();
                        ClassCooldowns.enderManCooldown(player);
                        player.getWorld().spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 12);
                        player.launchProjectile(EnderPearl.class);

                    } else if (PlayerConfiguration.get().getString("Ability1").equalsIgnoreCase("false") && player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {


                    }
                }
            }
        }
    }
    @EventHandler
    public void onPlayerPearlDamage(EntityDamageEvent e) {
        Entity player = e.getEntity();
        if (player instanceof Player) {
            if (e.getCause()==EntityDamageEvent.DamageCause.FALL) {
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }
        }
    }
}