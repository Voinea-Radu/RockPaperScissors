package dev.lightdream.rps.commands;

import dev.lightdream.api.LightDreamPlugin;
import dev.lightdream.api.commands.SubCommand;
import dev.lightdream.api.databases.User;
import dev.lightdream.rps.gui.RPSGUI;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseCommand extends SubCommand {
    public BaseCommand(@NotNull LightDreamPlugin plugin) {
        super(plugin, Collections.singletonList(""), "", "", true, false, "");
    }

    @Override
    public void execute(User user, List<String> list) {
        new RPSGUI(api, user).open(user);
    }

    @Override
    public List<String> onTabComplete(User user, List<String> list) {
        return new ArrayList<>();
    }
}
