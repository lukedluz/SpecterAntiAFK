package com.sc4r.SpecterAntiAFK.Utils;

import com.sc4r.SpecterAntiAFK.Eventos.AFKPlayer;
import com.sc4r.SpecterAntiAFK.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AFKTask extends BukkitRunnable{

	@Override
	public void run() {

		for (Player p : Bukkit.getOnlinePlayers()) {
			if (AFKPlayer.getTimer().containsKey(p.getName())) {
				
				long l = AFKPlayer.getTimer().get(p.getName());
				if (l < System.currentTimeMillis()) {
					if (!AFKPlayer.getAfk().containsKey(p.getName())) {
						AFKPlayer.addAfk(p);
					}
				}
				
			}
		}
		
	}
}
