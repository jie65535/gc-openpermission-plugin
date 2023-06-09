# gc-openpermission-plugin

Plugin allow replacing existing command permissions.

Replaced by `console` to allow console use only.

Configuration save `replaces.json`

# Default replaces
| Original        | Replaced     |
|-----------------|--------------|
| server.stop     | console      |
| server.reload   | console      |


# All Permissions (v1.6.1)

| label               | permission                       | permissionTargeted                |
|---------------------|----------------------------------|-----------------------------------|
| list                |                                  |                                   |
| help                |                                  |                                   |
| account             |                                  |                                   |
| language            |                                  |                                   |
| position            |                                  |                                   |
| troubleshoot        | grasscutter.command.troubleshoot |                                   |
| permission          | permission                       |                                   |
| achievement         | player.achievement               | player.achievement.others         |
| clear               | player.clearinv                  | player.clearinv.others            |
| enter_dungeon       | player.enterdungeon              | player.enterdungeon.others        |
| give                | player.give                      | player.give.others                |
| group               | player.group                     | player.group.others               |
| cutscene            | player.cutscene                  | player.cutscene.others            |
| sound               | player.sound                     | player.sound.others               |
| heal                | player.heal                      | player.heal.others                |
| killCharacter       | player.killcharacter             | player.killcharacter.others       |
| quest               | player.quest                     | player.quest.others               |
| resetConst          | player.resetconstellation        | player.resetconstellation.others  |
| setConst            | player.setconstellation          | player.setconstellation.others    |
| setFetterLevel      | player.setfetterlevel            | player.setfetterlevel.others      |
| setProp             | player.setprop                   | player.setprop.others             |
| setStats            | player.setstats                  | player.setstats.others            |
| talent              | player.settalent                 | player.settalent.others           |
| team                | player.team                      | player.team.others                |
| teleport            | player.teleport                  | player.teleport.others            |
| teleportAll         | player.tpall                     | player.tpall.others               |
| trialAvatarActivity | player.trialavataractivity       | player.trialavataractivity.others |
| unlockall           | player.unlockall                 | player.unlockall.others           |
| weather             | player.weather                   | player.weather.others             |
| announce            | server.announce                  |                                   |
| unban               | server.ban                       |                                   |
| ban                 | server.ban                       |                                   |
| coop                | server.coop                      | server.coop.others                |
| entity              | server.entity                    |                                   |
| kick                |                                  | server.kick                       |
| killall             | server.killall                   | server.killall.others             |
| reload              | server.reload                    |                                   |
| resetShopLimit      | server.resetshop                 | server.resetshop.others           |
| sendMail            | server.sendmail                  |                                   |
| sendMessage         | server.sendmessage               | server.sendmessage.others         |
| spawn               | server.spawn                     | server.spawn.others               |
| stop                | server.stop                      |                                   |
