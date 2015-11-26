package de.alpha.clashgame.listener;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;

@SuppressWarnings("deprecation")
public class PlayerLoginListener implements Listener {
	
	private static World world;
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void PlayerLogin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		if(Bukkit.getWorld(p.getName()) == null) {
			world = Bukkit.createWorld(new WorldCreator(p.getName()).generateStructures(false).type(WorldType.FLAT));
			world.setDifficulty(Difficulty.PEACEFUL);
			
			try {
		        WorldEditPlugin we = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
		        File schematic = new File("plugins/ClashGame/schematics/Rathaus1.schematic");
		        EditSession session = we.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(world), 1000000);
		        try {
		            MCEditSchematicFormat.getFormat(schematic).load(schematic).paste(session, new Vector(0,4,0), false);
		            return;
		        } catch (MaxChangedBlocksException
		                | com.sk89q.worldedit.data.DataException | IOException e2) {
		            // TODO Auto-generated catch block
		            e2.printStackTrace();
		        }
		        p.teleport(world.getSpawnLocation());
			} catch (Exception ignore) {
				p.sendMessage("§cError! §8: §7Please inform an §4Administrator§7!");
				ignore.printStackTrace();
			}	
		}
	}
	
	public static Location getPlayerWorld() {
		return world.getSpawnLocation();
		
	}


}
