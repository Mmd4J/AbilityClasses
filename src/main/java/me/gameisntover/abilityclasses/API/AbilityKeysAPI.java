package me.gameisntover.abilityclasses.API;

import me.gameisntover.abilityclasses.AbilityClasses;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import javax.xml.soap.Text;

public class AbilityKeysAPI {
        public static boolean LeftClick(PlayerInteractEvent e, Player player) {
                if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                        return true;
                } else {
                        return false;
                }
        }

        public static boolean RightClick(PlayerInteractEvent e, Player player) {
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                        return true;
                } else {
                        return false;
                }
        }

        public static boolean Sneaking(Player player) {
                if (player.isSneaking()) {
                        return true;
                } else {
                        return false;
                }
        }
}
