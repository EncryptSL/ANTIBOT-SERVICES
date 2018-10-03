package org.encryptsl.antibot.LISTENERS;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.encryptsl.antibot.AntibotServices;

import java.util.List;

public class ServerListPingEventClass implements Listener {
    private List<String> whitelistip = AntibotServices.getInstance().getConfig().getStringList("AntiBotServices.WhiteListIP");

    @EventHandler(priority = EventPriority.LOWEST)
    public void AntiBotServicesPingProtocol(ServerListPingEvent event) {
        if(!AntibotServices.getInstance().getConfig().getStringList("AntiBotServices.WhiteListIP").contains(event.getAddress().getHostAddress())) {

            whitelistip.add(event.getAddress().getHostAddress());
            AntibotServices.getInstance().getConfig().set("AntiBotServices.WhiteListIP", whitelistip);
            AntibotServices.getInstance().saveConfig();
        }
    }

}
