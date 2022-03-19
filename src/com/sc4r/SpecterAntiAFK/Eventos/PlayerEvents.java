package com.sc4r.SpecterAntiAFK.Eventos;

import java.util.concurrent.TimeUnit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import com.sc4r.SpecterAntiAFK.Main;
import com.sc4r.SpecterAntiAFK.Utils.Titles;

public class PlayerEvents implements Listener{
	
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		
		if (AFKPlayer.getAfk().containsKey(e.getPlayer().getName())) {
			AFKPlayer afk = AFKPlayer.getAfk().get(e.getPlayer().getName());
			afk.getHolo().delete();
			new Titles().clearTitle(e.getPlayer());
			new Titles().resetTitle(e.getPlayer());
			e.getPlayer().sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SaiuAFK").replace("&", "§"));
			AFKPlayer.getAfk().remove(e.getPlayer().getName());
			return;
		}
		AFKPlayer.getTimer().put(e.getPlayer().getName(), (System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(Main.getPlugin().getConfig().getInt("Config.Tempo"))));
	}
	@EventHandler
	public void onMove(PlayerTeleportEvent e){
		
		if (AFKPlayer.getAfk().containsKey(e.getPlayer().getName())) {
			AFKPlayer afk = AFKPlayer.getAfk().get(e.getPlayer().getName());
			afk.getHolo().delete();
			new Titles().clearTitle(e.getPlayer());
			new Titles().resetTitle(e.getPlayer());
			e.getPlayer().sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SaiuAFK").replace("&", "§"));
			AFKPlayer.getAfk().remove(e.getPlayer().getName());
			return;
		}
		AFKPlayer.getTimer().put(e.getPlayer().getName(), (System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(Main.getPlugin().getConfig().getInt("Config.Tempo"))));
	}
	@EventHandler
	public void onMove(AsyncPlayerChatEvent e){
		
		if (AFKPlayer.getAfk().containsKey(e.getPlayer().getName())) {
			AFKPlayer afk = AFKPlayer.getAfk().get(e.getPlayer().getName());
			afk.getHolo().delete();
			new Titles().clearTitle(e.getPlayer());
			new Titles().resetTitle(e.getPlayer());
			e.getPlayer().sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SaiuAFK").replace("&", "§"));
			AFKPlayer.getAfk().remove(e.getPlayer().getName());
			return;
		}
		AFKPlayer.getTimer().put(e.getPlayer().getName(), (System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(Main.getPlugin().getConfig().getInt("Config.Tempo"))));
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e){
		AFKPlayer.getTimer().remove(e.getPlayer().getName());

		if (AFKPlayer.getAfk().containsKey(e.getPlayer().getName())) {
			AFKPlayer afk = AFKPlayer.getAfk().get(e.getPlayer().getName());
			afk.getHolo().delete();
			new Titles().clearTitle(e.getPlayer());
			new Titles().resetTitle(e.getPlayer());
			e.getPlayer().sendMessage(Main.getPlugin().getConfig().getString("Mensagens.SaiuAFK").replace("&", "§"));
			AFKPlayer.getAfk().remove(e.getPlayer().getName());
		}
	}

}
