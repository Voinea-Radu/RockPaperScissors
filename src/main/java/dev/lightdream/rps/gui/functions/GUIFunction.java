package dev.lightdream.rps.gui.functions;

import dev.lightdream.api.databases.User;
import dev.lightdream.api.gui.GUI;

import java.util.List;

public interface GUIFunction {

    void execute(GUI gui, User user, List<String> args);

}
