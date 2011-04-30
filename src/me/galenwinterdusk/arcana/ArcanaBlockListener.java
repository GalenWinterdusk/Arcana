package me.galenwinterdusk.arcana;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;

import me.galenwinterdusk.arcana.Arcana;

public class ArcanaBlockListener extends BlockListener{
	public Arcana plugin;
	
	public ArcanaBlockListener(Arcana instance){
		this.plugin = instance;
	}
	
	public void onBlockBreak(BlockBreakEvent event){
		Block Block = event.getBlock();
		Player Player = event.getPlayer();
		if(Block.getType() == Material.TORCH && plugin.WizardEnabled(Player))
		{
			Player.sendMessage(ChatColor.RED + "Happy Fish knows you broke a TORCH!");
		}
	}
}