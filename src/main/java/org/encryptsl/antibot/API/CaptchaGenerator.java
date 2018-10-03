package org.encryptsl.antibot.API;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.encryptsl.antibot.AntibotServices;

import java.util.Random;

public class CaptchaGenerator {
    public void generateCode(Player player, int numbers) {
        Random random = new Random();
        int code = random.nextInt(numbers);
        AntibotServices.getInstance().getVirtualStorage().getCaptcha_code().put(player.getName(), String.valueOf(code));
        AntibotServices.getInstance().getVirtualStorage().getPlayers().add(player.getPlayer());
    }

    public void send_code(Player player) {
        player.sendMessage("§8[§6AntiBotServices§8] §cYou must write to chat code " + AntibotServices.getInstance().getVirtualStorage().getCaptcha_code());
    }
    public void answer_success(Player player, String answer_code) {
        AntibotServices.getInstance().getVirtualStorage().getCaptcha_code().remove(player.getName(), answer_code);
        AntibotServices.getInstance().getVirtualStorage().getPlayers().remove(player);
        player.sendMessage("§8[§6AntiBotServices§8] §aSuccess Answer to Captcha Control :).");
    }

    public void answer_wrong(Player player) {
        Bukkit.getScheduler().runTask(AntibotServices.getInstance(), () -> player.kickPlayer("§8[§6AntiBotServices§8]\n §2Reason: §7FW: Wrong Answer"));
        ClearCache(player.getPlayer());
    }

    public void ClearCache(Player player) {
        AntibotServices.getInstance().getVirtualStorage().getCaptcha_code().remove(player.getName());
        AntibotServices.getInstance().getVirtualStorage().getPlayers().remove(player);
    }

}