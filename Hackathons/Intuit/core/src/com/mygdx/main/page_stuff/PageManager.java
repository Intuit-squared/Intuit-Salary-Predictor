package com.mygdx.main.page_stuff;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.main.graphics.Fonts;

public class PageManager {

	public static List<Page> pages = new ArrayList<Page>();
	public static Page topPage, endPage;
	public static Page currentPage;
	public static int currentIndex;
	public static boolean end = false;
	public static List<String> inputs = new ArrayList<String>();

	public static int[] vector = new int[110];
	public static float[] weights = { 18992.58131f, 37623.40024f, 38304.42028f, 129847.9673f, 26783.28873f,
			26783.28873f, 30427.58786f, 48396.21787f, 50873.02861f, 32855.78716f, 39765.45525f, 54051.57728f,
			26783.28873f, 49103.15403f, 24328.61747f, 36101.61153f, 26783.28873f, 43059.70965f, 47472.42545f,
			26088.74932f, 26783.28873f, 26783.28873f, 26783.28873f, 45707.8266f, 52324.24427f, 53704.69806f,
			26783.28873f, 26783.28873f, 41953.97065f, 54922.80085f, 20435.20185f, 13409.92749f, 97801.16743f,
			151134.3599f, 39303.39025f, 20252.79401f, 21439.49889f, 19293.54241f, 703.165697f, 15654.51539f,
			62777.62593f, 149580.9734f, 39351.4823f, 34522.11005f, 997.9702832f, 9349.537802f, 27175.99926f,
			53936.52186f, 38222.15309f, 24153.51623f, 1734.413719f, -1669.511354f, -6368.73996f, 5304.646706f,
			12214.04116f, 2494.487714f, 1942.835927f, 18528.36444f, 8191.09495f, 14453.32863f, 5439.818755f,
			8644.701199f, 29999.44614f, -5791.302117f, 38925.20357f, 30204.29783f, 29847.88114f, 26783.28873f,
			7177.528898f, 38849.74146f, 38877.10385f, 8084.415636f, 3981.047333f, -9662.201716f, 26783.28873f,
			-14135.59319f, 12313.97174f, 26783.28873f, 10748.48828f, 33357.67765f, 14417.75362f, 26118.34336f,
			12581.43346f, 14340.39218f, 36166.21216f, 26783.28873f, 11088.49992f, 47595.36902f, 21845.79817f,
			37838.36879f, 27552.20148f, 9868.526445f, 23929.55774f, 22442.87263f, 26783.28873f, 12710.19487f,
			12317.80949f, 26783.28873f, 4276.070272f, 27471.41807f, -27743.24162f, 229381.4537f, 26783.28873f,
			26783.28873f, 26783.28873f, 26783.28873f, 26783.28873f, 26783.28873f, -72207.77674f, 26783.28873f };

	public PageManager() {
		populatePages();
		setPage(0);
	}

