package com.mygdx.main.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.main.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = Main.TITLE;
		config.width = Main.WIDTH;
		config.height = Main.HEIGHT;
		config.resizable = false;
		
		new LwjglApplication(new Main(), config);
	}
}
