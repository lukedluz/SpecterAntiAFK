package com.sc4r.SpecterAntiAFK.Eventos;

import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.sc4r.SpecterAntiAFK.Main;
import com.sc4r.SpecterAntiAFK.Utils.Titles;
import org.bukkit.entity.Player;

import com.gmail.filoghost.holographicdisplays.api.Hologram;

import java.util.HashMap;

public class AFKPlayer {

	private Player p;
	private Hologram holo;

	private static HashMap<String, Long> timer = new HashMap<>();
	private static HashMap<String, AFKPlayer> afk = new HashMap<>();

	public static Main getInstance(){
		return Main.getPlugin(Main.class);
	}
	
	public AFKPlayer(Player p) {
		this.p = p;
	}	
	public Player getP() {
		return p;
	}

	public Hologram getHolo() {
		return holo;
	}

	public void setHolo(Hologram holo) {
		this.holo = holo;
	}

	public static HashMap<String, Long> getTimer() {
		return timer;
	}

	public static HashMap<String, AFKPlayer> getAfk() {
		return afk;
	}
	public static void addAfk(Player p) {
		AFKPlayer afk = new AFKPlayer(p);

		Hologram h = HologramsAPI.createHologram(getInstance(), p.getLocation().clone().add(0, Main.getPlugin().getConfig().getInt("Config.Altura"), 0));

		h.appendTextLine(Main.getPlugin().getConfig().getString("Mensagens.Holograma").replace("&", "§"));

		afk.setHolo(h);

		Titles th = new Titles(Main.getPlugin().getConfig().getString("Mensagens.Titulo").replace("&", "§"), Main.getPlugin().getConfig().getString("Mensagens.SubTitulo").replace("&", "§"), 1, 9999999, 1);
		//th.setStayTime(999999);
		th.send(p);

		getAfk().put(p.getName(), afk);

	}
}
