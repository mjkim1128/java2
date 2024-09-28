package template;

public class FoodDataParseStrategy implements ParseStrategy<FoodData> {
    @Override
    public FoodData parse(String line) {
        String[] foodData = line.split(",");  // CSV의 구분자가 쉼표라고 가정
        return new FoodData(foodData[0], Double.parseDouble(foodData[1]), Double.parseDouble(foodData[2]));
    }
}
