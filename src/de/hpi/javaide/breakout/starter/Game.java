package de.hpi.javaide.breakout.starter;

import java.awt.Point;

import de.hpi.javaide.breakout.basics.Font;
import de.hpi.javaide.breakout.screens.Screen;
import de.hpi.javaide.breakout.screens.ScreenManager;
import processing.core.PApplet;

@SuppressWarnings("serial")
public class Game extends PApplet implements GameConstants {

	private float currentSpeed = 5;
	private Point defaultBallStartPoint = new Point(50, 400);

	public float getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(float currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public Point getDefaultBallStartPoint() {
		return new Point(defaultBallStartPoint.x, defaultBallStartPoint.y);
	}

	public void setDefaultBallStartPoint(Point defaultBallStartPoint) {
		this.defaultBallStartPoint = defaultBallStartPoint;
	}

	// Setup the game
	@Override
	public void setup() {
		size(SCREEN_X, SCREEN_Y);
		background(0);
		frameRate(30);
		Font.init(this);
		ScreenManager.setScreen(this, Screen.START);
	}

	// Update and draw everything in the game
	@Override
	public void draw() {
		background(0);
		ScreenManager.getCurrentScreen().update();
		ScreenManager.getCurrentScreen().display();
	}

	// Interact with the mouse
	@Override
	public void mouseMoved() {

	}

	@Override
	public void mouseDragged() {
		ScreenManager.getCurrentScreen().handleMouseDragged();
	}

	// Interact with the keyboard
	@Override
	public void keyPressed() {
		switch (key) {
		case RETURN:
		case ENTER:
			ScreenManager.getCurrentScreen().handleKeyPressed(Screen.KEY_ENTER);
			break;
		case TAB: {
			ScreenManager.getCurrentScreen().handleKeyPressed(Screen.KEY_SPACE);
			break;
		}
		default:
			System.out.println("key:" + key + "/");
			break;
		}
	}

	@Override
	public void keyReleased() {

	}

	public void increaseScore(int i) {
		ScreenManager.getCurrentScreen().increaseScore(i);
	}
}
