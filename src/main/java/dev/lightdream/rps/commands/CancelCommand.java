package dev.lightdream.rps.commands;

import dev.lightdream.api.IAPI;
import dev.lightdream.api.commands.SubCommand;
import dev.lightdream.api.databases.User;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.gui.CancelRPSGUI;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CancelCommand extends SubCommand {
    public CancelCommand(@NotNull IAPI api) {
        super(api, Collections.singletonList("cancel"), "", "", true, false, "");
    }

    @Override
    public void execute(User user, List<String> list) {
        new CancelRPSGUI(Main.instance, user).open(user);
    }

    @Override
    public List<String> onTabComplete(User user, List<String> list) {
        return new ArrayList<>();
    }
}
