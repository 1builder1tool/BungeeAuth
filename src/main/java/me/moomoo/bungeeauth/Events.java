package me.moomoo.bungeeauth;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.File;
public class Events implements Listener {
    @EventHandler
    public void onConnect(PostLoginEvent evt) {
        System.out.println("CONNECTION!");
        if(me.moomoo.bungeeauth.Main.config.getBoolean("Cracked")){
            boolean check = (new File(me.moomoo.bungeeauth.Main.config.getString("PlayerData3FolderCracked"), evt.getPlayer().getName() + ".dat")).exists();
            boolean check2 = (new File(me.moomoo.bungeeauth.Main.config.getString("PlayerData2FolderCracked"), evt.getPlayer().getName() + ".dat")).exists();
            if (check) {
            } else {
                if (!check && check2){
                    evt.getPlayer().disconnect(ChatColor.GOLD + "You didn't register when the server was in online mode\n\n Please join premium.1b1t.tk to verify your account.\n This measure is in place to protect your account.");
                } else {}
            }
        } else {
            boolean check = (new File(me.moomoo.bungeeauth.Main.config.getString("PlayerData3FolderPremium"), evt.getPlayer().getName() + ".dat")).exists();
            boolean check2 = (new File(me.moomoo.bungeeauth.Main.config.getString("PlayerData2FolderPremium"), evt.getPlayer().getName() + ".dat")).exists();
            if (check) {
                evt.getPlayer().disconnect(ChatColor.RED + "You are already registered... " + ChatColor.GRAY + "Connect to the ip 1b1t.tk");
            } else {
                if (!check && check2){
                    File f2 = new File(me.moomoo.bungeeauth.Main.config.getString("PlayerData2FolderPremium"), evt.getPlayer().getName() + ".dat");
                    f2.delete();
                    evt.getPlayer().disconnect(ChatColor.GOLD + "Account verification complete! You can now connect to 1b1t.tk");
                } else {
                    evt.getPlayer().disconnect(ChatColor.RED + "You are already registered or never joined... " + ChatColor.GRAY + "Connect to the ip 1b1t.tk");
                }
            }
        }

    }
}
