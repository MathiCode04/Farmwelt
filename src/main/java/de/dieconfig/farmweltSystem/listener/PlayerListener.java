package de.dieconfig.farmweltSystem.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendTitle("§7Willkommen auf §eFerien§6Planet", "§6» Farmwelt");

        Random rand = new Random();
        int maxAttempts = 100; // Maximale Anzahl an Versuchen für eine zufällige Position

        for (int i = 0; i < maxAttempts; i++) {
            int randX = rand.nextInt(-15000, 15000);
            int randZ = rand.nextInt(-15000, 15000);
            int baseY = 62;

            Location loc = new Location(player.getWorld(), randX, baseY, randZ);

            // Prüfe bis zu 42 Blöcke nach oben nach einer sicheren Grasblock-Position
            if (findSafeGrassLocation(loc)) {
                player.teleport(loc);
                player.sendMessage("Du wurdest sicher in die Farmwelt teleportiert!");
                break;
            }
        }
    }

    private boolean findSafeGrassLocation(Location loc) {
        for (int yOffset = 0; yOffset <= 42; yOffset++) {
            Location checkLoc = loc.clone().add(0, yOffset, 0);

            // Überprüfen, ob der Block ein Grasblock ist und die 2 Blöcke darüber Luft sind
            if (checkLoc.getBlock().getType() == Material.GRASS_BLOCK &&
                    checkLoc.clone().add(0, 1, 0).getBlock().getType() == Material.AIR &&
                    checkLoc.clone().add(0, 2, 0).getBlock().getType() == Material.AIR) {
                loc.setY(checkLoc.getY()); // Setze die Höhe zur sicheren Position
                return true;
            }
        }
        return false;
    }
}
