package dev.lightdream.rps.gui.functions;

import dev.lightdream.api.databases.User;

import java.util.List;

public interface GUIFunction {

    void execute(User user, List<String> args);

}
