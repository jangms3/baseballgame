package baseballgame;
import java.util.*;

public class Game {
    //정답 숫자와 시도 횟수 캡슐화
    private List<Integer> answer;
    private int attempts;

    // 게임 시작 및 정답 확인 메서드
    public String start(Scanner sc) {
        // 1. 정답 숫자 생성
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        List<Integer> answer = list.subList(0, 3); // 정답 리스트
        System.out.println("정답 (디버깅): " + answer); // 디버깅용 출력

        attempts = 0; // 시도 횟수 기록
        Inputvalidator validator = new Inputvalidator();  // 입력값 검증을 위한 객체 생성

        while (true) {
            System.out.println("서로 다른 3개의 숫자를 입력하세요 (1-9): ");
            String input = sc.nextLine();

            // 입력값 유효성 검사
            if (!validator.isValid(input)) {
                System.out.println("잘못된 입력입니다. 1-9 사이의 서로 다른 세 자리 숫자를 입력하세요.");
                continue; // 다음 반복으로 넘어가서 다시 입력.
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

    // answer와 attempts에 접근할 수 있게 캡슐화
    public List<Integer> getAnswer() {
        return answer;
    }

    public int getAttempts() {
        return attempts;
    }
}
