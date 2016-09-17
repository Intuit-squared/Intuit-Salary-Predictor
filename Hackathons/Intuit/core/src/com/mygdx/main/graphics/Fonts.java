package com.mygdx.main.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Fonts {

	int viewportHeight;
	public static BitmapFont titleFont;
	public static BitmapFont textFontWhite, textFontBlack;

	public Fonts() {
		createFonts();
	}
	
	private void createFonts() {
		FileHandle fontFile = Gdx.files.internal("fonts/Roboto-Bold.ttf");
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 18;
		textFontWhite = generator.generateFont(parameter);
		parameter.size = 12;
		textFontBlack = generator.generateFont(parameter);
		textFontBlack.setColor(0, 0, 0, 1);
		parameter.size = 28;
		titleFont = generator.generateFont(parameter);
		titleFont.setColor(0, 0, 0, 1);
		generator.dispose();
	}
	
}
