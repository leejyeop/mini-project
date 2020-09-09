package mini.project.handler;

import java.util.ArrayList;

import mini.project.domain.Handphone;
import mini.project.util.Prompt;

public class HandphoneHandler {

	ArrayList phoneList = new ArrayList();
	public void add() {
		System.out.println("[연락처 등록]");

		Handphone handphone = new Handphone();
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
			System.out.printf("[이름 : %s, 전화번호 : %s, 생일 : %s, 메 모 : %s]\n",
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
}

