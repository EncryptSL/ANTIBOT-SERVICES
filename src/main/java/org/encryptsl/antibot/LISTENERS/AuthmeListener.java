package org.encryptsl.antibot.LISTENERS;

import fr.xephi.authme.events.LoginEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.encryptsl.antibot.API.CaptchaGenerator;

public class AuthmeListener implements Listener {
    private CaptchaGenerator captchaGenerator = new CaptchaGenerator();
    @EventHandler
    public void onLogin(LoginEvent event) {
        Player player = event.getPlayer();
        if(event.isLogin()) {
            captchaGenerator.generateCode(player, 654891);
            captchaGenerator.send_code(player);
        }
    }


}
