package template;

import java.util.List;

public class DailyFoodData {
    private String date;
    private List<FoodData> foods;
    

    public DailyFoodData(String date, List<FoodData> foods) {
        this.date = date;
        this.foods = foods;
    }
    // getters와 toString 메서드 추가 (필요 시)
    
    public String getDate() {
        return date;
    }

    public List<FoodData> getFoods() {
        return foods;
    }

    

    @Override
    public String toString() {
        return "DailyFoodData{" +
            "date='" + date + '\'' +
            ", foods=" + foods +
            '}';
    }
}
