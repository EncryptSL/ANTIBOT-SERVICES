package org.encryptsl.antibot.LISTENERS;

import fr.xephi.authme.api.v3.AuthMeApi;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.encryptsl.antibot.API.CaptchaGenerator;
import org.encryptsl.antibot.AntibotServices;

public class AsyncPlayerChatEventClass implements Listener {

    private CaptchaGenerator captchaGenerator = new CaptchaGenerator();
    private AuthMeApi authMeApi = AuthMeApi.getInstance();
    @EventHandler(priority = EventPriority.HIGHEST)
    public void CaptchaAnswerProtocol(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String answer = event.getMessage();
        if (authMeApi.isAuthenticated(player)) {
            if (AntibotServices.getInstance().getVirtualStorage().getPlayers().contains(player)) {
                if (AntibotServices.getInstance().getVirtualStorage().getCaptcha_code().containsValue(answer)) {
                    captchaGenerator.answer_success(player, answer);
                    event.setCancelled(true);
                } else {
                    captchaGenerator.answer_wrong(player);
                    event.setCancelled(true);
                }
            }
        }
    }

}
