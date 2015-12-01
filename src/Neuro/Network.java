package Neuro;

public class Network {
         //Все входы нейрона
     public Link[] IncomingLinks;
     // Накопленный нейроном заряд 
     public double Power;

    public void setPower(double Power) {
        this.Power = Power;
    }

    public double getPower() {
        return Power;
    }
}
