package dev.lightdream.rps.gui;

import dev.lightdream.api.IAPI;
import dev.lightdream.api.databases.User;
import dev.lightdream.api.dto.GUIConfig;
import dev.lightdream.api.dto.GUIItem;
import dev.lightdream.api.gui.GUI;
import dev.lightdream.api.utils.MessageBuilder;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.gui.functions.GUIFunctions;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.HashMap;
import java.util.List;

public class RPSGUI extends GUI {

    private int current = 0;

    public RPSGUI(IAPI api, User user) {
        super(api, user);
    }

    @Override
    public String parse(String raw, Player player) {
        return new MessageBuilder(raw).addPlaceholders(new HashMap<String, String>() {{
            put("player", Main.instance.rpsManager.rpsGames.get(current - 1).user.name);
            put("amount", String.valueOf(Main.instance.rpsManager.rpsGames.get(current - 1).bet));
            put("id", String.valueOf(current));
        }}).parseString();
    }

    @Override
    public GUIConfig setConfig() {
        return Main.instance.config.rspGUI;
    }

    @Override
    public InventoryProvider getProvider() {
        return new RPSGUI(api, getUser());
    }

    @Override
    public HashMap<Class<?>, Object> getArgs() {
        return new HashMap<>();
    }

    @Override
    public void setItems(Player player, InventoryContents inventoryContents) {

    }

    @Override
    public void beforeUpdate(Player player, InventoryContents inventoryContents) {

    }

    @Override
    public void onInventoryClose(InventoryCloseEvent inventoryCloseEvent) {

    }

    @Override
    public void onInventoryClick(InventoryClickEvent inventoryClickEvent) {

    }

    @Override
    public void onPlayerInventoryClick(InventoryClickEvent inventoryClickEvent) {

    }

    @Override
    public boolean preventClose() {
        return false;
    }

    @Override
    public void functionCall(Player player, String function, List<String> args) {
        User user = Main.instance.databaseManager.getUser(player);
        GUIFunctions.valueOf(function.toUpperCase()).function.execute(this, user, args);
    }

    @Override
    public boolean canAddItem(GUIItem item, String s) {
        if (item.repeated) {
            if (current >= Main.instance.rpsManager.rpsGames.size()) {
                return false;
            }

            current++;
            return true;
        }
        return true;
    }
}
