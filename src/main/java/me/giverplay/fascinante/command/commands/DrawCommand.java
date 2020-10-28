package me.giverplay.fascinante.command.commands;

import java.awt.Color;
import java.awt.Graphics;
import me.giverplay.fascinante.Fascinante;
import me.giverplay.fascinante.command.AbstractCommand;
import me.giverplay.fascinante.render.Screen;
import org.bukkit.entity.Player;

public class DrawCommand extends AbstractCommand
{
  private final Screen screen;
  
  public DrawCommand(Fascinante plugin)
  {
    super("draw");
    this.screen = plugin.getScreen();
    register();
  }
  
  @Override
  public boolean run(Player player, String[] args)
  {
    Graphics g = screen.getGraphics();
    g.setColor(Color.black);
    g.fillRect(0, 0, 10, 10);
    g.setColor(Color.RED);
    g.drawRect(2, 2, 5, 5);
    return true;
  }
}
