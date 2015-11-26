package de.alpha.clashgame;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.alpha.clashcore.mysqlapi.MySQLAPI;
import de.alpha.clashcore.mysqlapi.MySQLDataType;
import de.alpha.clashcore.mysqlapi.MySQLManager;
import de.alpha.clashgame.inventories.BasicShopInv;
import de.alpha.clashgame.inventories.EnchInv;
import de.alpha.clashgame.inventories.TreasureShopInv;
import de.alpha.clashgame.listener.InteractListener;
import de.alpha.clashgame.listener.JoinListener;
import de.alpha.clashgame.listener.PlayerClickListener;
import de.alpha.clashgame.listener.PlayerLoginListener;

public class Core extends JavaPlugin {
	
	private static Core instance;
	
	@Override
	public void onEnable() {

		instance = this; //Instance setzen!
		
		MySQLAPI.initMySQLAPI(this);
		createTables();
		
		PluginManager pm = Bukkit.getPluginManager();
		
		// Events registrieren!
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new PlayerLoginListener(), this);
		pm.registerEvents(new PlayerClickListener(), this);
		pm.registerEvents(new InteractListener(), this);
		
		//Inventare füllen!
		BasicShopInv.fillBasicShop();
		TreasureShopInv.fillTreasureShop();
		EnchInv.fillEnchTable();
		
		Bukkit.getConsoleSender().sendMessage("§cClash §7of §cClans §7has been started! §8Creators: " + getDescription().getAuthors());
		
	}
	
	public static Core getInstance() {
		return instance;
	}
	
	private static void createTables() {
		MySQLManager.exCreateTableQry("Doerfer", MySQLManager.createColumn("PlayerName", MySQLDataType.VARCHAR, 50),
				MySQLManager.createColumn("UUID", MySQLDataType.VARCHAR, 75),
				MySQLManager.createColumn("Gold", MySQLDataType.VARCHAR, 75),
				MySQLManager.createColumn("Elexir", MySQLDataType.VARCHAR, 75),
				MySQLManager.createColumn("RathausLvL", MySQLDataType.VARCHAR, 75),
				MySQLManager.createColumn("ElexirLager", MySQLDataType.VARCHAR, 75),
				MySQLManager.createColumn("ElexirPumpen", MySQLDataType.VARCHAR, 75),
				MySQLManager.createColumn("GoldLager", MySQLDataType.VARCHAR, 75),
				MySQLManager.createColumn("GoldMinen", MySQLDataType.VARCHAR, 75));
	}

}
