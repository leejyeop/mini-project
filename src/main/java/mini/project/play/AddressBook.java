package mini.project.play;

import mini.project.util.Prompt;

public class AddressBook {
  static final int LENGTH = 100;
  static String name[] = new String[LENGTH];
  static String phoneNumber[] = new String[LENGTH];
  static String birthday[] = new String[LENGTH];
  static String memo[] = new String[LENGTH];
  static int size = 0;

  public static void main(String[] args) {
    System.out.println("연락처");
    loop :
      while(true) {
        String command = Prompt.inputString("명령 => ");
        switch(command) {
          case "/phone/add" : addPhone();
          break;
          case "/phone/list" : listPhone();
          break;
          case "quit" : break loop;
          default : System.out.println("맞는 명령을 입력하세요.");
        }
      }
    Prompt.close();
  }

  static void addPhone() {
    System.out.println("[새로운 연락처 등록]");
    name[size] = Prompt.inputString("이름? ");
    phoneNumber[size] = Prompt.inputString("전화번호? ");
    birthday[size] = Prompt.inputString("생일? ");
    memo[size] = Prompt.inputString("메 모 ");
    size++;
  }
  static void listPhone() {
    for (int i = 0; i < size; i++) {
      System.out.printf("이름 -> %s\n전화번호 -> %s\n생일 -> %s\n메모 -> %s\n--------------------\n",
          name[i], phoneNumber[i],birthday[i], memo[i]);
    }
  }

}

