package dev.lightdream.rps.gui;

import dev.lightdream.api.IAPI;
import dev.lightdream.api.databases.User;
import dev.lightdream.api.files.dto.GUIConfig;
import dev.lightdream.api.files.dto.GUIItem;
import dev.lightdream.api.gui.GUI;
import dev.lightdream.api.utils.MessageBuilder;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.gui.functions.GUIFunctions;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class RPSGUI extends GUI {

    private int current = 0;

    public RPSGUI(IAPI api) {
        super(api);
    }

    @Override
    public String parse(String raw, Player player) {
        return (String) new MessageBuilder(raw).addPlaceholders(new HashMap<String, String>() {{
            put("player", Main.instance.rpsManager.rpsGames.get(current - 1).user.name);
        }}).parse();
    }

    @Override
    public GUIConfig setConfig() {
        return Main.instance.config.rspGUI;
    }

    @Override
    public InventoryProvider getProvider() {
        return new RPSGUI(api);
    }

    @Override
    public void functionCall(Player player, String function, Object args) {
        User user = Main.instance.databaseManager.getUser(player);
        GUIFunctions.valueOf(function.toUpperCase()).function.execute(user, args);
    }

    @Override
    public boolean canAddItem(GUIItem item, String s) {
        if (item.repeatedItem) {
            if (current >= Main.instance.rpsManager.rpsGames.size()) {
                return false;
            }

            current++;
            return true;
        }
        return true;
    }
}
