package org.encryptsl.antibot.LISTENERS;

import fr.xephi.authme.api.v3.AuthMeApi;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.encryptsl.antibot.AntibotServices;

public class PlayerMoveEventClass implements Listener {
    private AuthMeApi authMeApi = AuthMeApi.getInstance();

    @EventHandler(priority = EventPriority.LOW)
    public void CaptchaFreezeMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(authMeApi.isAuthenticated(player)) {
            if (AntibotServices.getInstance().getVirtualStorage().getCaptcha_code().containsKey(player.getName())) {
                event.setCancelled(true);
            }
        }
    }

}
