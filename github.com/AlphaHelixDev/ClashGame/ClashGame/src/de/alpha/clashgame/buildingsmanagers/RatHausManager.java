package de.alpha.clashgame.buildingsmanagers;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;

import de.alpha.clashcore.mysqlapi.MySQLManager;

public class RatHausManager {
	
	public static void setRatHausLvL(String newlvl , Player p) {
		MySQLManager.exUpdateQry("Doerfer", "UUID", p.getUniqueId().toString(), "RathausLvL", newlvl);
	}
	
	public static int getRatHausLvL(Player p) {
		
		String sql = MySQLManager.getObjectConditionResult("Doerfer", "UUID", p.getUniqueId().toString(), "RathausLvL").toString();
		int lvl = Integer.parseInt(sql);
		
		return lvl;
	}
	
	@SuppressWarnings("deprecation")
	public static void upgrade(Player p, String newLvL) {
		
		try {
	        WorldEditPlugin we = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
	        File schematic = new File("plugins/ClashGame/schematics/Rathaus"+newLvL+".schematic");
			EditSession session = we.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(Bukkit.getWorld(p.getName())), 1000000);
	        try {
	            MCEditSchematicFormat.getFormat(schematic).load(schematic).paste(session, new Vector(0,4,0), false);
	            setRatHausLvL(newLvL, p);
		        p.sendMessage("§7Rathaus auf Level §a" + newLvL + " geupgradet §7!");
	            return;
	        } catch (MaxChangedBlocksException
	                | com.sk89q.worldedit.data.DataException | IOException e2) {
	            // TODO Auto-generated catch block
	            e2.printStackTrace();
	        }
		} catch (Exception ignore) {
			p.sendMessage("§cError! §8: §7Please inform an §4Administrator§7!");
			ignore.printStackTrace();
		}
		
	}

}
