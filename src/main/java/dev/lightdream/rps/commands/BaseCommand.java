package dev.lightdream.rps.commands;

import dev.lightdream.api.LightDreamPlugin;
import dev.lightdream.api.commands.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class BaseCommand extends Command {
    public BaseCommand(@NotNull LightDreamPlugin plugin) {
        super(plugin, Collections.singletonList(""), "", "", true, false, "");
    }

    @Override
    public void execute(CommandSender commandSender, List<String> list) {

    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, List<String> list) {
        return null;
    }
}
