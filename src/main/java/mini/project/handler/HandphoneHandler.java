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
      System.out.printf("[이름 : %s, 전화번호 : %s, 생일 : %s, 메 모 : %s]\n",
          handphone.getName(),
          handphone.getTel(),
          handphone.getBirthday(),
          handphone.getMemo());
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
      System.out.printf("이름 : %s\n", phone.getName());
      System.out.printf("전화번호 : %s\n", phone.getTel());
      System.out.printf("생일 : %s\n", phone.getBirthday());
      System.out.printf("메모 : %s\n", phone.getMemo());
    }
  }
  public void update() {
    System.out.println("[연락처 변경]");
    String name = Prompt.inputString("이름?");
    Handphone phone = findByName(name);
    if (phone == null) {
      System.out.println("그 이름을 가진 연락처가 없습니다.");
    } else {
      String name = Prompt.inputString(
          String.format("이름(%s)? ", member.getName()));
      String email = Prompt.inputString(
          String.format("이메일(%s)? ", member.getEmail()));
      String password = Prompt.inputString("암호? ");
      String tel = Prompt.inputString(
          String.format("전화(%s)? ", member.getTel()));
      String photo = Prompt.inputString(
          String.format("사진(%s)? ", member.getPhoto()));
      String response = Prompt.inputString("정말 변경하시겠습니까 ? (y/N)");
      if (response.equalsIgnoreCase("y")) {
        member.setName(name);
        member.setEmail(email);
        member.setPassword(password);
        member.setTel(tel);
        member.setPhoto(photo);
        System.out.println("회원정보를 변경하였습니다.");
      }else {
        System.out.println("회원정보 변경을 취소하였습니다.");
      }
    }
  }
}

