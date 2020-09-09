package mini.project.util;

import java.util.Scanner;

public class Prompt {
  static Scanner input = new Scanner(System.in);

  public static String inputString(String title) {
    System.out.print(title);
    return input.nextLine();
  }
  public static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }
  public static void close() {
    input.close();
  }
}