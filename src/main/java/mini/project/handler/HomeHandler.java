package mini.project.handler;

import mini.project.util.Prompt;

public class HomeHandler {
	static class Home {
		String address;
		String tel;
	}
	static final int LENGTH = 100;  // PLENGTH 를 LENGTH 로 변경한다.
	static Home[] list = new Home[LENGTH]; // projects 를 list 로 변경한다.
	static int size = 0; // psize 를 size 로 변경한
	public static void add() {
		System.out.println("[프로젝트 등록]");

		Home home = new Home();
		home.address = Prompt.inputString("주소? ");

		home.tel = Prompt.inputString("전화번호? ");

		list[size++] = home;
	}

	public static void list() {
		System.out.println("[프로젝트 목록]");

		for (int i = 0; i < size; i++) {
			Home home = list[i];
			System.out.printf(" %s, %s",
					home.address, 
					home.tel); 
			System.out.println();
		}

	}
}

