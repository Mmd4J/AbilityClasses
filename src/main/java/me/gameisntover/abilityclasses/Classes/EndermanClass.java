package me.gameisntover.abilityclasses.Classes;

import me.gameisntover.abilityclasses.GameRules.ClassCooldowns;
import me.gameisntover.abilityclasses.configurationfiles.PlayerConfiguration;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EndermanClass implements Listener {
    @EventHandler
    public void onPlayerAction(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                PlayerConfiguration.load(player);
                PlayerConfiguration.save();
                PlayerConfiguration.load(player);
                PlayerConfiguration.save();
                if (PlayerConfiguration.get().getString("Ability1").equalsIgnoreCase("true")) {
                    PlayerConfiguration.load(player);
                    PlayerConfiguration.get().set("Ability1", "false");
                    PlayerConfiguration.save();
                    player.getWorld().spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 12);
                    player.launchProjectile(EnderPearl.class);
                    ClassCooldowns.enderManCooldown1(player);

                }
            }
        } else if (e.getAction().equals(Action.LEFT_CLICK_BLOCK) || e.getAction().equals(Action.LEFT_CLICK_AIR)) {
            if (PlayerConfiguration.get().getString("Ability2").equalsIgnoreCase("true")) {
                PlayerConfiguration.load(player);
                PlayerConfiguration.get().set("Ability2", "false");
                PlayerConfiguration.save();
                player.getWorld().spawnParticle(Particle.DRAGON_BREATH, player.getLocation(), 12);
                DragonFireball dragonFireball = player.launchProjectile(DragonFireball.class);
                dragonFireball.setIsIncendiary(true);
                ClassCooldowns.enderManCooldown2(player);
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
            if (e.getCause()==EntityDamageEvent.DamageCause.DRAGON_BREATH){
                e.setCancelled(true);

            }
        }
    }
}