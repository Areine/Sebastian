package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import de.hpi.javaide.breakout.basics.Rectangular;
import de.hpi.javaide.breakout.starter.Game;
import processing.core.PApplet;

//TODO wichtige Attribute: Größe, Position, Abstand der Bricks untereinander
//     Irgendwie muss ich herausbekommen ob der Stein noch existiert oder nicht.
public class Brick extends Rectangular
{
	int structure = 3;
	private boolean dead = false;

	public Brick(Game game, Point position, Dimension dimension)
	{
		super(game, position, dimension);
		setColor(255, 0, 0);
	}

	public boolean isDead()
	{
		return dead;
	}

	public void nextStatus()
	{
		this.structure--;

		if (this.structure == 2)
		{
			setColor(100, 100, 100);
		} else if (this.structure == 1)
		{
			setColor(200, 200, 200);
		} else if (this.structure == 0)
		{
			dead = true;
		}
	}

	@Override
	public void display()
	{
		// TODO Auto-generated method stub

		if (!dead)
		{
			game.rectMode(PApplet.CORNER);
			game.noStroke();
			game.fill(getR(), getG(), getB());
			game.rect(getX(), getY(), getWidth(), getHeight());
		}
	}

	public Rectangle getRect()
	{
		return new Rectangle(position.x, position.y, dimension.width, dimension.height);
	}

}
