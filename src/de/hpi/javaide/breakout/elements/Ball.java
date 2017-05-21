package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import de.hpi.javaide.breakout.basics.Elliptic;
import de.hpi.javaide.breakout.basics.Vector;
import de.hpi.javaide.breakout.starter.Game;

/**
 * Blueprint for a Ball
 * 
 * @author Ralf Teusner and Tom Staubitz
 *
 */
// TODO neben dem Ergänzen der vom Interface erwarteten Methoden,
// sollte der Ball Eigenschaften wie Größe und Richtung mitbringen.
// Richtung wird in der Regel als Vector definiert.
// Vermutlich sollte er die Richtung ändern können und sehr wahrscheinlich wird
// früher oder später
// jemand wissen wollen in welche Richtung er fliegt.
public class Ball extends Elliptic
{

	private Vector direction = new Vector(0.7f, -0.7f);
	private BallStatus status = BallStatus.IN_DEPOT;

	public Ball(Game game, Point position)
	{
		super(game, position, new Dimension(10, 10));
	}

	public BallStatus getStatus()
	{
		return status;
	}

	public boolean activate()
	{
		if (status == BallStatus.IN_DEPOT)
		{
			status = BallStatus.ACTIVE;
			return true;
		} else
		{
			return false;
		}
	}

	public boolean isLost()
	{
		if (status == BallStatus.LOST)
		{
			return true;
		} else
		{
			return false;
		}
	}

	@Override
	public void display()
	{
		if (isLost())
		{
			return;
		}
		validatePosition();
		game.fill(255);
		game.ellipse((float) getX(), (float) getY(), (float) getHeight(), (float) getWidth());
	}

	public void move()
	{
		float currentSpeed = game.getCurrentSpeed();
		Vector step = new Vector(direction.getX() * currentSpeed, direction.getY() * currentSpeed);
		Point newPosition = new Point(getX() + (int) step.getX(), getY() + (int) step.getY());
		update(newPosition, dimension);
		validatePosition();
	}

	private void validatePosition()
	{
		if (getY() > game.height)
		{
			status = BallStatus.LOST;
		}
	}

	public void checkCollision(Game game, Paddle paddle, Wall wall)
	{
		if (checkCollisionWithPaddle(paddle))
		{
			return;
		}
		if (checkCollisionWithWall(wall))
		{
			return;
		}
		checkCollisionWithGameBorder(game);
	}

	private boolean checkCollisionWithPaddle(Paddle paddle)
	{
		Rectangle ballRect = getRect();
		Rectangle paddleRect = paddle.getRect();
		if (ballRect.intersects(paddleRect))
		{
			int ballLeft = (int) ballRect.getMinX();
			int ballHeight = (int) ballRect.getHeight();
			int ballWidth = (int) ballRect.getWidth();
			int ballTop = (int) ballRect.getMinY();

			Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
			Point pointLeft = new Point(ballLeft - 1, ballTop);
			Point pointTop = new Point(ballLeft, ballTop - 1);
			Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

			if (paddleRect.contains(pointRight))
			{
				invertXDirection();
			} else if (paddleRect.contains(pointLeft))
			{
				invertXDirection();
			}

			if (paddleRect.contains(pointTop))
			{
				invertYDirection();
			} else if (paddleRect.contains(pointBottom))
			{
				invertYDirection();
			}
			return true;
		} else
		{
			return false;
		}
	}

	private boolean checkCollisionWithWall(Wall wall)
	{
		Brick[] activeBricks = wall.getActiveBricks();
		for (Brick brick : activeBricks)
		{
			Rectangle ballRect = getRect();
			Rectangle currentBrickRect = brick.getRect();
			if (currentBrickRect.intersects(ballRect))
			{
				int ballLeft = (int) ballRect.getMinX();
				int ballHeight = (int) ballRect.getHeight();
				int ballWidth = (int) ballRect.getWidth();
				int ballTop = (int) ballRect.getMinY();
				int ballMiddleY = ballTop + ballHeight / 2;

				Point pointRight = new Point(ballLeft + ballWidth + 1, ballMiddleY);
				Point pointLeft = new Point(ballLeft - 1, ballMiddleY);
				Point pointTop = new Point(ballLeft, ballTop - 1);
				Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

				if (currentBrickRect.contains(pointRight))
				{
					invertXDirection();
				} else if (currentBrickRect.contains(pointLeft))
				{
					invertXDirection();
				}

				if (currentBrickRect.contains(pointTop))
				{
					invertYDirection();
				} else if (currentBrickRect.contains(pointBottom))
				{
					invertYDirection();
				}
				brick.nextStatus();
				return true;
			}
		}
		return false;
	}

	private void checkCollisionWithGameBorder(Game game)
	{
		if (position.x <= 5)
		{
			invertXDirection();
		} else if (position.x >= (game.getWidth() - 5))
		{
			invertXDirection();
		}

		if (position.y <= 5)
		{
			invertYDirection();
		} else if (position.y >= (game.getHeight() - 5))
		{
			status = BallStatus.LOST;
		}
	}

	private void invertYDirection()
	{
		direction.setY(-direction.getY());
	}

	private void invertXDirection()
	{
		direction.setX(-direction.getX());
	}

	public Rectangle getRect()
	{
		return new Rectangle(position.x - 5, position.y - 5, dimension.width, dimension.height);
	}

}
