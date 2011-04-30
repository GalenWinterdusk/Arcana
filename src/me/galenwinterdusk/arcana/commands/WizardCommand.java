package me.galenwinterdusk.arcana.commands;

import java.util.ArrayList;
import java.util.HashMap;

import me.galenwinterdusk.arcana.Arcana;
import me.galenwinterdusk.arcana.ArcanaCharacter;

import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WizardCommand implements CommandExecutor  {
	public static final String name = "wizard";
	
	private Arcana plugin;
	
	public WizardCommand(Arcana plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command name, String CommandLabel,
			String[] arg3) {
		// TODO Auto-generated method stub
		// Wizard Setting Command Section

		if(sender.isOp() || sender.equals(plugin.getServer().getPlayer("Galen_Winterdusk")))
			{
			Player target = plugin.getServer().getPlayer(arg3[0]);
			String casterType = target.getcasterType();
				if()
				{
					
					target.setcasterType(null);
					sender.sendMessage(target.getDisplayName() + "has been stripped of wizard status.");
					return true;	
				}
				else
				{
					Player PlayerToAdd = plugin.getServer().getPlayer(arg3[0]);
					addPlayerToWizardList(PlayerToAdd);
					sender.sendMessage(PlayerToAdd.getDisplayName() + " has completed their training and " 
							+ "become a full wizard.");
					return true;
				}

			}
	
		// Final False Return.
		return false;
	}
	
	
	
	
}