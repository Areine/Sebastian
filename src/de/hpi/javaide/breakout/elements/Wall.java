package de.hpi.javaide.breakout.elements;

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
	
	/*
	int brickwidth = 60;
    int brickheight = 15;
    int bricksep = 2;
    int gamewidth = 800;
    // besser gamewidth aus game holen
    int gameheight = 600;
    // besser gamewidth aus game holen
    int gameheightoffset = -200;
    int nbricks_per_row = 10;
    int nbricks_per_column = 5; 
	 */
	
	private ArrayList<Brick> wall;

	public Wall(Game game, int i, int j)
	{
		/**
		 * Erzeugen der Bricks
		 */
		
		/*buildwall(game, 2, 3);
		 */
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
/*
 * for (int i = 1; i <= nbricks_per_row; i++)
 	{
	for (int j = 1; j <= nbricks_per_column; j++)
	{

        Brick brick= new Brick(game, new Point(x , y), new Dimension(brickwidth,brickheight));
        double x = gamewidth / 2 - (nbricks_per_row*brickwidth) / 2 - ((nbricks_per_row-1)*bricksep)/2 + columns*brickwidth + columns*bricksep;
        double y = gameheightoffset + rows*brickheight + rows * bricksep;
        add(brick);
        
        if (i < 2) {
        	brick.setColor(51, 0, 0);
        	 }
        if (i == 2) {
        	brick.setColor(255, 0, 0);
        	 }
        if (i == 3) {
        	brick.setColor(0, 255, 0);
        	 }
        
        if (i == 4) {
        	brick.setColor(0, 255, 255);
        	 }
        
        if (i > 4) {
        	brick.setColor(0, 0, 255);
        	 }
    }}}

 */
	}

	@Override
	public void display()
	{
/*
 * 
		for (Brick b : wall)
		{
		b.display();
		}

 */
	}
	
}
