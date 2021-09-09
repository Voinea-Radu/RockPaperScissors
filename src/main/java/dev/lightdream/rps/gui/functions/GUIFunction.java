package dev.lightdream.rps.gui.functions;

import com.google.gson.JsonElement;
import dev.lightdream.api.databases.User;
import dev.lightdream.api.files.dto.GUIItem;

public interface GUIFunction {

    void execute(User user, Object args);

}
