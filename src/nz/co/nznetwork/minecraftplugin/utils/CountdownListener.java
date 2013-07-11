package nz.co.nznetwork.minecraftplugin.utils;

import org.bukkit.command.CommandSender;
public interface CountdownListener {
	public void intervalTrigger(CommandSender sender, long timeLeft);
	public void countdownComplete(CommandSender sender);
}
