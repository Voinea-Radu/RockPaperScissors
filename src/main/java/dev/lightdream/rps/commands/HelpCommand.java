package dev.lightdream.rps.commands;

import dev.lightdream.api.IAPI;
import dev.lightdream.api.commands.SubCommand;
import dev.lightdream.rps.Main;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelpCommand extends SubCommand {
    public HelpCommand(@NotNull IAPI api) {
        super(api, Collections.singletonList("help"), "", "", false, false, "");
    }

    @Override
    public void execute(CommandSender commandSender, List<String> list) {
        Main.instance.baseCommandManager.sendUsage(commandSender);
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, List<String> list) {
        return new ArrayList<>();
    }
}
