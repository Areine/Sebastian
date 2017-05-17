package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

import de.hpi.javaide.breakout.basics.Rectangular;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

//TODO wichtige Attribute: Größe, Position, Abstand der Bricks untereinander
//     Irgendwie muss ich herausbekommen ob der Stein noch existiert oder nicht.
public class Brick extends Rectangular
{

	public Brick(Game game, Point position, Dimension dimension)
	{
		super(game, position, dimension);
	}

	private boolean dead;

	public boolean isDead()
	{

		return dead;
	}

	public void nextStatus()
	{

	}

	@Override
	public void display()
	{
		// TODO Auto-generated method stub
		//game.noStroke();
		//game.fill(getR(), getG(), getB());
		//game.rect(getX(), getY(), getWidth(), getHeight());
	}

}
