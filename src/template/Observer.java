package template;


public interface Observer {
    void update(DailyHealthData d);  // 제네릭을 없애고 DailyHealthData를 직접 받도록 수정
}

