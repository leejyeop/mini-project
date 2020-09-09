package mini.project.handler;

import java.util.AbstractList;
import mini.project.domain.Home;
import mini.project.util.Prompt;

public class HomeHandler {

  AbstractList<Home> homeList;
  HandphoneHandler handphoneHandler;



  public HomeHandler (AbstractList<Home> list, HandphoneHandler handphoneHandler) {
    this.homeList = list;
    this.handphoneHandler = handphoneHandler;
  }

  public void add() {

    System.out.println("[집주소 등록]");
    Home home = new Home();
    while (true) {
      String name = Prompt.inputString("주소 추가할 대상?(취소: 빈 문자열) ");
      if (name.length() == 0) {
        System.out.println("집주소 추가를 취소합니다.");
        return;
      } else if (handphoneHandler.findByName(name) != null) {
        home.setName(name);
        break;
      }
      System.out.println("연락처에 등록된 대상이 아닙니다.");
    }

    home.setAddress(Prompt.inputString("집주소? "));
    home.setTel(Prompt.inputString("집전화 ? "));

    homeList.add(home);
    System.out.println("주소를 등록했습니다.");
  }
  public void list() {
    System.out.println("[주소록]");
    Object[] homes = homeList.toArray();
    for (Object obj : homes) {
      Home home = (Home) obj;
      System.out.printf("[%s(%d) => , 주소 : %s, 집전화 : %s]\n",
          home.getName(),home.getNo(), home.getAddress(),home.getTel());
    }
  }
  public void detail () {
    System.out.println("[집주소 상세조회]");
    String name = Prompt.inputString("이름 ?");
    Home home = findByName(name);
    if (home == null) {
      System.out.println("해당이름의 주소가 없습니다.");
    } else {
      System.out.printf("단축번호 : %d\n", home.getNo());
      System.out.printf("이름 : %s\n", home.getName());
      System.out.printf("주소 : %s\n", home.getAddress());
      System.out.printf("집전화 : %s\n", home.getTel());
    }
  }
  public void update() {
    System.out.println("[주소록 변경]");
    String name1 = Prompt.inputString("이름?");
    Home home = findByName(name1);
    if (home == null) {
      System.out.println("해당이름의 회원정보가 없습니다.");
    } else {
      String name = Prompt.inputString(
          String.format("이름(%s)? ", home.getName()));
      String address = Prompt.inputString(
          String.format("집주소(%s)? ", home.getAddress()));
      String tel = Prompt.inputString(
          String.format("전화(%s)? ", home.getTel()));
      String response = Prompt.inputString("정말 변경하시겠습니까 ? (y/N)");
      if (response.equalsIgnoreCase("y")) {
        home.setName(name);
        home.setAddress(address);
        home.setTel(tel);
        System.out.println("주소록을 변경하였습니다.");
      }else {
        System.out.println("주소록 변경을 취소하였습니다.");
      }
    }
  }
  public void delete() {
    System.out.println("[주소 삭제]");
    int no = Prompt.inputInt("번호?");
    int index = indexOf(no);
    if (index == -1) {
      System.out.println("해당번호의 주소정보가 없습니다.");
    } else {
      String response = Prompt.inputString("정말 삭제 하시겠습니까 ? (y/N)");
      if (response.equalsIgnoreCase("y")) {
        homeList.remove(index);
        System.out.println("주소정보를 삭제 하였습니다.");
      } else {
        System.out.println("삭제를 취소하였습니다.");
      }
    }
  }
  private int indexOf(int no) {
    for(int i = 0; i < homeList.size(); i++) {
      Home home = homeList.get(i);
      if (home.getNo() == no) {
        return i;
      }
    }    return -1;
  }
  public Home findByName(String name) {
    Object[] homes = homeList.toArray();
    for (Object obj : homes) {
      Home home = (Home) obj;
      if (home.getName().equals(name)) {
        return home;
      }
    }
    return null;
  }
}



