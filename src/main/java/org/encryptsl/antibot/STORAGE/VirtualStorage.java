package org.encryptsl.antibot.STORAGE;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class VirtualStorage {

    private Collection<Player> players = new ArrayList<>();
    private HashMap<String, String> captcha_code = new HashMap<>();
    public HashMap<String, String> getCaptcha_code() {
        return captcha_code;
    }

    public Collection<Player> getPlayers() {
        return players;
    }
}
