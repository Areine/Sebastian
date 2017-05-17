package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.starter.Game;

/**
 * Blueprint for the Wall
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
// TODO die Wall wird aus Bricks gebaut.
public class Wall implements Displayable, Iterable<Brick>
{

	/**
	 * Datastructure to keep the Bricks
	 */

	int brickwidth = 60;
	int brickheight = 15;
	int bricksep = 12;
	int gamewidth = 800;
	int nbricks_per_row = 10;
	int nbricks_per_column = 5;
	int gameheightoffset = 200;

	private ArrayList<Brick> wall = new ArrayList<Brick>();

	public Wall(Game game, int i, int j)
	{
		buildWall(game, nbricks_per_column, nbricks_per_row);
	}

	@Override
	public Iterator<Brick> iterator()
	{
		return wall.iterator();
	}

	/**
	 * Build the wall by putting the single bricks into their position Hint: You
	 * might want to use one or two for-loops
	 * 
	 * @param game
	 * @param columns
	 * @param rows
	 */
	private void buildWall(Game game, int columns, int rows)
	{
		int x = 42;
		for (int i = 1; i <= nbricks_per_row; i++)
		{
			int y = 42;
			for (int j = 1; j <= nbricks_per_column; j++)
			{
				Brick brick = new Brick(game, new Point((int) x, (int) y), new Dimension(brickwidth, brickheight));
				wall.add(brick);

				if (j < 2)
				{
					brick.setColor(255, 255, 0);
				}
				if (j == 2)
				{
					brick.setColor(255, 0, 0);
				}
				if (j == 3)
				{
					brick.setColor(0, 255, 0);
				}

				if (j == 4)
				{
					brick.setColor(0, 255, 255);
				}

				if (j > 4)
				{
					brick.setColor(0, 0, 255);
				}

				y += brickheight + 14;
			}
			x += brickwidth + 14;
		}
	}

	@Override
	public void display()
	{
		for (Brick b : wall)
		{
			b.display();
		}

	}

}
