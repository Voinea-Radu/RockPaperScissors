package dev.lightdream.rps.gui.functions;

import dev.lightdream.rps.gui.CancelRPSGUI;
import dev.lightdream.rps.gui.functions.functions.*;

public enum GUIFunctions {

    CHOSE_RPS(new ChoseRPS()),
    PLAY_RPS(new PlayRsp()),
    CREATE_RPS(new CreateRps()),
    CLOSE_GUI(new CloseGUI()),
    CANCEL_RPS(new CancelRps());

    public GUIFunction function;

    GUIFunctions(GUIFunction function) {
        this.function = function;
    }
}
