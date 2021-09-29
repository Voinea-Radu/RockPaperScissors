package dev.lightdream.rps.gui.functions;

import com.google.gson.JsonElement;
import dev.lightdream.api.databases.User;
import dev.lightdream.api.utils.MessageBuilder;

public interface GUIFunction {

    void execute(User user, MessageBuilder args);

}
