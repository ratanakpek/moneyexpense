package ratanak.pek.moneyexpense.experiment.designpattern.strategy;

public class FlyWithoutWings implements FlyBehaviour{
    @Override
    public void fly() {
        System.out.println("I'm have no wing!!!");
    }
}
