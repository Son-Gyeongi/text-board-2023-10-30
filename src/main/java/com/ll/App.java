package com.ll;

import java.util.Scanner;

public class App {

    // Scanner를 만들어야 한다.
    private final Scanner scanner;

    public App(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.println("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
                break;
            }
        }
    }
}
