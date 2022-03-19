package com.sc4r.SpecterAntiAFK;

import com.sc4r.SpecterAntiAFK.Eventos.PlayerEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.sc4r.SpecterAntiAFK.Utils.AFKTask;

public class Main extends JavaPlugin {

	public static Main plugin;
	public static Main getPlugin() {
		return plugin;
	}
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
		AFKTask afk = new AFKTask();
		afk.runTaskTimer(this, 20, 4*20L);
		Bukkit.getConsoleSender().sendMessage("§b[SpecterPlugins] §fO plugin '§aSpecterAntiAFK§f' está ativo e funcional.");
		Bukkit.getConsoleSender().sendMessage("§b##############################################");
		Bukkit.getConsoleSender().sendMessage("§b#  §fPlugin idealizado por: §bSc4r.           #");
		Bukkit.getConsoleSender().sendMessage("§b#  §fPlugin desenvolvido por: §bSc4r.         #");
		Bukkit.getConsoleSender().sendMessage("§b#  §fPlugin publicado por: §bSpecterPlugins      #");
		Bukkit.getConsoleSender().sendMessage("§b##############################################");
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("§b[SpecterPlugins] §fO plugin '§cSpecterAntiAFK§f' foi desligado com êxito.");
		for (Hologram h : HologramsAPI.getHolograms(this)) {
			h.delete();
		}
	}

}
