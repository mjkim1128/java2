package template;

import java.util.List;


public class MainTest {

    int count = 0;
    
    public MainTest() {
        
        //Load fooddata
		List<FoodData> foodDataList = new FileImporter<>(new FoodDataParseStrategy()).loadCSV("src/template/fooddata.csv");

        //Load dailyfooddata
		List<DailyFoodData> dailyFoodDataList = new FileImporter<>(new DailyFoodDataParseStrategy(foodDataList)).loadCSV("src/template/dailyfooddata.csv");

        //Load dailyhealthdata
		List<DailyHealthData> dailyHealthDataList = new FileImporter<>(new DailyHealthDataParseStrategy()).loadCSV("src/template/dailyhealthdata.csv");

        //Subject
        DiabetesManager manager = new DiabetesManager();
        // Observer
        BloodSugarObserver bo = new BloodSugarObserver(150);
        CarbIntakeObserver co = new CarbIntakeObserver(100);
        InsulinObserver io = new InsulinObserver(10);
        HealthCheckObserver hc = new HealthCheckObserver();
        manager.addObserver(bo);
        manager.addObserver(co);
        manager.addObserver(io);
       
        // Add observers
        manager.addObserver(hc);

        // Simulate health data updates with food integration
        new Thread(() -> {// Simulate food affecting carbs & insulin
            for (DailyHealthData h : dailyHealthDataList) {
                DailyFoodData f = dailyFoodDataList.stream().filter(e -> e.getDate().equals(h.getDate())).findAny().orElse(null);
                double totalCarbs = f.getFoods().stream().mapToDouble(e -> e.getCarbs()).sum();
                totalCarbs += h.getCarbsIntake();
                h.setCarbsIntake(totalCarbs);
                double insulinDose = (h.getInsulinDose() + totalCarbs) / 10.0;
                h.setInsulinDose(insulinDose);

                System.out.println(h.getDate() + "\n" + "carbs intake: "+ totalCarbs + " insulin Dose; " + insulinDose + " Blood sugar level: " + h.getBloodSugarLevel());

                manager.addDailyHealthData(h);
                try {
                    Thread.sleep(1000); // Wait for 1 second before next update
                } catch (InterruptedException e) {
                e.printStackTrace();
                }
                count++;
                if(count > 15){
                    manager.removeObserver(bo); // 15일 이후 혈당문제가 해결되었다고 가정(혈당 경고 무시) -> BloodSugar Level 표시하는 옵저버 삭제
                    System.out.print("(Without Blood sugar level)");
                }
                System.out.println("\n\n\n");
            }
        }).start();
    }
}
