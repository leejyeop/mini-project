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
        String command = Prompt.inputString("명령 (/phone/~, /home/~)\n =>");
        switch(command) {
          case "/phone/add" : handphoneHandler.add();
          break;
          case "/phone/list" : handphoneHandler.list();
          break;
          case "/phone/detail" : handphoneHandler.detail();
          break;
          case "/phone/update" : handphoneHandler.update();
          break;
          case "/phone/delete" : handphoneHandler.delete();
          break;
          case "/home/add" : homeHandler.add();
          break;
          case "/home/list" : homeHandler.list();
          break;
          case "/home/detail" : homeHandler.detail();
          break;
          case "/home/update" : homeHandler.update();
          break;
          case "/home/delete" : homeHandler.delete();
          break;
          case "quit" : break loop;
          default : System.out.println("맞는 명령을 입력하세요.");
        }
      }
    Prompt.close();
  }
}


