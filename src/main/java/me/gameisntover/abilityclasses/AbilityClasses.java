package me.gameisntover.abilityclasses;
import me.gameisntover.abilityclasses.API.AbilityClassAPI;
import me.gameisntover.abilityclasses.API.AbilityClassPlayer;
import me.gameisntover.abilityclasses.Classes.EndermanClass;
import me.gameisntover.abilityclasses.Classes.Frosty;
import me.gameisntover.abilityclasses.Classes.HeatermanClass;
import me.gameisntover.abilityclasses.GameRules.JoinGUI;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class AbilityClasses extends JavaPlugin implements Listener {
    public static AbilityClasses INSTANCE;

    public void onEnable() {
        INSTANCE = this;
        saveDefaultConfig();
        registerCommands();
        loadListeners();
        loggers();
    }
    public void loggers(){
        String text1 = "Frosty and Heaterman are both enemy with eachother";
        String text2 = "Endermans are probably the only people who's survived the end";
        String text3 = "What would happen if ... Frosty shoots a snowball at Heaterman";
        String[] randomtext =  {text1,text2,text3};
        List <String> randomtextlist = Arrays.asList(randomtext);
        int random = (int) (Math.random() * randomtextlist.size());
        String randomtext1 = randomtextlist.get(random);
        this.getLogger().info(ChatColor.GREEN + "[Ability Class] : AbilityClasses has been enabled!");
        this.getLogger().info(ChatColor.GREEN + "[Ability Class] : get ready for the server journey...");
        this.getLogger().info(ChatColor.GREEN + randomtext1);
    }
    public void registerCommands(){
        getCommand("setclass").setExecutor(new Commands());
        getCommand("getclass").setExecutor(new Commands());
    }
    public void loadListeners(){
        getServer().getPluginManager().registerEvents(new JoinGUI(), this);
        getServer().getPluginManager().registerEvents(new EndermanClass(), this);
        getServer().getPluginManager().registerEvents(new HeatermanClass(), this);
        getServer().getPluginManager().registerEvents(new Frosty(), this);
        getServer().getPluginManager().registerEvents(this, this);
    }
    public static AbilityClasses getInstance() {
        return INSTANCE;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!AbilityClassPlayer.hasAbility(player)) {
            PlayerData.create(player);
            frosty(player);
            enderman(player);
            heaterman(player);
        }
    }

    public void frosty(Player player) {
        ItemStack iceMaster = new ItemStack(Material.ICE, 1);
        ItemMeta iceMasterMeta = iceMaster.getItemMeta();
        iceMasterMeta.setDisplayName(ChatColor.AQUA + "Frosty");
        List<String> iceMasterLore = new ArrayList<>();
        iceMasterLore.add(ChatColor.GRAY + "§7Frosty can use his power to control the ice!");
        iceMasterLore.add("Type : " + "Offensive");
        iceMasterLore.add(ChatColor.YELLOW + "⭐⭐⭐⭐");
        String frostyName = "&bFrosty".replace("&","§");
        AbilityClassAPI.create(frostyName.replace("&","§"), iceMaster, iceMasterMeta,iceMasterLore,"Frosty",3);
    }
    public void enderman(Player player) {
        ItemStack enderman = new ItemStack(Material.ENDER_PEARL, 1);
        ItemMeta endermanMeta = enderman.getItemMeta();
        endermanMeta.setDisplayName("§2Enderman");
        List endermanLoreList = new ArrayList<String>();
        endermanLoreList.add(ChatColor.GRAY + "Enderman doesnt likes walking in the mountain. He prefers to teleport himself it would be really faster ");
        endermanLoreList.add("Type : " + ChatColor.RED + "Supporter");
        endermanLoreList.add(ChatColor.YELLOW + "⭐⭐⭐");
        String endermanName = "&aEnderman".replace("&","§");
        AbilityClassAPI.create(endermanName.replace("&","§"), enderman, endermanMeta, endermanLoreList,"Enderman",2);
    }
    public void heaterman(Player player) {
        ItemStack heaterMan = new ItemStack(Material.BLAZE_POWDER, 1);
        ItemMeta heaterManMeta = heaterMan.getItemMeta();
        heaterManMeta.setDisplayName("§6HeaterMan");
        List heaterManLoreList = new ArrayList<String>();
        heaterManLoreList.add(ChatColor.GRAY + "Heaterman doesnt hurts in fire and his abilites are related to fire,");
        heaterManLoreList.add("Type : " + ChatColor.RED + "Offensive");
        heaterManLoreList.add(ChatColor.YELLOW + "⭐⭐⭐⭐");
        String heaterManName = "&6HeaterMan".replace("&","§");
        AbilityClassAPI.create(heaterManName.replace("&","§"), heaterMan, heaterManMeta, heaterManLoreList,"Heaterman",2);
    }
}