	private void populatePages() {
		List<String> answers = new ArrayList<String>();
		topPage = new Page("", answers);
		topPage.top = true;

		answers = new ArrayList<String>();
		endPage = new Page("", answers);
		endPage.end = true;

		answers = new ArrayList<String>();
		answers.add("Male");
		answers.add("Female");
		Page p = new Page("What is your sex?", answers);
		pages.add(p);

		answers = new ArrayList<String>();
		answers.add("White");
		answers.add("Afrian American");
		answers.add("Asian");
		answers.add("Hispanic");
		p = new Page("What is your race?", answers);
		pages.add(p);

		answers = new ArrayList<String>();
		answers.add("1: Management: science, & arts");
		answers.add("2: Management: business & finance");
		answers.add("3: Management occupations");
		answers.add("4: Chief executives, managers");
		answers.add("5: Other Managers");
		answers.add("Others (To Next Page)");
		p = new Page("Future occupation?", answers);
		pages.add(p);

		answers = new ArrayList<String>();
		answers.add("6: Business and finance ops");
		answers.add("7: Business op specialists");
		answers.add("8: Financial specialists");
		answers.add("9: Professional related occupations");
		answers.add("10: Computer and math");
		answers.add("11: Computer analysts, programmers");
		answers.add("Others (To Next Page)");
		p = new Page("Future occupation?", answers);
		pages.add(p);

		answers = new ArrayList<String>();
		answers.add("12: Math, statisticians, research");
		answers.add("13: Architecture and engineering");
		answers.add("14: Non-naval architects");
		answers.add("15: Engineers");
		answers.add("16: Drafters, surveyors, or technicians");
		answers.add("17: Life, physical, social science");
		answers.add("Others (To Next Page)");
		p = new Page("Future occupation?", answers);
		pages.add(p);

		answers = new ArrayList<String>();
		answers.add("18: Other scientists");
		answers.add("19: Science technicians");
		answers.add("20: Community and sociel services");
		answers.add("21: Legal occupations");
		answers.add("22: Lawyers, judges, & magistrates");
		answers.add("23: Paralegals");
		answers.add("Others (To Next Page)");
		p = new Page("Future occupation?", answers);
		pages.add(p);

		answers = new ArrayList<String>();
		answers.add("24: Library occupation");
		answers.add("25: Postsecondary teachers");
		answers.add("26: Other teachers");
		answers.add("27: Archivists, curators");
		answers.add("28: arts, design, entertaiment");
		answers.add("Others (To Next Page)");
		p = new Page("Future occupation?", answers);
		pages.add(p);

		answers = new ArrayList<String>();
		answers.add("29: Healthcare practitioner");
		answers.add("30: Doctor");
		answers.add("31: Nurse");
		answers.add("32: Other Health");
		answers.add("33: Service occupations");
		answers.add("34: Healthcare support");
		answers.add("Others (To Next Page)");
		p = new Page("Future occupation?", answers);
		pages.add(p);

		answers = new ArrayList<String>();
		answers.add("35: Protective services");
		answers.add("36: Food preparation");
		answers.add("37: Food supervising");
		answers.add("38: Chefs & cooks");
		answers.add("39: Other food occupations");
		answers.add("40: Building and ground cleaning");
		answers.add("Others (To Next Page)");
		p = new Page("Future occupation?", answers);
		pages.add(p);

		answers = new ArrayList<String>();
		answers.add("41: Building cleaning supervising");
		answers.add("42: Other maintenance occupations");
		answers.add("43: Other person care and service occupations");
		answers.add("44: Service supervisor");
		answers.add("45: Cashiers");
		answers.add("46: Insurance sales agents");
		answers.add("Others (To Next Page)");
		p = new Page("Future occupation?", answers);
		pages.add(p);

		answers = new ArrayList<String>();
		answers.add("47: Real estate brokers");
		answers.add("48: Other sales occupations");
		answers.add("49: Office support");
		answers.add("50: Office support supervisor");
		answers.add("51: Postal workers");
		answers.add("52: All other occupations");
		answers.add("Others (To Next Page)");
		p = new Page("Future occupation?", answers);
		pages.add(p);

	}

	public static void setPage(int i) {
		currentIndex = i;
		if (currentIndex >= pages.size()) {
			end = true;
			FileHandle file = Gdx.files.local("inputs/inputs.txt");
			String text = "";
			for (String input : inputs) {
				text += input + "\n";
			}
			file.writeString(text, false);
		} else {
			currentPage = pages.get(currentIndex);
			currentPage.populateButtons();
		}
	}

	public static void nextPage() {
		setPage(currentIndex + 1);
	}

	public void update() {
		if (end) {
			endPage.update();
		} else {
			topPage.update();
			currentPage.update();
		}
	}

	public void draw(SpriteBatch sb) {
		if (end) {
			endPage.draw(sb);
		} else {
			currentPage.draw(sb);
			topPage.draw(sb);
		}
	}
}
