package mini.project.handler;

import mini.project.util.Prompt;

public class HandPhoneHandler {
	static class HandPhone {
		String name;
		String tel;
		String birthday;
		String memo;
	}
	static final int LENGTH = 100;
	static HandPhone[] list = new HandPhone[LENGTH]; // list로 이름을 바꾼다.
	static int size = 0;

	public static void add() {
		System.out.println("[회원 등록]");

		HandPhone handphone = new HandPhone();
		handphone.name = Prompt.inputString("이름? ");
		handphone.memo = Prompt.inputString("메모? ");
		handphone.birthday = Prompt.inputString("생일? ");
		handphone.tel = Prompt.inputString("전화? ");

		list[size++] = handphone;
	}

	public static void list() {
		System.out.println("[회원 목록]");

		for (int i = 0; i < size; i++) {
			HandPhone handphone = list[i];
			System.out.printf("%s, %s, %s, %s ",
					handphone.name, 
					handphone.tel, 
					handphone.birthday, 
					handphone.memo 
					);
		}
	}
	public static HandPhone findByName(String name) {
		for (int i = 0; i < size; i++) {
			HandPhone handphone = list[i];
			if (handphone.name.equals(name)) {
				return handphone;
			}
		}
		return null;
	}
}

