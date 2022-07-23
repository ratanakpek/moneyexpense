package ratanak.pek.moneyexpense.experiment.designpattern.strategy;

public class Mallarduck extends Duck{

    public Mallarduck(FlyBehaviour flyBehaviour) {
        super(flyBehaviour);
    }

    public void performFly() {
        flyBehaviour.fly();
    }
}
