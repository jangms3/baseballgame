package PLAYGAME;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        List<String> records = new ArrayList<>();

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
                    String record = startGame(sc);
                    records.add(record);
                    break;
                case "2":
                    System.out.println("<게임 기록>");
                    if (records.isEmpty()) {
                        System.out.println("기록 없음");
                    } else {
                        for (String rec : records) {
                            System.out.println(rec);
                        }
                    }
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


    // 게임 시작 및 정답 확인 메서드
    public static String startGame(Scanner sc) {
        // 1. 정답 숫자 생성
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        List<Integer> answer = list.subList(0, 3); // 정답 리스트
        System.out.println("정답 (디버깅): " + answer); // 디버깅용 출력

        int attempts = 0; // 시도 횟수 기록

        while (true) {
            System.out.println("서로 다른 3개의 숫자를 입력하세요 (1-9): ");
            String input = sc.nextLine();

            // 입력값 유효성 검사
            if (!isValid(input)) {
                System.out.println("잘못된 입력입니다. 1-9 사이의 서로 다른 세 자리 숫자를 입력하세요.");
                continue;
            }

            // 입력값을 리스트로 변환
            List<Integer> userInput = new ArrayList<>();
            for (char c : input.toCharArray()) {
                userInput.add(Character.getNumericValue(c));
            }

            // 3. 결과 비교
            int strike = 0;
            int ball = 0;

            // 스트라이크와 볼을 계산
            for (int i = 0; i < 3; i++) {
                if (userInput.get(i).equals(answer.get(i))) {
                    strike++;
                } else if (answer.contains(userInput.get(i))) {
                    ball++;
                }
            }

            attempts++; // 시도 횟수 증가

            // 결과 출력
            if (strike == 3) {
                System.out.println("3스트라이크! 정답입니다!");
                return "정답을 맞추셨습니다! 시도 횟수: " + attempts + "번"; // 게임 기록 반환
            } else if (strike > 0 || ball > 0) {
                System.out.println(strike + " 스트라이크, " + ball + " 볼");
            } else {
                System.out.println("아웃");
            }
        }
    }

    // 입력값 유효성 검사 메서드
    public static boolean isValid(String input) {
        // 3자리 수인지 확인
        if (input.length() != 3) {
            return false;
        }

        // 숫자로만 구성되어 있는지 확인
        if (!input.matches("[1-9]+")) {
            return false;
        }

        // 중복된 숫자가 없는지 확인
        char[] chars = input.toCharArray();
        if (chars[0] == chars[1] || chars[1] == chars[2] || chars[0] == chars[2]) {
            return false;
        }

        return true;
    }
}



