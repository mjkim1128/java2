package template;

public class DailyHealthDataParseStrategy implements ParseStrategy<DailyHealthData>{

    @Override
    public DailyHealthData parse(String line) {
        String[] dailyHealthData = line.split(",");  // CSV의 구분자가 쉼표라고 가정
        return new DailyHealthData(dailyHealthData[0], Double.parseDouble(dailyHealthData[1]), 
        Double.parseDouble(dailyHealthData[2]), Double.parseDouble(dailyHealthData[3]));
    }
}
