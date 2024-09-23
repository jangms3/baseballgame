package baseballgame;


public class Inputvalidator {
    // 입력값 유효성 검사 메서드
    public boolean isValid(String input) {
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
