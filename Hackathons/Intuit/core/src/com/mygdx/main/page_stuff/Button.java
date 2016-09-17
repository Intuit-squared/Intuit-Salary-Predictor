package com.mygdx.main.page_stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.main.graphics.Fonts;

public class Button {

	Sprite up, down;
	Sprite odd;

	String answer;

	public float x, y;
	public float mouseX, mouseY;
	public boolean accessed = false;
	public boolean clicked = false, justClicked = false;
	public boolean mouseDown = false;
	public boolean isNextPage = false;
	public boolean draw = true;
	public float width, height;

	Rectangle hitbox;
	BitmapFont font;

	public Button(String answer, Texture up, float x, float y) {
		this.up = new Sprite(up);
		this.down = new Sprite(up);
		this.down.setColor(new Color(0.8f, 0.8f, 0.8f, 1));

		this.x = x;
		this.y = y;

		this.up.setX(x);
		this.up.setY(y);
		this.down.setX(x + 2f);
		this.down.setY(y - 1f);

		this.answer = answer;

		odd = this.up;

		width = odd.getWidth();
		height = odd.getHeight();

		hitbox = new Rectangle(x, y, width, height);

		font = new BitmapFont();
	}

	public void setDown(Texture down) {
		this.down = new Sprite(down);
		this.down.setX(x);
		this.down.setY(y);
	}

	public void hovered() {
		if (mouseDown) {
			accessed();
		}
	}

	public void accessed() {
		if (!accessed) {			
			clicked = true;
		}
		accessed = true;
	}

	public void update() {
	}

	public void draw(SpriteBatch sb) {
		if (draw) {
			odd.draw(sb);
			Fonts.textFontWhite.draw(sb, answer, x + 10, y + 25);
		}
	}

	public boolean isAccessed() {
		return accessed;
	}

	public boolean clicked() {
		return clicked;
	}

	public void setAccessed(boolean accessed) {
		this.accessed = accessed;
	}

	public void setTint(Color c) {
		up.setColor(c);
		down.setColor(c);
	}

	public void print() {
		System.out.println(mouseX + " " + mouseY + "  |  " + hitbox);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Sprite getSprite() {
		return odd;
	}
}