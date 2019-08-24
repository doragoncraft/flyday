package me.lwoo.flyday.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.util.Calendar;

public class EventHandler implements Listener {

    static String flyday;

    public EventHandler(String flyday) {
        this.flyday = flyday;
    }

    @org.bukkit.event.EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(7);
        String day;
        System.out.println(dayOfWeek);
        switch (dayOfWeek) {
            case 1: // '\001'
                day = "sunday";
                break;
            case 2: // '\002'
                day = "monday";
                break;
            case 3: // '\003'
                day = "tuesday";
                break;
            case 4: // '\004'
                day = "wednesday";
                break;
            case 5: // '\005'
                day = "thursday";
                break;
            case 6: // '\006'
                day = "friday";
                break;
            case 7: // '\007'
                day = "saturday";
                break;
            default:
                day = "default";
                break;
        }

        if (day.equals(flyday)) {
            System.out.println(day);
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage(ChatColor.AQUA + "It's Flyday! Enjoy free flying all day!");
        } else {
            player.setAllowFlight(false);
            player.setFlying(false);
        }
    }

    public static void setFlyday(String flyday) {
        EventHandler.flyday = flyday;
    }
}
