package me.gameisntover.abilityclasses.GameRules;
import me.gameisntover.abilityclasses.API.AbilityClassAPI;
import me.gameisntover.abilityclasses.API.AbilityClassPlayer;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class JoinGUI implements Listener {
    public static Inventory classGUI = Bukkit.createInventory(null, 54, "§6Classes");

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PlayerData.load(player);
        PlayerData.get().addDefault("Class", null);
        PlayerData.save();
        if (!AbilityClassPlayer.hasAbility(player)) {
            player.sendMessage("§cYou have no class, please choose one!");
            player.openInventory(JoinGUI.classGUI);
        } else if (AbilityClassPlayer.hasAbility(player)) {
            player.sendMessage("§bYour Class : " + AbilityClassPlayer.getAbilityClass(player));
        }
    }

    @EventHandler
    public void GUIClass(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§6Classes")) {
            e.setCancelled(true);
            String iconName = e.getCurrentItem().getItemMeta().getDisplayName();
            ItemStack icon = AbilityClassAPI.abilityIconMap.get(iconName);
            if (e.getCurrentItem().getType().equals(Material.getMaterial(icon.getType().name()))) {
                PlayerData.load(player);
                AbilityClassPlayer.setAbilityClass(player, AbilityClassAPI.abilityMap.get(icon));
                AbilityClassAPI.setAbilitiesClass(player, true, AbilityClassAPI.abilitiesMap.get(icon));
                 PlayerData.save();
                player.closeInventory();

            }
        }
    }
}
