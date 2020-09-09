package mini.project.handler;

import java.util.AbstractList;
import java.util.Iterator;

import mini.project.domain.Handphone;
import mini.project.util.Prompt;

public class HandphoneHandler {

	AbstractList<Handphone> handphoneList;

	public HandphoneHandler(AbstractList<Handphone> list) {
		this.handphoneList = list;
	}
	public void add() {
		System.out.println("[연락처 등록]");

		Handphone handphone = new Handphone();
		handphone.setNo(Prompt.inputInt("번호? "));
		handphone.setName(Prompt.inputString("이름? "));
		handphone.setTel(Prompt.inputString("전화? "));
		handphone.setBirthday(Prompt.inputString("생일? "));
		handphone.setMemo(Prompt.inputString("메모? "));

		handphoneList.add(handphone);
		System.out.println("[연락처를 등록했습니다]");
	}

	public void list() {
		System.out.println("[연락처 목록]");
		Iterator<Handphone> iterator = handphoneList.iterator();

		while(iterator.hasNext()) {
			Handphone handphone = iterator.next();
			System.out.printf("[번호: %s, 이름 : %s, 전화번호 : %s, 생일 : %s, 메모 : %s]\n",
					handphone.getNo(),
					handphone.getName(),
					handphone.getTel(),
					handphone.getBirthday(),
					handphone.getMemo()
					);
		}
	}
	public Handphone findByName(String name) {
		Object[] handphones = handphoneList.toArray();
		for (Object obj : handphones) {
			Handphone handphone = (Handphone) obj;
			if (handphone.getName().equals(name)) {
				return handphone;
			}
		}
		return null;
	}
	public void detail () {
		System.out.println("[연락처 상세조회]");
		String name = Prompt.inputString("이름?");
		Handphone phone = findByName(name);
		if (phone == null) {
			System.out.println("해당이름의 연락처가 없습니다.");
		} else {
			System.out.printf("번호 : %s\n", phone.getNo());
			System.out.printf("이름 : %s\n", phone.getName());
			System.out.printf("전화번호 : %s\n", phone.getTel());
			System.out.printf("생일 : %s\n", phone.getBirthday());
			System.out.printf("메모 : %s\n", phone.getMemo());
		}
	}
	public void update() {
		System.out.println("[연락처 변경]");
		String name1 = Prompt.inputString("이름?");
		Handphone phone = findByName(name1);
		if (phone == null) {
			System.out.println("그 이름을 가진 연락처가 없습니다.");
		} else {
			String name = Prompt.inputString(
					String.format("이름(%s)? ", phone.getName()));
			String tel  = Prompt.inputString(
					String.format("전화번호(%s)? ", phone.getTel()));
			String birthday = Prompt.inputString(
					String.format("생일(%s)? ", phone.getBirthday()));
			String memo = Prompt.inputString(
					String.format("메모(%s)? ", phone.getMemo()));
			String response = Prompt.inputString("정말 변경하시겠습니까 ? (y/N)");
			if (response.equalsIgnoreCase("y")) {
				phone.setName(name);
				phone.setTel(tel);
				phone.setBirthday(birthday);
				phone.setMemo(memo);
				System.out.println("회원정보를 변경하였습니다.");
			}else {
				System.out.println("회원정보 변경을 취소하였습니다.");
			}
		}
	}
	public void delete() {
		System.out.println("[회원정보 삭제]");
		int no = Prompt.inputInt("번호?");
		int index = indexOf(no);
		if (index == -1) {
			System.out.println("해당번호의 회원정보가 없습니다.");
		} else {
			String response = Prompt.inputString("정말 삭제 하시겠습니까 ? (y/N)");
			if (response.equalsIgnoreCase("y")) {
				handphoneList.remove(index);
				System.out.println("회원정보를 삭제 하였습니다.");
			} else {
				System.out.println("삭제를 취소하였습니다.");
			}
		}
	}
	private int indexOf(int no) {
		for(int i = 0; i < handphoneList.size(); i++) {
			Handphone handphone = handphoneList.get(i);
			if (handphone.getNo() == no) {
				return i;
			}
		}    return -1;
	}
}

