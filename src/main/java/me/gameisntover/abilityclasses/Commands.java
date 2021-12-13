package me.gameisntover.abilityclasses;

import me.gameisntover.abilityclasses.API.AbilityClassPlayer;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("setclass")) {
                if (args.length > 0) {
                    if (sender instanceof Player) {
                         sender.sendMessage("[Ability Class] : "+ "&aYour class has been changed to ".replace("&","") + args[1]);
                        AbilityClassPlayer.setAbilityClass((Player) sender, args[0]);
                    }else {
                        sender.sendMessage("[Ability Class] : "+"You must be a player to use this command!");
                    }
                }else if(args.length > 1){
                    if(Bukkit.getPlayer(args[0]).isOnline()){
                        Player player = Bukkit.getPlayer(args[0]);
                        player.sendMessage("[Ability Class] : "+ "&aYour class has been changed to ".replace("&","") + args[1]);
                        sender.sendMessage("[Ability Class] : "+ "You have changed " + player.getName() + "'s class to " + args[1]);
                        AbilityClassPlayer.setAbilityClass(Bukkit.getPlayer(args[0]), args[1]);
                    }
                }
            } else if(command.getName().equalsIgnoreCase("getclass")){
                if(args.length > 0){
                    if(Bukkit.getPlayer(args[0]).isOnline()){
                        Player player = Bukkit.getPlayer(args[0]);
                        if (!AbilityClassPlayer.hasAbility(player)) {
                            sender.sendMessage("[Ability Class] : "+ChatColor.RED+ player.getName() + " has no class!");
                        } else {
                            sender.sendMessage("[Ability Class] : " + ChatColor.GREEN + player.getName() + " is " + AbilityClassPlayer.getAbilityClass(player));
                        }
                        } else {
                        sender.sendMessage("[Ability Class] : "+ChatColor.RED + "Player is not online!");
                    }
                }
        }
            return false;
        }
    }
