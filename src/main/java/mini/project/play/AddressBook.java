package mini.project.play;

import mini.project.handler.HandPhoneHandler;
import mini.project.handler.HomeHandler;
import mini.project.util.Prompt;
public class AddressBook{

  public static void main(String[] args) {
    System.out.println("연락처");
    HandPhoneHandler handphoneHandler = new HandPhoneHandler();
    HomeHandler homeHandler = new HomeHandler(handphoneHandler);


    loop :
      while(true) {
        String command = Prompt.inputString("명령 => (/phone/~, /home/~)\n");
        switch(command) {
          case "/phone/add" : handphoneHandler.add();
          break;
          case "/phone/list" : handphoneHandler.list();
          break;
          case "/home/add" : homeHandler.add();
          break;
          case "/home/list" : homeHandler.list();
          break;
          case "quit" : break loop;
          default : System.out.println("맞는 명령을 입력하세요.");
        }
      }
    Prompt.close();
  }
}


