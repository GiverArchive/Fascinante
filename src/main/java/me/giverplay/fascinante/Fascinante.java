package me.giverplay.fascinante;

import me.giverplay.fascinante.command.commands.DrawCommand;
import me.giverplay.fascinante.command.commands.SetupCommand;
import me.giverplay.fascinante.render.Screen;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class Fascinante extends JavaPlugin
{
  private static Fascinante instance;
  
  private Screen screen;
  
  @Override
  public void onEnable()
  {
    getLogger().info("Starting...");
    setup();
    registerCommands();
  }
  
  @Override
  public void onDisable()
  {
    getLogger().info("Disabling...");
    
    Bukkit.getScheduler().cancelTasks(this);
    HandlerList.unregisterAll(this);
  }
  
  private void setup()
  {
    instance = this;
    screen = new Screen(this);
  }
  
  private void registerCommands()
  {
    new SetupCommand(this);
    new DrawCommand(this);
  }
  
  // ----------------------
  
  public static Fascinante getInstance()
  {
    return Fascinante.instance;
  }
  
  public Screen getScreen()
  {
    return screen;
  }
}
