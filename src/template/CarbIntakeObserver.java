package template;

public class CarbIntakeObserver implements Observer{

    double carbThreshold; 

    public CarbIntakeObserver(double carbThreshold) {
        this.carbThreshold = carbThreshold;
    }
    @Override
    public void update(DailyHealthData d) {
        if(d.getCarbsIntake() > carbThreshold){
            System.out.println("CarbsIntake Alert!");
        }
    }

}
