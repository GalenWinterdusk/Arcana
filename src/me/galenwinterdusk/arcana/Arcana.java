package me.galenwinterdusk.arcana;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import me.galenwinterdusk.arcana.commands.WizardCommand;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Arcana extends JavaPlugin{

	private static final Logger log = Logger.getLogger("Minecraft");
	private final ArcanaBlockListener blockListener = new ArcanaBlockListener(this);
	public final HashMap<Player, ArrayList<Block>> WizardList = new HashMap<Player, ArrayList<Block>>();
	public final HashMap<Player, ArrayList<Block>> SpellList = new HashMap<Player, ArrayList<Block>>();
		
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		log.info("Arcana DISABLED!");
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		PluginManager pm = getServer().getPluginManager();
		getCommand(WizardCommand.name).setExecutor(new WizardCommand(this));
		pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Event.Priority.Normal, this);
		log.info("Arcana ENABLED!");
		
	}
	
	public void addPlayerToWizardList(Player player)
	{
		this.WizardList.put(player, null);
		player.sendMessage("You have completed your training and become a full wizard.");	
	}
	
	public void removePlayerFromWizardList(Player player)
	{
		this.WizardList.remove(player);
		player.sendMessage("You have been stripped of your wizard status.");
	}
	
	public boolean WizardEnabled(Player playerperson)
	{
		return this.WizardList.containsKey(playerperson);
	}

}