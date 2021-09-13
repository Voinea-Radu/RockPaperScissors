package dev.lightdream.rps.commands;

import dev.lightdream.api.IAPI;
import dev.lightdream.api.commands.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class CancelCommand extends Command {
    public CancelCommand(@NotNull IAPI api) {
        super(api, Collections.singletonList("cancel"), "", "", true, false, "");
    }

    @Override
    public void execute(CommandSender commandSender, List<String> list) {

    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, List<String> list) {
        return null;
    }
}
