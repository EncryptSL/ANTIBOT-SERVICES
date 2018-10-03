package org.encryptsl.antibot.LISTENERS;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.encryptsl.antibot.API.CaptchaGenerator;

public class PlayerQuitEventClass implements Listener {

    private CaptchaGenerator captchaGenerator = new CaptchaGenerator();
    @EventHandler
    public void CaptchaQuitCacheRemove(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        captchaGenerator.ClearCache(player);
    }

}
