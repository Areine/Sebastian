package de.hpi.javaide.breakout.util;

import java.awt.Rectangle;

public class OutputUtil
{

	public static void outputRect(String line, Rectangle rectangle)
	{
		System.out.println(line + ": (" + rectangle.x + "/" + rectangle.y + "): width: " + rectangle.width + " heigth: "
				+ rectangle.height);
	}

}
