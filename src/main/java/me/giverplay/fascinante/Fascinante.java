package me.giverplay.fascinante;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class Fascinante extends JavaPlugin
{
  private static Fascinante instance;
  
  @Override
  public void onEnable()
  {
    getLogger().info("Starting...");
    setup();
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
  }
  
  // ----------------------
  
  public static Fascinante getInstance()
  {
    return Fascinante.instance;
  }
}
