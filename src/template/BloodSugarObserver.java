package template;

public class BloodSugarObserver implements Observer{
    
    double bloodSugarThreshold;
    static boolean bloodSugarCaution; //HealthCheckObserver에 사용할 트리거

    public BloodSugarObserver(double bloodSugarThreshold){
        this.bloodSugarThreshold = bloodSugarThreshold;
    }
    @Override
    public boolean update(DailyHealthData d) {
        if(d.getBloodSugarLevel() > bloodSugarThreshold){ 
            System.out.print("BloodSugar Level Alert! ");
            bloodSugarCaution = true;
        }
        else{ 
            bloodSugarCaution = false;
        }
        return bloodSugarCaution; // HealthCheckObserver에 사용할 리턴값
    }
}
