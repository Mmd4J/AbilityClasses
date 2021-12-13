package me.gameisntover.abilityclasses;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.gameisntover.abilityclasses.API.AbilityClassPlayer;
import me.gameisntover.abilityclasses.configurationfiles.PlayerData;
import org.bukkit.OfflinePlayer;

public class Expansion extends PlaceholderExpansion {
    @Override
    public String getAuthor() {
        return "GaMeIsNtOvEr";
    }

    @Override
    public String getIdentifier() {
        return "abilityclasses";
    }

    @Override
    public String getVersion() {
        return "1.3";
    }
    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if(params.equalsIgnoreCase("class")) {
            return AbilityClassPlayer.getAbilityClass(player.getPlayer());
        }

        return null;
    }

}
