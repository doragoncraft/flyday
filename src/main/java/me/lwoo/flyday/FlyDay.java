package me.lwoo.flyday;

import me.lwoo.flyday.Listeners.EventHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Calendar;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class FlyDay extends JavaPlugin {
    String flyday;
    ArrayList<String> daysOfWeek = new ArrayList<>();

    public void loadConfiguration() {
        this.getConfig().options().copyDefaults(true);
        this.getConfig().addDefault("day", "sunday");
        daysOfWeek.add("sunday");
        daysOfWeek.add("monday");
        daysOfWeek.add("tuesday");
        daysOfWeek.add("wednesday");
        daysOfWeek.add("thursday");
        daysOfWeek.add("friday");
        daysOfWeek.add("saturday");
        this.saveConfig();

    }

    public void onEnable() {
        loadConfiguration();
        this.saveDefaultConfig();
        flyday = this.getConfig().getString("day");

        getServer().getPluginManager().registerEvents(new EventHandler(flyday), this);
    }



    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args){
        System.out.println(args);
        if (commandLabel.equals("setflyday")){
            if(sender.hasPermission("flyday.setday")) {
                if (daysOfWeek.contains(args[0])) {
                    //Day is valid day of week
                    flyday = args[0];
                    this.getConfig().set("day", args[0]);
                    this.saveConfig();
                    sender.sendMessage(ChatColor.GOLD + "Flyday has been set to " + ChatColor.GREEN + args[0]);
                    return true;
                }
            }else{
                sender.sendMessage(ChatColor.RED + "Sorry, you don't have permission to do that");
                return true;
            }
        }
        return true;
    }


}

