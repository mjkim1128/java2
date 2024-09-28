package template;

public interface ParseStrategy<T>{
    T parse(String line);  // CSV 파일의 한 줄을 파싱하는 메서드
}
