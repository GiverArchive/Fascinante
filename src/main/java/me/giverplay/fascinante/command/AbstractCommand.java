package me.giverplay.fascinante.command;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

public abstract class AbstractCommand extends BukkitCommand
{
  protected static final List<String> COMMON_DAYS = Arrays.asList("1", "7", "30", "90", "180", "360");
  
  private static Field commandMap;
  
  protected boolean runDefault = false;
  
  public AbstractCommand(String name)
  {
    super(name);
    
    setPermissionMessage("No permission.");
    setPermission("fascinante.command." + name);
  }
  
  @Override
  public final boolean execute(CommandSender sender, String label, String[] args)
  {
    if(!testPermission(sender))
      return true;
    
    if(runDefault || !(sender instanceof Player))
    {
      return run(new CommandSource(sender), args);
    }
    
    return run((Player) sender, args);
  }
  
  public boolean run(Player player, String[] args)
  {
    player.sendMessage(ChatColor.RED + "This command is disabled.");
    return true;
  }
  
  public boolean run(CommandSource sender, String[] args)
  {
    sender.sendMessage(ChatColor.RED + "Console cannot execute this command.");
    return true;
  }
  
  protected void setRunDefault(boolean runDefault)
  {
    this.runDefault = runDefault;
  }
  
  protected boolean isRunDefault()
  {
    return this.runDefault;
  }
  
  protected List<String> getPlayers()
  {
    List<String> list = new ArrayList<>();
    
    for(Player player : Bukkit.getOnlinePlayers())
    {
      list.add(player.getName());
    }
    
    return list;
  }
  
  public void register()
  {
    try
    {
      if (commandMap == null)
      {
        commandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
        commandMap.setAccessible(true);
      }
      
      CommandMap map = (CommandMap) commandMap.get(Bukkit.getServer());
      map.register("fascinante", this);
    }
    catch(NoSuchFieldException | IllegalAccessException e)
    {
      e.printStackTrace();
    }
  }
}
