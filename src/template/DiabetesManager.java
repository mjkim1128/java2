package template;

import java.util.ArrayList;
import java.util.List;

public class DiabetesManager implements Subject {
    private List<Observer> observers = new ArrayList<>(); // 옵저버 리스트
    private DailyHealthData d; // 현재의 DailyHealthData

    // 기본 생성자
    public DiabetesManager() {
        this.observers = new ArrayList<>();  // 빈 옵저버 리스트
        this.d = new DailyHealthData();      // 기본 DailyHealthData 객체
    }
    
    // DailyHealthData를 받는 생성자
    public DiabetesManager(DailyHealthData d) {
        this.d = d; // DailyHealthData 초기화
    }

    // DailyHealthData 추가 메서드
    public void addDailyHealthData(DailyHealthData newData) {
        this.d = newData; // 새로운 데이터로 업데이트
        notifyObserver(); // 옵저버에게 알림
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer); // 매개변수로 받은 옵저버를 리스트에 추가
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer); // 매개변수로 받은 옵저버를 리스트에서 제거
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(d); // 현재의 DailyHealthData를 옵저버에게 전달
        }
    }
}
