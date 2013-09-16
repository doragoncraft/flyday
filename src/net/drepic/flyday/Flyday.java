package net.drepic.flyday;


import java.util.Calendar;

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
        		Calendar c = Calendar.getInstance();
        		int day = c.get(Calendar.DAY_OF_WEEK);
        		String rawJoinMessage = Flyday.this.getConfig().getString("message");
        		String joinMessage = rawJoinMessage.replace("Â", "");
        		
        		if (day == Calendar.FRIDAY) {
        		player.setAllowFlight(true);
        		player.sendMessage(joinMessage);
        		}
        		
        		
        	}

        }, this);

		
	}
	
	
	
	

}
