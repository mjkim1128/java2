package template;

public class InsulinObserver implements Observer{

    double insulinThresHold;
    static boolean insulinCaution = false; // HealthCheckObserver에 사용될 불리안값

    public InsulinObserver(double insulinThreshold) {
        this.insulinThresHold = insulinThreshold;
    }

    @Override
    public boolean update(DailyHealthData d) {
        if(d.getInsulinDose() > insulinThresHold){
            System.out.print( "InsulinDose Alert! ");
            insulinCaution = true;
        }
        else{
            insulinCaution = false;
        }
        return insulinCaution;
    }
}
