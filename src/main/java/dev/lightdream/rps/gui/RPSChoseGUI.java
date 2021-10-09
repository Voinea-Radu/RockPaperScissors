package dev.lightdream.rps.gui;

import dev.lightdream.api.IAPI;
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

public class RPSChoseGUI extends GUI {

    private final int amount;
    private final int id;
    private final boolean create;

    public RPSChoseGUI(IAPI api, int amount) {
        super(api);
        this.amount = amount;
        this.id = -1;
        this.create = true;
    }

    @SuppressWarnings("unused")
    public RPSChoseGUI(IAPI api, int id, boolean useId) {
        super(api);
        this.amount = -1;
        this.id = id;
        this.create = false;
    }

    @Override
    public String parse(String s, Player p) {
        return (String) new MessageBuilder(s).addPlaceholders(new HashMap<String, String>() {{
            put("amount", String.valueOf(amount));
            put("id", String.valueOf(id));
        }}).parse();
    }

    @Override
    public GUIConfig setConfig() {
        return Main.instance.config.rspChoseGUI;
    }

    @Override
    public InventoryProvider getProvider() {
        return create ? new RPSChoseGUI(api, amount) : new RPSChoseGUI(api, id, true);
    }

    @Override
    public void functionCall(Player player, String function, List<String> args) {
        if (create && function.equalsIgnoreCase(GUIFunctions.PLAY_RPS.name())) {
            return;
        }
        if (!create && function.equalsIgnoreCase(GUIFunctions.CREATE_RPS.name())) {
            return;
        }
        GUIFunctions.valueOf(function.toUpperCase()).function.execute(Main.instance.databaseManager.getUser(player), args);
    }

    @Override
    public boolean canAddItem(GUIItem guiItem, String s) {
        return !guiItem.repeated;
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
