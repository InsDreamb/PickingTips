package com.github.insdreamb.pickingtips.command.sub;

import com.github.insdreamb.pickingtips.PickingTips;
import com.github.insdreamb.pickingtips.command.CommandSub;
import com.github.insdreamb.pickingtips.util.Variable;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DisableBlock extends CommandSub {
    @Override
    public boolean execute(CommandSender commandSender, String[] args) {
        if (args.length == 2) {
            if (args[1].equalsIgnoreCase("on") || args[1].equalsIgnoreCase("off")) {
                if (args[1].equalsIgnoreCase("on")) {
                    Variable.blockingPickup.put((Player) commandSender, true);
                } else {
                    Variable.blockingPickup.put((Player) commandSender, false);
                }
                commandSender.sendMessage(getPickingTips().config.getString("message.block_" + args[1].toLowerCase()).replace("&", "§"));
                return true;
            } else {
                commandSender.sendMessage(pickingTips.config.getString("message.error_command").replace("&", "§"));
                return false;
            }
        }
        else {
            commandSender.sendMessage(pickingTips.config.getString("message.error_command").replace("&", "§"));
            return false;
        }
    }

    public DisableBlock(PickingTips pickingTips){
        super(pickingTips,"block","on/off","§7开启或关闭丢弃保护","PickingTips.block",false);
    }

}
