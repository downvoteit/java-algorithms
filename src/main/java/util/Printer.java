package util;

public class Printer {
  public static void out(Object... args) {
    System.out.format("%s".repeat(args.length), args);
  }
}
