package org.encryptsl.antibot.LISTENERS;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.encryptsl.antibot.AntibotServices;

public class AsyncPreLoginEventClass implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void AntiBotServicesLoginProtocol(AsyncPlayerPreLoginEvent event) {
        if(!AntibotServices.getInstance().getConfig().getStringList("AntiBotServices.WhiteListIP").contains(event.getAddress().getHostAddress())) {
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, "§8[§6AntiBotServices§8]\n §2Reason: §7FW: You are blocked on FireWall because you are bot.");
        }
    }

}
