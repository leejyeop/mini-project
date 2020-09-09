package mini.project.handler;

import java.util.ArrayList;
import mini.project.domain.HandphoneHandler;
import mini.project.domain.Home;
import mini.project.util.Prompt;

public class HomeHandler {

  ArrayList homeList = new ArrayList();
  HandphoneHandler handphoneHandler;

  public HomeHandler(HandphoneHandler handphoneHandler) {
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
      System.out.println("등록된 회원이 아닙니다.");
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
      System.out.printf("[%s => , 주소 : %s, 집전화 : %s]\n",
          home.getName(),home.getAddress(),home.getTel());
    }
  }
}

