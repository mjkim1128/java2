package template;

public class InsulinObserver implements Observer{

    double insulinThresHold;

    public InsulinObserver(double insulinThreshold) {
        this.insulinThresHold = insulinThreshold;
    }

    @Override
    public void update(DailyHealthData d) {
        if(d.getInsulinDose() > insulinThresHold){
            System.out.println("InsulinDose Alert!");
        }
    }
}
