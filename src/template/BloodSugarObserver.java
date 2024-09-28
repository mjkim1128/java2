package template;

public class BloodSugarObserver implements Observer{
    
    double bloodSugarThreshold;

    public BloodSugarObserver(double bloodSugarThreshold){
        this.bloodSugarThreshold = bloodSugarThreshold;
    }
    @Override
    public void update(DailyHealthData d) {
        if(d.getBloodSugarLevel() > bloodSugarThreshold){
            System.out.println("BloodSugar Level Alert!");
        }
    }
}
