package dev.lightdream.rps.commands;

import dev.lightdream.api.LightDreamPlugin;
import dev.lightdream.api.commands.SubCommand;
import dev.lightdream.api.databases.User;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.gui.RPSChoseGUI;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateCommand extends SubCommand {

    public CreateCommand(@NotNull LightDreamPlugin plugin) {
        super(plugin, Collections.singletonList("create"), "", "", true, false, "[amount]");
    }

    @Override
    public void execute(User user, List<String> args) {
        if (args.size() != 1) {
            sendUsage(user);
            return;
        }

        if (user == null) {
            api.getMessageManager().sendMessage(user, Main.instance.lang.invalidUser);
            return;
        }

        if (Main.instance.rpsManager.getRpsGames(user).size()>=Main.instance.config.maxMatches) {
            api.getMessageManager().sendMessage(user, Main.instance.lang.cannotCreateMatch);
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

        new RPSChoseGUI(api, amount, user).open(user);
    }

    @Override
    public List<String> onTabComplete(User user, List<String> list) {
        return new ArrayList<>();
    }
}
