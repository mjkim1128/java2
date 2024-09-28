package template;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// T는 파싱할 데이터 타입을 의미 (FoodData)
public class FileImporter<T> {
    private final ParseStrategy<T> parseStrategy;

    // 생성자에서 파싱 전략을 주입받음
    public FileImporter(ParseStrategy<T> parseStrategy) {
        this.parseStrategy = parseStrategy;
    }

    // loadCSV 메서드
    public List<T> loadCSV(String filePath) {
        List<T> dataList = new ArrayList<>();  // 파싱된 데이터를 담을 리스트
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            Boolean firstLine = true; // CSV파일 첫줄은 자료에 대한 설명 + 첫줄 읽으면 발생하는 오류로 인해 첫줄 건너뛰기위한 불리안값
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                // 파싱 전략을 통해 각 줄을 객체로 변환
                T data = parseStrategy.parse(line);
                dataList.add(data);  // 변환된 객체를 리스트에 추가
            }
        } catch (IOException e) {
            e.printStackTrace();  // 파일을 읽는 중 예외 처리
        }
        return dataList;  // 리스트 반환
    }
}
