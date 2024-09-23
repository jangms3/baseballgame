package baseballgame;
import java.util.*;

public class GameRecord {
    private List<String> records;

    public GameRecord() {
        records = new ArrayList<>();
    }

    // 게임 기록 추가
    public void addRecord(String record) {
        records.add(record);
    }

    // 게임 기록 전체를 반환하는 getter 메서드 (캡슐화)
    public List<String> getRecords() {
        return records;
    }

    // 게임 기록 출력
    public void showRecords() {
        if (records.isEmpty()) {
            System.out.println("기록 없음");
        } else {
            for (String rec : records) {
                System.out.println(rec);
            }
        }
    }
}
