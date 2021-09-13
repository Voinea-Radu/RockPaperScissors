package dev.lightdream.rps.files.config;

import dev.lightdream.api.files.dto.GUIConfig;
import dev.lightdream.api.files.dto.GUIItem;
import dev.lightdream.api.files.dto.Item;
import dev.lightdream.api.files.dto.XMaterial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Config extends dev.lightdream.api.files.config.Config {

    public int minBet = 10000;
    public  int maxMatches = 5;

    public GUIConfig rspGUI = new GUIConfig(
            "rsp_gui",
            "CHEST",
            "Rock Paper Scissors",
            6,
            new Item(XMaterial.GRAY_STAINED_GLASS_PANE, ""),
            new HashMap<String, GUIItem>() {{
                put("game_slot", new GUIItem(new Item(XMaterial.PLAYER_HEAD, 0, 1, "%player%'s RPS", "%player%", Arrays.asList(
                        "&fBet: %amount%"
                )), new GUIItem.GUIItemArgs(new HashMap<Object, Object>() {{
                            put("chose_rps", "%id%");
                        }}
                        ), true));
            }}
    );

    public GUIConfig rspChoseGUI = new GUIConfig(
            "rsp_chose_gui",
            "CHEST",
            "Rock Paper Scissors - Chose",
            3,
            new Item(XMaterial.GRAY_STAINED_GLASS_PANE, ""),
            new HashMap<String, GUIItem>() {{
                put("rock", new GUIItem(new Item(XMaterial.PLAYER_HEAD, 11, 1, "Rock", new ArrayList<>()),
                        new GUIItem.GUIItemArgs(new HashMap<Object, Object>() {{
                            put("create_rps", "%amount%|rock");
                            put("play_rps", "%id%|rock");
                            put("close_gui", "");
                        }}
                        ), false));
                put("paper", new GUIItem(new Item(XMaterial.PLAYER_HEAD, 13, 1, "Paper", new ArrayList<>()),
                        new GUIItem.GUIItemArgs(new HashMap<Object, Object>() {{
                            put("create_rps", "%amount%|paper");
                            put("play_rps", "%id%|paper");
                            put("close_gui", "");
                        }}
                        ), false));
                put("scissors", new GUIItem(new Item(XMaterial.PLAYER_HEAD, 15, 1, "Scissors", new ArrayList<>()),
                        new GUIItem.GUIItemArgs(new HashMap<Object, Object>() {{
                            put("create_rps", "%amount%|scissors");
                            put("play_rps", "%id%|scissors");
                            put("close_gui", "");
                        }}
                        ), false));
            }}
    );

    public GUIConfig rspCancelGUI = new GUIConfig(
            "rsp_cancel_gui",
            "CHEST",
            "Rock Paper Scissors - Cancel",
            6,
            new Item(XMaterial.GRAY_STAINED_GLASS_PANE, ""),
            new HashMap<String, GUIItem>() {{
                put("game_slot", new GUIItem(new Item(XMaterial.PLAYER_HEAD, 0, 1, "%player%'s RPS", "%player%", Arrays.asList(
                        "&fBet: %amount%",
                        "Play: %play%"
                )), new GUIItem.GUIItemArgs(new HashMap<Object, Object>() {{
                    put("cancel_rps", "%id%");
                }}
                ), true));
            }}
    );


}
