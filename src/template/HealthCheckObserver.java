// MY CODE 새로운 옵저버 클래스
package template;

public class HealthCheckObserver implements Observer{

    boolean healthCaution; // 경고 상태 판별을 위한 불리안값

    @Override
    public boolean update(DailyHealthData d) {
        // 하나라도 true이면 경고 상태
        if (BloodSugarObserver.bloodSugarCaution == true || 
            CarbIntakeObserver.carbIntakeCaution == true || 
            InsulinObserver.insulinCaution == true) {
            
            healthCaution = true;
            System.out.print("\nBe cautious about your health...");
        } else {
            healthCaution = false;
            System.out.print("\nYou are healthy today!");
        }
        return healthCaution;
    }
}
