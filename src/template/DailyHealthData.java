package template;

public class DailyHealthData {
    private String date;
    private double bloodSugarLevel;
    private double insulinDose;
    private double carbsIntake;
    private boolean healthCheck; // HealthCheckObserver에 세용될 불리안 변수

    public DailyHealthData() {
        this.bloodSugarLevel = 0.0;
        this.carbsIntake = 0.0;
        this.insulinDose = 0.0;
        this.healthCheck = false;
    }

    public DailyHealthData(String date, double bloodSugarLevel, double insulinDose, double carbsIntake, boolean healthCheck) {
        this.date = date;
        this.bloodSugarLevel = bloodSugarLevel;
        this.insulinDose = insulinDose;
        this.carbsIntake = carbsIntake;
        this.healthCheck = healthCheck;
    }
    // 이하 게터 세터
    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getBloodSugarLevel() {
        return this.bloodSugarLevel;
    }

    public void setBloodSugarLevel(double bloodSugarLevel) {
        this.bloodSugarLevel = bloodSugarLevel;
    }

    public double getInsulinDose() {
        return this.insulinDose;
    }

    public void setInsulinDose(double insulinDose) {
        this.insulinDose = insulinDose;
    }

    public double getCarbsIntake() {
        return this.carbsIntake;
    }

    public void setCarbsIntake(double carbsIntake) {
        this.carbsIntake = carbsIntake;
    }

    public boolean setHealthCheck(){
        return this.healthCheck;
    }

    public void getHealthCheck(boolean healthCheck){
        this.healthCheck = healthCheck;
    }

    @Override
    public String toString() {
        return "{" +
                " date='" + date + "'" +
                ", bloodSugarLevel='" + bloodSugarLevel + "'" +
                ", insulinDose='" + insulinDose + "'" +
                ", carbsIntake='" + carbsIntake + "'" +
                "}";
    }
}
