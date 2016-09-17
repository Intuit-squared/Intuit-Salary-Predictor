package com.mygdx.main.page_stuff;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.main.Main;

public class ButtonManager {

	public static List<Button> buttons = new ArrayList<Button>();
	public static boolean mouseDown = false, prevMouseDown = false;

	public ButtonManager() {

	}

	public static void update() {
		prevMouseDown = mouseDown;
		for (Button b : buttons) {
			b.mouseX = Gdx.input.getX();
			b.mouseY = Main.HEIGHT - Gdx.input.getY();
			Vector2 mouse = new Vector2(b.mouseX, b.mouseY);

			if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
				b.mouseDown = true;
				mouseDown = true;
			} else {
				b.mouseDown = false;
				mouseDown = false;
				b.accessed = false;
			}
			if (b.hitbox.contains(mouse) || b.accessed) {
				b.hovered();
				b.odd = b.down;
			} else {
				b.odd = b.up;
			}
			if (!prevMouseDown && mouseDown && b.accessed) {
				if (b.clicked()) {

					if (b.answer.equals("Female")) {
						PageManager.vector[108] = 1;
					}

					if (b.answer.equals("Male")) {
						PageManager.vector[109] = 1;
					}

					if (b.answer.equals("White")) {
						PageManager.vector[101] = 1;
					}

					if (b.answer.equals("African American")) {
						PageManager.vector[104] = 1;
					}

					if (b.answer.equals("Asian")) {
						PageManager.vector[106] = 1;
					}

					if (b.answer.equals("Hispanic")) {
						PageManager.vector[107] = 1;
					}

					try {
						int index = Integer.valueOf(b.answer.split(":")[0]);
						PageManager.vector[index] = 1;
					} catch (Exception e) {
						
					}

					if (!b.isNextPage) {
						if (PageManager.currentIndex > 1) {
							PageManager.setPage(PageManager.pages.size());
						}
						PageManager.inputs.add(b.answer);
					}
					PageManager.nextPage();
				}
			}
		}
	}

	public static void draw(SpriteBatch sb) {
		for (Button b : buttons) {
			b.draw(sb);
		}
	}
}
