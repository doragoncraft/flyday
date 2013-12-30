package net.drepic.flyday;

import java.util.Calendar;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Flyday extends JavaPlugin {
	

	
	public void onEnable() {
		
		this.saveDefaultConfig();
		
		getServer().getPluginManager().registerEvents(new Listener() {
			 
            @EventHandler
            public void onJoin(PlayerJoinEvent event) {
            	Player player = event.getPlayer();
            	Calendar cal = Calendar.getInstance(); 
            	int dayOfWeek = cal.get(7);
            	String day;
            	switch(dayOfWeek) {
            	case 1: // '\001' 
            		day = "sun"; 
            		break;   
            	case 2: // '\002' 
            		day = "mon"; 
            		break;   
            	case 3: // '\003' 
            		day = "tue"; 
            		break;   
            	case 4: // '\004' 
            		day = "wed"; 
            		break;   
            	case 5: // '\005' 
            		day = "thu"; 
            		break;   
            	case 6: // '\006' 
            		day = "fri"; 
            		break;   
            	case 7: // '\007' 
            		day = "sat"; 
            		break;
            	default:
            		day = "default";
            		break;
        	    }
            	if (day.equals("fri")) {
            		player.setAllowFlight(true);
            		player.setFlying(true);
            		player.sendMessage(ChatColor.AQUA+"It's Friday! Enjoy free flying all day!");
            	} else {
            		player.setAllowFlight(false);
            		player.setFlying(false);
            	}
            }

        }, this);

		
	}
	
	
	
	

}
