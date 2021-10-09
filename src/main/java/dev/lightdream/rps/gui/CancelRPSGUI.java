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

public class CancelRPSGUI extends GUI {

    private final User user;
    private int current = 0;

    public CancelRPSGUI(IAPI api, User user) {
        super(api);
        this.user = user;
    }

    @Override
    public String parse(String raw, Player player) {
        return (String) new MessageBuilder(raw).addPlaceholders(new HashMap<String, String>() {{
            put("player", Main.instance.rpsManager.rpsGames.get(current).user.name);
            put("play", Main.instance.rpsManager.rpsGames.get(current).play.toString());
            put("amount", String.valueOf(Main.instance.rpsManager.rpsGames.get(current).bet));
            put("id", String.valueOf(Main.instance.rpsManager.getRpsGames(user).get(current).id));
        }}).parse();
    }

    @Override
    public GUIConfig setConfig() {
        return Main.instance.config.rpsCancelGUI;
    }

    @Override
    public InventoryProvider getProvider() {
        return new CancelRPSGUI(api, user);
    }

    @Override
    public void functionCall(Player player, String function, List<String> args) {
        User user = Main.instance.databaseManager.getUser(player);
        GUIFunctions.valueOf(function.toUpperCase()).function.execute(user, args);
    }

    @Override
    public boolean canAddItem(GUIItem item, String s) {
        if (item.repeated) {
            if (current >= Main.instance.rpsManager.getRpsGames(user).size()) {
                return false;
            }

            current++;
            return true;
        }
        return true;
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
}
