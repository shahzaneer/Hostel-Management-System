public class Mess {
    private double messBill;


    public Mess() {
    }

    public Mess(double messBill) {
        this.messBill = messBill;
    }

    public double getMessBill() {
        return this.messBill;
    }

    public void setMessBill(double messBill) {
        this.messBill = messBill;
    }

    // adding visitors to mess
    public void addVisitors(double visitors , double days) {
        for (int i = 0; i < days; i++) {
            this.messBill += visitors * 200;
        }
    }

    @Override
    public String toString() {
        return
        "Mess Bill = " + getMessBill();
    }

}
