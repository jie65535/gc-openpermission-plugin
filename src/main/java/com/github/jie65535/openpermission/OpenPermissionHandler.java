package com.github.jie65535.openpermission;

import emu.grasscutter.command.PermissionHandler;
import emu.grasscutter.game.player.Player;

public class OpenPermissionHandler implements PermissionHandler {
    private final OpenPermissionPlugin plugin;
    public final PermissionHandler defaultPermissionHandler;

    public OpenPermissionHandler(OpenPermissionPlugin plugin, PermissionHandler defaultPermissionHandler) {
        this.plugin = plugin;
        this.defaultPermissionHandler = defaultPermissionHandler;
    }

    @Override
    public boolean EnablePermissionCommand() {
        return defaultPermissionHandler.EnablePermissionCommand();
    }

    @Override
    public boolean checkPermission(Player player, Player targetPlayer, String permissionNode, String permissionNodeTargeted) {
        if (player == null) return true;
        var map = plugin.getReplaces();
        if (!permissionNode.isEmpty() && map.containsKey(permissionNode)) {
            permissionNode = map.get(permissionNode);
            if (permissionNode.equals(OpenPermissionPlugin.CONSOLE))
                return false;
        }
        if (!permissionNodeTargeted.isEmpty() && map.containsKey(permissionNodeTargeted)) {
            permissionNodeTargeted = map.get(permissionNodeTargeted);
            if (player != targetPlayer && permissionNodeTargeted.equals(OpenPermissionPlugin.CONSOLE)) {
                return false;
            }
        }
        return defaultPermissionHandler.checkPermission(player, targetPlayer, permissionNode, permissionNodeTargeted);
    }
}
