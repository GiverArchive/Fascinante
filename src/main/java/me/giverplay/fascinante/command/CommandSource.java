package me.giverplay.fascinante.command;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

// Based on Essentials and EssentialsX command system
public class CommandSource
{
  private final CommandSender sender;
  
  public CommandSource(CommandSender sender)
  {
    this.sender = sender;
  }
  
  public boolean isPlayer()
  {
    return sender instanceof Player;
  }
  
  public Player getPlayer()
  {
    if(sender instanceof Player)
      return (Player) sender;
    
    return  null;
  }
  
  public CommandSender getSender()
  {
    return this.sender;
  }
  
  public void sendMessage(String message)
  {
    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
  }
  
  public boolean hasPermissions(String permission)
  {
    return sender.hasPermission(permission);
  }
  
  public String getName()
  {
    return sender.getName();
  }
}
