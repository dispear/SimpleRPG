package org.example.RPG.run;

import org.example.RPG.informaion.User;
import org.example.RPG.service.GameService;

import java.util.Scanner;

public class Application {
    private static final GameService gameService = new GameService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        label:
        while (true) {
            System.out.println("======== RPG ==========");
            System.out.println("1. 시작하기");
            System.out.println("0. 게임종료");

            System.out.print("메뉴 선택 : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    gameService.newGame(signUp());
                    System.out.println("게임을 시작합니다.");
                    break label;
                case 0:
                    System.out.println("게임을 종료합니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력했습니다.");
            }
        }

        while (true) {
            System.out.println("===============================");
            System.out.print("1. 내정보\t");
            System.out.print("2. 전투하기\t");
            System.out.print("3. 휴식\t");
            System.out.print("0. 게임 종료");
            System.out.println();
            System.out.println("===============================");
            System.out.print("메뉴 선택 : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    gameService.status();
                    break;
                case 2:
                    System.out.println("===============================");
                    System.out.println("사냥터에 입장하셨습니다.");
                    while(true){
                        System.out.print("1. 달팽이(1~5레벨 추천)\t");
                        System.out.print("2. 슬라임(5~10레벨 추천)\t");
                        System.out.print("3. 늑대(10~15레벨 추천)\t");
                        System.out.print("4. 유령(15~20레벨 추천)\n");
                        System.out.print("5. 골렘(20~25레벨 추천)\t");
                        System.out.print("6. 마녀(25~30레벨 추천)\t");
                        System.out.print("7. 드래곤(30이상 레벨 추천)\t");
                        System.out.println();
                        System.out.println("===============================");
                        System.out.print("사냥터 선택 : ");
                        int choice2 = sc.nextInt();

                        gameService.battle(choice2);
                        if(choice2 == 7){
                           boolean end = gameService.ending(choice2);
                           if(end)
                               return;
                        }
                        break;
                    }
                    break;
                case 3:
                    System.out.println("===============================");
                    checkRest();
                    break;
                case 0:
                    System.out.println("게임을 종료합니다. 현재 데이터를 저장합니다.");
                    return;
                default:
                    System.out.println("번호를 잘못 입력했습니다.");
            }
        }
    }

    private static User signUp() {
        User newUser = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();

        newUser = new User(name, 100, 100, 1, 1, 10, 1000, 0, 10);

        return newUser;
    }

    private static void checkRest(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("휴식하시겠습니까? (Y/N) ");
            String s = sc.next();

            if(s.equals("Y") || s.equals("y")){
                gameService.rest();
                break;
            }else if(s.equals("N") || s.equals("n")){
                System.out.println("처음으로 돌아갑니다..");
                break;
            }else {
                System.out.println("올바른 값을 입력해 주세요!!");
            }
        }
    }
}
