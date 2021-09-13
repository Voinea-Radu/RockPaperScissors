package dev.lightdream.rps.commands;

import dev.lightdream.api.LightDreamPlugin;
import dev.lightdream.api.commands.Command;
import dev.lightdream.api.databases.User;
import dev.lightdream.rps.Main;
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

        if (user == null) {
            api.getMessageManager().sendMessage(commandSender, Main.instance.lang.invalidUser);
            return;
        }

        if (Main.instance.rpsManager.getRpsGames(user).size()>=Main.instance.config.maxMatches) {
            api.getMessageManager().sendMessage(commandSender, Main.instance.lang.cannotCreateMatch);
            return;
        }

        int amount;

        try {
            amount = Integer.parseInt(args.get(0));
        } catch (NumberFormatException exception) {
            api.getMessageManager().sendMessage(user, Main.instance.lang.invalidNumber);
            return;
        }

        if(amount<Main.instance.config.minBet){
            api.getMessageManager().sendMessage(user, Main.instance.lang.mustBetAtLeast);
            return;
        }

        if (!user.hasMoney(amount)) {
            api.getMessageManager().sendMessage(user, Main.instance.lang.notEnoughMoney);
            return;
        }

        new RPSChoseGUI(api, amount).open(user);
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, List<String> list) {
        return null;
    }
}
