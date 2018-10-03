package org.encryptsl.antibot;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.encryptsl.antibot.LISTENERS.*;
import org.encryptsl.antibot.STORAGE.VirtualStorage;

public class AntibotServices extends JavaPlugin {

    private ConsoleCommandSender consoleCommandSender = getServer().getConsoleSender();
    private PluginManager pluginManager = getServer().getPluginManager();
    private VirtualStorage virtualStorage = new VirtualStorage();
    private static AntibotServices instance;

    @Override
    public void onEnable() {
        instance = this;
        consoleCommandSender.sendMessage("§8[§6AntiBotServices§8] §aEnabled §7by §eEncryptSL §7version: §e" + getDescription().getVersion());
        getConfig().options().copyDefaults(true);
        saveConfig();
        registerListeners();
    }

    @Override
    public void onDisable() {
        consoleCommandSender.sendMessage("§8[§6AntiBotServices§8] §cDisabled §7by §eEncryptSL §7version: §e" + getDescription().getVersion());
    }

    private void registerListeners() {
        consoleCommandSender.sendMessage("§8[§6AntiBotServices§8] §7Registering / Listeners Status Ok");
        pluginManager.registerEvents(new AsyncPlayerChatEventClass(), this);
        pluginManager.registerEvents(new AsyncPreLoginEventClass(), this);
        pluginManager.registerEvents(new AuthmeListener(), this);
        pluginManager.registerEvents(new PlayerMoveEventClass(), this);
        pluginManager.registerEvents(new PlayerQuitEventClass(), this);
        pluginManager.registerEvents(new ServerListPingEventClass(), this);
    }

    public VirtualStorage getVirtualStorage() {
        return virtualStorage;
    }

    public static AntibotServices getInstance() {
        return instance;
    }
}

