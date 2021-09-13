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

public class CancelRPSGUI extends GUI {

    private int current = 0;
    private final User user;

    public CancelRPSGUI(IAPI api, User user) {
        super(api);
        this.user = user;
    }

    @Override
    public String parse(String raw, Player player) {
        return (String) new MessageBuilder(raw).addPlaceholders(new HashMap<String, String>() {{
            //put("player", Main.instance.rpsManager.rpsGames.get(current - 1).user.name);
            put("amount", String.valueOf(Main.instance.rpsManager.rpsGames.get(current - 1).bet));
            put("id", String.valueOf(Main.instance.rpsManager.getRpsGames(user).get(current).id));
        }}).parse();
    }

    @Override
    public GUIConfig setConfig() {
        return Main.instance.config.rspGUI;
    }

    @Override
    public InventoryProvider getProvider() {
        return new CancelRPSGUI(api, user);
    }

    @Override
    public void functionCall(Player player, String function, Object args) {
        User user = Main.instance.databaseManager.getUser(player);
        GUIFunctions.valueOf(function.toUpperCase()).function.execute(user, args);
    }

    @Override
    public boolean canAddItem(GUIItem item, String s) {
        if (item.repeatedItem) {
            if (current >= Main.instance.rpsManager.getRpsGames(user).size()) {
                return false;
            }

            current++;
            return true;
        }
        return true;
    }
}
