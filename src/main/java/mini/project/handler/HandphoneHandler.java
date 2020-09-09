package mini.project.handler;

import java.util.ArrayList;

import mini.project.domain.Handphone;
import mini.project.util.Prompt;

public class HandphoneHandler {

	ArrayList phoneList = new ArrayList();
	public void add() {
		System.out.println("[연락처 등록]");

		Handphone handphone = new Handphone();
		handphone.setNo(Prompt.inputString("번호? "));
		handphone.setName(Prompt.inputString("이름? "));
		handphone.setTel(Prompt.inputString("전화? "));
		handphone.setBirthday(Prompt.inputString("생일? "));
		handphone.setMemo(Prompt.inputString("메모? "));


		phoneList.add(handphone);
		System.out.println("[연락처를 등록했습니다]");
	}



	public void list() {
		System.out.println("[연락처 목록]");
		Object[] handphones = phoneList.toArray();


		for (Object obj : handphones) {
			Handphone handphone = (Handphone) obj;
			System.out.printf("[번호: %s, 이름 : %s, 전화번호 : %s, 생일 : %s, 메 모 : %s]\n",
					handphone.getNo(),
					handphone.getName(),
					handphone.getTel(),
					handphone.getBirthday(),
					handphone.getMemo()
					);
		}
	}
	public Handphone findByName(String name) {
		Object[] handphones = phoneList.toArray();

		for (Object obj : handphones) {
			Handphone handphone = (Handphone) obj;
			if (handphone.getName().equals(name)) {
				return handphone;
			}
		}
		return null;
	}
	public Handphone findByNo(int no) {
		Object[] handphones = phoneList.toArray();

		for (Object obj : handphones) {
			Handphone handphone = (Handphone) obj;
			if (handphone.getNo().equals(no)) {
				return handphone;
			}
		}
		return null;
	}
	public void detail() {
		System.out.println("[주소 상세보기]");
		int no = Prompt.inputInt("번호? ");
		Handphone handphone = findByNo(no);

		if (handphone == null) {
			System.out.println("해당 번호의 주소가 없습니다.");
			return;
		}

		System.out.printf("이름: %s\n", handphone.getName());
		System.out.printf("전화: %s\n", handphone.getTel());
		System.out.printf("생일: %s\n", handphone.getBirthday());
		System.out.printf("메모: %s\n", handphone.getMemo());
	}

	public void update() {
		System.out.println("[주소 변경]");
		String name = Prompt.inputString("이름? ");
		Handphone handphone = findByName(name);

		if (handphone == null) {
			System.out.println("해당 이름이 없습니다.");
			return;
		}

		String tel = Prompt.inputString(
				String.format("전화번호(%s)? ", handphone.getTel()));
		String birthday = Prompt.inputString(
				String.format("생일(%s)? ", handphone.getBirthday()));
		String memo = Prompt.inputString(
				String.format("메모(%s)? ",handphone.getMemo()));

		String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
		if (!response.equalsIgnoreCase("y")) {
			System.out.println("주소 변경을 취소하였습니다.");
			return;
		}

		handphone.setTel(tel);
		handphone.setBirthday(birthday);
		handphone.setMemo(memo);

		System.out.println("주소를 변경하였습니다..");
	}
	public void delete() {
		System.out.println("[회원 삭제]");
		int no = Prompt.inputInt("번호? ");
		int index = indexOf(no);

		if (index == -1) {
			System.out.println("해당 번호의 회원이 없습니다.");
			return;
		}

		String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
		if (!response.equalsIgnoreCase("y")) {
			System.out.println("회원 삭제를 취소하였습니다.");
			return;
		}
		phoneList.remove(index);
		System.out.println("회원을 삭제하였습니다.");
	}
	private int indexOf(int no) {
		for (int i = 0; i < phoneList.size(); i++) {
			Handphone handphone = phoneList.get(i);
			if (handphone.getNo() == no) {
				return i;
			}
		}
		return -1;
	}
}

