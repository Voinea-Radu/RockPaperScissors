package dev.lightdream.rps.gui.functions;

import dev.lightdream.rps.gui.functions.functions.ChoseRPS;
import dev.lightdream.rps.gui.functions.functions.CloseGUI;
import dev.lightdream.rps.gui.functions.functions.CreateRps;
import dev.lightdream.rps.gui.functions.functions.PlayRsp;

public enum GUIFunctions {

    CHOSE_RPS(new ChoseRPS()),
    PLAY_RPS(new PlayRsp()),
    CREATE_RPS(new CreateRps()),
    CLOSE_GUI(new CloseGUI());

    public GUIFunction function;

    GUIFunctions(GUIFunction function) {
        this.function = function;
    }
}
