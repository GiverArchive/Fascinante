package me.giverplay.fascinante.command.commands;

import me.giverplay.fascinante.Fascinante;
import me.giverplay.fascinante.command.AbstractCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SetupCommand extends AbstractCommand
{
  private final Fascinante plugin;
  
  public SetupCommand(Fascinante plugin)
  {
    super("setup");
    register();
    
    this.plugin = plugin;
  }
  
  @Override
  public boolean run(Player player, String[] args)
  {
    player.sendMessage(ChatColor.GREEN + "Inicializando setup");
    plugin.getScreen().createScreenIfNotExists(player);
    
    return true;
  }
}
