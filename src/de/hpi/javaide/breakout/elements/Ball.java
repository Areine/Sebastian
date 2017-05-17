package de.hpi.javaide.breakout.elements;

import java.awt.Dimension;
import java.awt.Point;

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
public class Ball extends Elliptic {

	private Vector direction = new Vector(0.7f, -0.7f);
	private BallStatus status = BallStatus.IN_DEPOT;

	public Ball(Game game, Point position) {
		super(game, position, new Dimension(10, 10));
	}

	public BallStatus getStatus() {
		return status;
	}

	public boolean activate()
	{
		if(status == BallStatus.IN_DEPOT)
		{
			status = BallStatus.ACTIVE;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isLost() {
		if (status == BallStatus.LOST) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void display() {
		if (isLost()) {
			return;
		}
		validatePosition();
		game.ellipse((float) getX(), (float) getY(), (float) getHeight(), (float) getWidth());
	}

	public void move() {
		float currentSpeed = game.getCurrentSpeed();
		Vector step = new Vector(direction.getX() * currentSpeed, direction.getY() * currentSpeed);
		Point newPosition = new Point(getX() + (int) step.getX(), getY() + (int) step.getY());
		update(newPosition, dimension);
		validatePosition();
	}

	private void validatePosition() {
		if (getY() > game.height) {
			status = BallStatus.LOST;
		}
	}

	public void checkCollision(Game game, Paddle paddle, Wall wall) {

		if (checkCollisionWithPaddle(paddle)) {
			return;
		}
		checkCollisionWithGameBorder(game);
	}

	private boolean checkCollisionWithPaddle(Paddle paddle) {
		if ((getRect()).intersects(paddle.getRect())) {
			invertYDirection();
			return true;
		} else {
			return false;
		}
	}

	private void checkCollisionWithGameBorder(Game game) {
		if (position.x <= 5) {
			invertXDirection();
		} else if (position.x >= (game.getWidth() - 5)) {
			invertXDirection();
		}

		if (position.y <= 5) {
			invertYDirection();
		} else if (position.y >= (game.getHeight() - 5)) {
			status = BallStatus.LOST;
		}
	}

	private void invertYDirection() {
		direction.setY(-direction.getY());
	}

	private void invertXDirection() {
		direction.setX(-direction.getX());
	}
}
