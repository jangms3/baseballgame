package baseballgame;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        GameRecord gameRecord = new GameRecord();

        while (running) {
            // 프로그램 안내 문구 출력
            System.out.println("환영합니다!!. 원하시는 번호를 입력해주세요");
            System.out.println("1. 게임 시작하기");
            System.out.println("2. 게임 기록보기");
            System.out.println("3. 종료하기");
            System.out.println("선택 : ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("<게임을 시작합니다>");
                    Game game = new Game();  // 새로운 게임 인스턴스 생성
                    String record = game.start(sc);  // 게임 시작
                    gameRecord.addRecord(record);  // 기록 저장
                    break;
                case "2":
                    System.out.println("<게임 기록>");
                    gameRecord.showRecords();  // 기록 보기
                    break;
                case "3":
                    System.out.println("<프로그램을 종료합니다>");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
        sc.close();
    }
}
