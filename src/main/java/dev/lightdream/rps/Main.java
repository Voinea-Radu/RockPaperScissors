package dev.lightdream.rps;

import dev.lightdream.api.API;
import dev.lightdream.api.LightDreamPlugin;
import dev.lightdream.api.databases.User;
import dev.lightdream.api.files.config.SQLConfig;
import dev.lightdream.api.managers.MessageManager;
import dev.lightdream.rps.commands.BaseCommand;
import dev.lightdream.rps.commands.CreateCommand;
import dev.lightdream.rps.files.config.Config;
import dev.lightdream.rps.files.config.Lang;
import dev.lightdream.rps.managers.RPSManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public final class Main extends LightDreamPlugin {

    public static Main instance;

    //Settings
    public Config config;
    public Lang lang;

    //Managers
    public RPSManager rpsManager;

    @Override
    public void onEnable() {
        init("RockPaperScissors", "rps", "1.1");
        instance = this;

        rpsManager = new RPSManager();
    }

    @Override
    public @NotNull String parsePapi(OfflinePlayer offlinePlayer, String s) {
        return "";
    }

    @Override
    public void loadConfigs() {
        sqlConfig = fileManager.load(SQLConfig.class);
        config = fileManager.load(Config.class);
        baseConfig = config;
        lang = fileManager.load(Lang.class, fileManager.getFile(baseConfig.baseLang));
        baseLang = lang;
    }

    @Override
    public void loadBaseCommands() {
        baseCommands.add(new BaseCommand(this));
        baseCommands.add(new CreateCommand(this));
    }

    @Override
    public MessageManager instantiateMessageManager() {
        return new MessageManager(this, Main.class);
    }

    @Override
    public void registerLangManager() {
        API.instance.langManager.register(Main.class, getLangs());
    }

    @Override
    public HashMap<String, Object> getLangs() {
        HashMap<String, Object> langs = new HashMap<>();

        baseConfig.langs.forEach(lang -> {
            Lang l = fileManager.load(Lang.class, fileManager.getFile(lang));
            langs.put(lang, l);
        });

        return langs;
    }

    @Override
    public void setLang(Player player, String s) {
        User user = databaseManager.getUser(player);
        user.setLang(s);
        databaseManager.save(user);
    }
}
