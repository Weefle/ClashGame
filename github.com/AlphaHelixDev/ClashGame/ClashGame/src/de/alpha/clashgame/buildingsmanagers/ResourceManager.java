package de.alpha.clashgame.buildingsmanagers;

import org.bukkit.entity.Player;

import de.alpha.clashcore.mysqlapi.MySQLManager;

public class ResourceManager {
	
	public static int getGold(Player p) {
		
		String sql = MySQLManager.getObjectConditionResult("Doerfer", "UUID", p.getUniqueId().toString(), "Gold").toString();
		int lvl = Integer.parseInt(sql);
		
		return lvl;
	}
	
	public static int getElexir(Player p) {
		
		String sql = MySQLManager.getObjectConditionResult("Doerfer", "UUID", p.getUniqueId().toString(), "Elexir").toString();
		int lvl = Integer.parseInt(sql);
		
		return lvl;
	}
	
	public static void addGold(int toAdd, Player p) {
		
		int current = Integer.parseInt(MySQLManager.getObjectConditionResult("Doerfer", "UUID", p.getUniqueId().toString(), "Gold").toString());
		int newamount = current + toAdd;
		String amount = "" + newamount;
		
		MySQLManager.exUpdateQry("Doerfer", "UUID", p.getUniqueId().toString(), "Gold", amount);
		
		//MySQLManager.exUpdateQry("BannedPlayers", "UUID", offlinePlayer.getUniqueId().toString(), "Grund", reason);
	}
	
	public static void addElexir(int toAdd, Player p) {
		
		int current = Integer.parseInt(MySQLManager.getObjectConditionResult("Doerfer", "UUID", p.getUniqueId().toString(), "Elexir").toString());
		int newamount = current + toAdd;
		String amount = "" + newamount;
		
		MySQLManager.exUpdateQry("Doerfer", "UUID", p.getUniqueId().toString(), "Elexir", amount);
		
		//MySQLManager.exUpdateQry("BannedPlayers", "UUID", offlinePlayer.getUniqueId().toString(), "Grund", reason);
	}
	
	public static void removeGold(int toRemove, Player p) {
		
		int current = Integer.parseInt(MySQLManager.getObjectConditionResult("Doerfer", "UUID", p.getUniqueId().toString(), "Gold").toString());
		int newamount = current - toRemove;
		String amount = "" + newamount;
		
		MySQLManager.exUpdateQry("Doerfer", "UUID", p.getUniqueId().toString(), "Gold", amount);
		
		//MySQLManager.exUpdateQry("BannedPlayers", "UUID", offlinePlayer.getUniqueId().toString(), "Grund", reason);
	}
	
	public static void removeElexir(int toRemove, Player p) {
		
		int current = Integer.parseInt(MySQLManager.getObjectConditionResult("Doerfer", "UUID", p.getUniqueId().toString(), "Elexir").toString());
		int newamount = current - toRemove;
		String amount = "" + newamount;
		
		MySQLManager.exUpdateQry("Doerfer", "UUID", p.getUniqueId().toString(), "Elexir", amount);
		
		//MySQLManager.exUpdateQry("BannedPlayers", "UUID", offlinePlayer.getUniqueId().toString(), "Grund", reason);
	}
	

}
