package com.github.jie65535.openpermission;

import com.google.gson.reflect.TypeToken;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.plugin.Plugin;
import emu.grasscutter.utils.JsonUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class OpenPermissionPlugin extends Plugin {
    private Map<String, String> replaces;
    public static final String CONSOLE = "console";
    private static final Map<String, String> DEFAULT_REPLACES = new HashMap<>() {{
        put("server.stop", CONSOLE);
        put("server.reload", CONSOLE);
        put("server.announce", CONSOLE);
        put("server.ban", CONSOLE);
        put("server.kick", CONSOLE);
    }};
    private static final String REPLACES_FILE_NAME = "replaces.json";
    private OpenPermissionHandler openPermissionHandler;

    @Override
    public void onLoad() {
        loadReplaces();
    }

    @Override
    public void onEnable() {
        openPermissionHandler = new OpenPermissionHandler(this, Grasscutter.getPermissionHandler());
        Grasscutter.setPermissionHandler(openPermissionHandler);
        getLogger().info("[OpenPermission] Enabled. https://github.com/jie65535/gc-openpermission-plugin");
    }

    @Override
    public void onDisable() {
        Grasscutter.setPermissionHandler(openPermissionHandler.defaultPermissionHandler);
        getLogger().info("[OpenPermission] Disabled");
    }

    private void loadReplaces() {
        var file = new File(getDataFolder(), REPLACES_FILE_NAME);
        if (!file.exists()) {
            replaces = DEFAULT_REPLACES;
            saveReplaces();
        } else {
            try {
                replaces = JsonUtils.decode(
                        Files.readString(file.toPath(), StandardCharsets.UTF_8),
                        new TypeToken<Map<String, String>>(){}.getType()
                );
            } catch (Exception exception) {
                getLogger().error("[OpenCommand] There was an error while trying to load the data from data.json. Please make sure that there are no syntax errors. If you want to start with a default data, delete your existing data.json.");
            }
            if (replaces == null) {
                replaces = DEFAULT_REPLACES;
            }
        }
    }

    private void saveReplaces() {
        try {
            Files.writeString(
                    new File(getDataFolder(), REPLACES_FILE_NAME).toPath(),
                    JsonUtils.encode(replaces),
                    StandardCharsets.UTF_8
            );
        } catch (Exception e) {
            getLogger().error("[OpenPermission] Unable to save replaces file.");
        }
    }

    public Map<String, String> getReplaces() {
        return replaces;
    }

//    private static void scan() {
//        var commands = new Reflections("emu.grasscutter")
//                .getTypesAnnotatedWith(Command.class)
//                .stream()
//                .map(annotated -> annotated.getAnnotation(Command.class))
//                .sorted(Comparator.comparing(Command::permission))
//                .toList();
//
//        System.out.println("| label | permission | permissionTargeted |");
//        System.out.println("| ----- | ---------- | ------------------ |");
//        commands.forEach(cmdData -> System.out.printf("| %s | %s | %s |%n",
//                cmdData.label(), cmdData.permission(), cmdData.permissionTargeted()));
//    }
}
