package mini.project.play;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import mini.project.domain.Handphone;
import mini.project.domain.Home;
import mini.project.handler.HandphoneHandler;
import mini.project.handler.HomeHandler;
import mini.project.util.Prompt;
public class AddressBook{

  public static void main(String[] args) {
    System.out.println("연락처");
    AbstractList<Handphone> handphoneList = new LinkedList<>();
    HandphoneHandler handphoneHandler = new HandphoneHandler(handphoneList);

    AbstractList<Home> homeList = new ArrayList<>();
    HomeHandler homeHandler = new HomeHandler(homeList, handphoneHandler);


    loop :
      while(true) {
        String command = Prompt.inputString("1.연락처 등록, 2. 연락처 목록, 3.연락처 상세조회, 4.연락처 수정, 5.연락처 삭제\n"
            + "6.주소 등록,   7. 주소 목록,   8. 주소 상세조회,  9. 주소 수정,  10. 주소 삭제\n"
            + "나가기(quit) =>");
        switch(command) {
          case "1" : handphoneHandler.add();
          break;
          case "2" : handphoneHandler.list();
          break;
          case "3" : handphoneHandler.detail();
          break;
          case "4" : handphoneHandler.update();
          break;
          case "5" : handphoneHandler.delete();
          break;
          case "6" : homeHandler.add();
          break;
          case "7" : homeHandler.list();
          break;
          case "8" : homeHandler.detail();
          break;
          case "9" : homeHandler.update();
          break;
          case "10" : homeHandler.delete();
          break;
          case "quit" : break loop;
          default : System.out.println("맞는 명령을 입력하세요.");
        }
      }
    Prompt.close();
  }
}


