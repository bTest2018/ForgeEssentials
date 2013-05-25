package com.ForgeEssentials.permission.mcoverride;

import net.minecraft.command.CommandServerPublishLocal;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

import com.ForgeEssentials.api.APIRegistry;
import com.ForgeEssentials.api.permissions.query.PermQueryPlayer;

public class CommandPublish extends CommandServerPublishLocal
{

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender)
	{
		if (sender instanceof EntityPlayer)
			return APIRegistry.perms.checkPermAllowed(new PermQueryPlayer((EntityPlayer) sender, "Minecraft.commands." + getCommandName()));
		else
			return true;
	}
}
