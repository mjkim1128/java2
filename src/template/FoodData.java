package template;

public class FoodData {
    private String name;
    private double carbs;
    private double calories;

    public FoodData(String name, double carbs, double calories) {
        this.name = name;
        this.carbs = carbs;
        this.calories = calories;
    }

    public FoodData(String name) {
        this.name = name;
        this.carbs = 0.0;      // 에러 잡기 위한 초기화값
        this.calories = 0.0;   // 에러 잡기 위한 초기화값
    }
    
    // 이하 게터 세터
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCarbs() {
        return this.carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getCalories() {
        return this.calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + name + "'" +
            ", carbs='" + carbs + "'" +
            ", calories='" + calories + "'" +
            "}";
    }
}
