package de.alpha.clashgame.buildingsmanagers;

import org.bukkit.entity.Player;

import de.alpha.clashcore.mysqlapi.MySQLManager;

public class GoldMineManager {
	
	public static int getAmount(Player p) {
		
		String SQL = MySQLManager.getObjectConditionResult("Doerfer", "UUID", p.getUniqueId().toString(), "GoldMinen").toString();
		int amount = Integer.parseInt(SQL);
		
		return amount;
	}
	
	public static void addAmount(int toAdd, Player p) {
		
		int current = Integer.parseInt(MySQLManager.getObjectConditionResult("Doerfer", "UUID", p.getUniqueId().toString(), "GoldMinen").toString());
		int newamount = current + toAdd;
		String amount = "" + newamount;
		
		MySQLManager.exUpdateQry("Doerfer", "UUID", p.getUniqueId().toString(), "GoldMinen", amount);
		
		//MySQLManager.exUpdateQry("BannedPlayers", "UUID", offlinePlayer.getUniqueId().toString(), "Grund", reason);
	}

}
