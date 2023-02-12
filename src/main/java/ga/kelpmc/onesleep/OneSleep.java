package ga.kelpmc.onesleep;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class OneSleep extends JavaPlugin implements Listener {


    private boolean isDay(long time) {
        return time > 23435 || time < 12535;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Test Load");
    }

    @EventHandler
    public void onPlayerSleeping(PlayerBedEnterEvent event) {
        World wrld = event.getPlayer().getWorld();
        if (!isDay(wrld.getTime())) {
            wrld.setTime(24000);
        }
        if (wrld.hasStorm()) {
            wrld.setStorm(false);
        }
        Bukkit.broadcastMessage(event.getPlayer().getDisplayName() + " slept to make it mornign!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
