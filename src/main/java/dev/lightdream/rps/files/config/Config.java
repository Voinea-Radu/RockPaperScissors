package dev.lightdream.rps.files.config;

import dev.lightdream.api.dto.GUIConfig;
import dev.lightdream.api.dto.GUIItem;
import dev.lightdream.api.dto.Item;
import dev.lightdream.api.dto.XMaterial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Config extends dev.lightdream.api.configs.Config {

    public int minBet = 10000;
    public int maxMatches = 5;

    @SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
    public GUIConfig rspGUI = new GUIConfig(
            "rsp_gui",
            "CHEST",
            "Rock Paper Scissors",
            6,
            new Item(XMaterial.GRAY_STAINED_GLASS_PANE, ""),
            new HashMap<String, GUIItem>() {{
                put("game_slot", new GUIItem(new Item(XMaterial.PLAYER_HEAD, 0, 1, "%player%'s RPS", "%player%", Arrays.asList(
                        "&fBet: %amount%"
                )), new GUIItem.GUIItemArgs(new HashMap<String, Object>() {{
                    put("chose_rps", "%id%");
                }}
                ), Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35,
                        36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53)
                ));
            }},
            false
    );

    public GUIConfig rspChoseGUI = new GUIConfig(
            "rsp_chose_gui",
            "CHEST",
            "Rock Paper Scissors - Chose",
            3,
            new Item(XMaterial.GRAY_STAINED_GLASS_PANE, ""),
            new HashMap<String, GUIItem>() {{
                put("rock", new GUIItem(new Item(XMaterial.PLAYER_HEAD, 11, 1, "Rock", new ArrayList<>()),
                        new GUIItem.GUIItemArgs(new HashMap<String, Object>() {{
                            put("create_rps", "%amount%|rock");
                            put("play_rps", "%id%|rock");
                            put("close_gui", "");
                        }}
                        )));
                put("paper", new GUIItem(new Item(XMaterial.PLAYER_HEAD, 13, 1, "Paper", new ArrayList<>()),
                        new GUIItem.GUIItemArgs(new HashMap<String, Object>() {{
                            put("create_rps", "%amount%|paper");
                            put("play_rps", "%id%|paper");
                            put("close_gui", "");
                        }}
                        )));
                put("scissors", new GUIItem(new Item(XMaterial.PLAYER_HEAD, 15, 1, "Scissors", new ArrayList<>()),
                        new GUIItem.GUIItemArgs(new HashMap<String, Object>() {{
                            put("create_rps", "%amount%|scissors");
                            put("play_rps", "%id%|scissors");
                            put("close_gui", "");
                        }}
                        )));
            }},
            false
    );

    public GUIConfig rpsCancelGUI = new GUIConfig(
            "rsp_cancel_gui",
            "CHEST",
            "Rock Paper Scissors - Cancel",
            6,
            new Item(XMaterial.GRAY_STAINED_GLASS_PANE, ""),
            new HashMap<String, GUIItem>() {{
                put("game_slot", new GUIItem(new Item(XMaterial.PLAYER_HEAD, 0, 1, "%player%'s RPS", "%player%", Arrays.asList(
                        "&fBet: %amount%",
                        "Play: %play%"
                )), new GUIItem.GUIItemArgs(new HashMap<String, Object>() {{
                    put("cancel_rps", "%id%");
                    put("reopen", "");
                }}), Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
                        24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54)
                ));
            }},
            false
    );


}
