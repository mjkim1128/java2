package template;

public class CarbIntakeObserver implements Observer{

    double carbThreshold; 
    static boolean carbIntakeCaution; // HealthCheckObserver에 사용할 트리거

    public CarbIntakeObserver(double carbThreshold) {
        this.carbThreshold = carbThreshold;
    }
    @Override
    public boolean update(DailyHealthData d) {
        if(d.getCarbsIntake() > carbThreshold){
            System.out.print("CarbsIntake Alert! ");
            carbIntakeCaution = true;
        }
        else{
            carbIntakeCaution = false;
        }
        return carbIntakeCaution; // HealthCheckObserver에 사용할 리턴값
    }
}
