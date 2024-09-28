package template;

import java.util.List;


public class MainTest {

    public MainTest() {
        //Load fooddata
		List<FoodData> foodDataList = new FileImporter<>(new FoodDataParseStrategy()).loadCSV("template/fooddata.csv");

        //Load dailyfooddata
		List<DailyFoodData> dailyFoodDataList = new FileImporter<>(new DailyFoodDataParseStrategy(foodDataList)).loadCSV("template/dailyfooddata.csv");

        //Load dailyhealthdata
		List<DailyHealthData> dailyHealthDataList = new FileImporter<>(new DailyHealthDataParseStrategy()).loadCSV("template/dailyhealthdata.csv");

        //Subject
        DiabetesManager manager = new DiabetesManager();
        // Observer
        BloodSugarObserver bo = new BloodSugarObserver(150);
        CarbIntakeObserver co = new CarbIntakeObserver(100);
        InsulinObserver io = new InsulinObserver(10);
        manager.addObserver(bo);
        manager.addObserver(co);
        manager.addObserver(io);
       
        // Add observers


        // Simulate health data updates with food integration
        new Thread(() -> {// Simulate food affecting carbs & insulin
            for (DailyHealthData h : dailyHealthDataList) {
                DailyFoodData f = dailyFoodDataList.stream().filter(e -> e.getDate().equals(h.getDate())).findAny().orElse(null);
                double totalCarbs = f.getFoods().stream().mapToDouble(e -> e.getCarbs()).sum();
                totalCarbs += h.getCarbsIntake();
                h.setCarbsIntake(totalCarbs);
                double insulinDose = (h.getInsulinDose() + totalCarbs) / 10.0;
                h.setInsulinDose(insulinDose);
                manager.addDailyHealthData(h);
            try {
                Thread.sleep(1000); // Wait for 1 second before next update
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n\n\n");
            }
        }).start();
    }
}
