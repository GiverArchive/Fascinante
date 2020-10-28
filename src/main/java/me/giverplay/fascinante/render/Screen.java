package me.giverplay.fascinante.render;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import me.giverplay.fascinante.Fascinante;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Screen
{
  private final Fascinante plugin;
  
  private BufferedImage image;
  private Hologram hologram;
  
  public Screen(Fascinante plugin)
  {
    this.plugin = plugin;
  }
  
  public void createScreenIfNotExists(Player player)
  {
    final Collection<Hologram> holograms = HologramsAPI.getHolograms(plugin);
    
    if(!holograms.isEmpty())
    {
      hologram = new ArrayList<>(holograms).get(0);
      return;
    }
    
    hologram = HologramsAPI.createHologram(plugin, player.getLocation());
    
    image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
    
    new BukkitRunnable(){
      @Override
      public void run()
      {
        update(image);
      }
    }.runTaskTimerAsynchronously(plugin, 10, 10);
  }
  
  public void update(BufferedImage image)
  {
    hologram.clearLines();
    
    for(int i = 0; i < 10; i++)
    {
      String line = getLine(image, i);
      hologram.appendTextLine(line);
    }
  }
  
  private String getLine(BufferedImage image, int line)
  {
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0; i < 10; i++)
    {
      sb.append(ChatColor.of(new Color(image.getRGB(line, i))));
      sb.append("■");
    }
    
    return sb.toString();
  }
  
  public Graphics getGraphics()
  {
    return image.getGraphics();
  }
}
