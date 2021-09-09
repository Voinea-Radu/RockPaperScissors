package dev.lightdream.rps.commands;

import dev.lightdream.api.LightDreamPlugin;
import dev.lightdream.api.commands.Command;
import dev.lightdream.api.databases.User;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.files.dto.RPSGame;
import dev.lightdream.rps.gui.RPSChoseGUI;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class CreateCommand extends Command {

    public CreateCommand(@NotNull LightDreamPlugin plugin) {
        super(plugin, Collections.singletonList("create"), "", "", true, false, "[amount]");
    }

    @Override
    public void execute(CommandSender commandSender, List<String> args) {
        if (args.size() != 1) {
            sendUsage(commandSender);
            return;
        }

        User user = Main.instance.databaseManager.getUser(commandSender);
        int amount;

        try {
            amount = Integer.parseInt(args.get(0));
        } catch (NumberFormatException exception) {
            api.getMessageManager().sendMessage(commandSender, Main.instance.lang.invalidNumber);
            return;
        }

        new RPSChoseGUI(api, amount).open(user);
        //api.getMessageManager().sendMessage(commandSender, Main.instance.lang.matchCreated);
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, List<String> list) {
        return null;
    }
}
