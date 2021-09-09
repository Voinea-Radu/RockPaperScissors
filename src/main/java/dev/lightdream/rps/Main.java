package dev.lightdream.rps;

import dev.lightdream.api.API;
import dev.lightdream.api.LightDreamPlugin;
import dev.lightdream.api.files.config.JdaConfig;
import dev.lightdream.api.files.config.SQLConfig;
import dev.lightdream.api.managers.MessageManager;
import dev.lightdream.rps.commands.BaseCommand;
import dev.lightdream.rps.config.Config;
import dev.lightdream.rps.config.Lang;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public final class Main extends LightDreamPlugin {

    public static Main instance;

    //Settings
    public Config config;
    public Lang lang;

    @Override
    public void onEnable() {
        init("RockPaperScissors", "rps", "1.0");
        instance = this;
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
        baseConfig.langs.forEach(lang -> {
            Lang l = fileManager.load(Lang.class, fileManager.getFile(lang));
            langs.put(lang, l);
        });
        baseLang = langs.get(baseConfig.baseLang);
    }

    @Override
    public void loadBaseCommands() {
        baseCommands.add(new BaseCommand(this));
    }

    @Override
    public MessageManager instantiateMessageManager() {
        return new MessageManager(this);
    }

    @Override
    public void registerLangManager() {
        API.instance.langManager.register(this, langs);
    }


}
