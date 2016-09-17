package com.mygdx.main.page_stuff;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.main.Main;
import com.mygdx.main.graphics.Fonts;
import com.mygdx.main.graphics.Textures;

public class Page {

	String question;
	List<String> answers;
	Sprite background, topSprite, endSprite;
	String ellipse = "";
	int ellipseCount = 0;
	int endCount = 0;

	BitmapFont font;

	boolean moving = false;
	boolean top = false;
	boolean end = false;
	int yOffset = 0;

	boolean mouseDown = false, prevMouseDown = false;

	public Page(String question, List<String> answers) {
		this.question = question;
		this.answers = answers;
		background = new Sprite(Textures.BACKGROUND);
		topSprite = new Sprite(Textures.TOP);
		endSprite = new Sprite(Textures.END);
		font = new BitmapFont();
	}

	public void populateButtons() {
		List<Button> buttons = new ArrayList<Button>();
		boolean isOdd = true;
		for (String answer : answers) {
			Texture t;
			if (isOdd) {
				t = Textures.BUTTON;
			} else {
				t = Textures.BUTTON2;
			}
			Button b = new Button(answer, t, Main.WIDTH / 2 - t.getWidth() / 2,
					Main.HEIGHT - 178 - ((t.getHeight() + 5) * buttons.size()));
			if (answer == "Others (To Next Page)") {
				b.isNextPage = true;
			}
			buttons.add(b);
			isOdd = !isOdd;
		}
		ButtonManager.buttons = buttons;
	}

	public void update() {
		if (top) {
			if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
				moving = true;
			}
		} else if (end) {

		} else {
			ButtonManager.update();
		}
	}

	public void draw(SpriteBatch sb) {
		if (top) {
			topSprite.setX(0);
			topSprite.setY(yOffset);
			topSprite.draw(sb);

			if (moving) {
				yOffset += 4;
			}
		} else if (end) {
			endSprite.draw(sb);

			if (ellipseCount == 10) {
				if (ellipse.equals("")) {
					ellipse = ".";
				} else if (ellipse.equals(".")) {
					ellipse = "..";
				} else if (ellipse.equals("..")) {
					ellipse = "...";
				} else if (ellipse.equals("...")) {
					ellipse = "";
				}
				ellipseCount = 0;
			}
			ellipseCount++;

			endCount += 1;

			float salary = 0;
			for (int i = 0; i < PageManager.weights.length; i++) {
				Float f = PageManager.weights[i];
				salary += f * PageManager.vector[i];
				if (PageManager.vector[i] == 1) {
				}
			}
			salary = Math.abs(salary);

			if (endCount >= 80) {
				Fonts.textFontWhite.draw(sb, "PREDICTED SALARY: ", 90, 300);
				Fonts.textFontWhite.draw(sb, "$" + ((int) salary), 90, 270);
				Fonts.textFontWhite.draw(sb, "Salary calculated!", 200, 30);
			} else {
				Fonts.textFontWhite.draw(sb, "Calculating salary" + ellipse, 200, 30);
			}

		} else {
			background.draw(sb);
			ButtonManager.draw(sb);

			Fonts.titleFont.draw(sb, question, 40, 410);
			String page = (PageManager.currentIndex + 1) + " / " + PageManager.pages.size();
			Fonts.textFontBlack.draw(sb, page, 180, 30);
		}
	}
}