package template;

import java.util.ArrayList;
import java.util.List;

public class DailyFoodDataParseStrategy implements ParseStrategy<DailyFoodData> {

    private List<FoodData> foodDataList;

    // 생성자에서 foodDataList를 받아 초기화
    public DailyFoodDataParseStrategy(List<FoodData> foodDataList) {
        this.foodDataList = foodDataList;
    }

    @Override
    public DailyFoodData parse(String line) {
        String[] fields = line.split(",", 2); // 첫 번째 필드는 날짜, 두 번째 필드는 음식 목록
        String date = fields[0]; // 날짜 필드

        // 따옴표를 제거하고 음식 목록을 쉼표로 나눔
        String foodsString = fields[1].replaceAll("^\"|\"$", "");
        String[] foodNames = foodsString.split(","); // CSV에서 음식 이름을 추출

        List<FoodData> foods = new ArrayList<>();

        for (String foodName : foodNames) {
            // foodDataList에서 이름이 일치하는 FoodData를 찾기
            FoodData matchingFood = foodDataList.stream()
                .filter(food -> food.getName().equalsIgnoreCase(foodName.trim())) // 이름 비교
                .findFirst()
                .orElse(null); // 일치하는 것이 없으면 null

            // 일치하는 FoodData가 있으면 리스트에 추가
            if (matchingFood != null) {
                foods.add(matchingFood);
            } else {
                // 매칭되는 것이 없으면 기본 값으로 새로운 FoodData 생성
                foods.add(new FoodData(foodName.trim(), 0.0, 0.0));
            }
        }

        return new DailyFoodData(date, foods); // 날짜와 음식 목록만 반환
    }
}
