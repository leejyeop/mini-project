package mini.project.play;

import java.util.Scanner;

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
        String command = inputString("명령 => ");
        switch(command) {
          case "/phone/add" : addPhone();
          break;
          case "/phone/list" : listPhone();
          break;
          case "quit" : break loop;
          default : System.out.println("맞는 명령을 입력하세요.");
        }
      }
    input.close();
  }

  static void addPhone() {
    System.out.println("[새로운 연락처 등록]");
    name[size] = inputString("이름? ");
    phoneNumber[size] = inputString("전화번호? ");
    birthday[size] = inputString("생일? ");
    memo[size] = inputString("메 모 ");
    size++;
  }
  static void listPhone() {
    for (int i = 0; i < size; i++) {
      System.out.printf("이름 -> %s\n전화번호 -> %s\n생일 -> %s\n메모 -> %s\n--------------------\n",
          name[i], phoneNumber[i],birthday[i], memo[i]);
    }
  }
  static Scanner input = new Scanner(System.in);

  public static String inputString(String title) {
    System.out.print(title);
    return input.nextLine();
  }
  public static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }
  //  public static void close() {
  //    input.close();
  //  }
}

