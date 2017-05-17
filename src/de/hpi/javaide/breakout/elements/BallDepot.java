package de.hpi.javaide.breakout.elements;

import java.util.ArrayList;

import de.hpi.javaide.breakout.Displayable;
import de.hpi.javaide.breakout.Measureable;
import de.hpi.javaide.breakout.starter.Game;

//TODO hier werden wir sicher eine Collection brauchen um die Bälle unterzubringen.
//     Vermutlich werden wir wissen wollen wann das Depot leer ist.
//     Irgendwie müssen die Bälle an den Start gebracht werden.
public class BallDepot implements Displayable, Measureable
{

	private Game game = null;
	private ArrayList<Ball> balls = new ArrayList<Ball>();

	public BallDepot(Game game)
	{
		this.game = game;
		addBall();
		addBall();
		addBall();
	}

	private void addBall()
	{
		Ball ball = new Ball(game, game.getDefaultBallStartPoint());
		balls.add(ball);
	}

	public boolean stillHaveBallsForPlaying()
	{
		for (Ball ball : balls)
		{
			if (ball.getStatus() == BallStatus.ACTIVE || ball.getStatus() == BallStatus.IN_DEPOT)
			{
				return true;
			}
		}
		return false;
	}

	public Ball[] getActiveBalls()
	{
		ArrayList<Ball> result = new ArrayList<Ball>();
		for (Ball ball : balls)
		{
			if (ball.getStatus() == BallStatus.ACTIVE)
			{
				result.add(ball);
			}
		}
		return result.toArray(new Ball[result.size()]);
	}

	@Override
	public int getX()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void display()
	{
		Ball[] activeBalls = getActiveBalls();
		if (activeBalls != null)
		{
			for (Ball ball : activeBalls)
			{
				ball.display();
			}
		}

	}

	public boolean isEmpty()
	{
		for (Ball ball : balls)
		{
			if (!ball.isLost())
			{
				return false;
			}
		}
		return true;
	}

	public boolean hasBallInDepot()
	{
		for (Ball ball : balls)
		{
			if (ball.getStatus() == BallStatus.IN_DEPOT)
			{
				return true;
			}
		}
		return false;
	}

	public Ball dispense()
	{
		if (!hasBallInDepot())
		{
			System.out.println("All balls are in the game");
			return null;
		}

		for (Ball ball : balls)
		{
			if (ball.getStatus() == BallStatus.IN_DEPOT)
			{
				ball.activate();
				return ball;
			}
		}
		return null;
	}

}
