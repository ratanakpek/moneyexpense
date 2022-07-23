package ratanak.pek.moneyexpense.experiment.designpattern.strategy;

public abstract class Duck {
    protected FlyBehaviour flyBehaviour;

    public Duck(FlyBehaviour flyBehaviour){
        this.flyBehaviour = flyBehaviour;
    }
    public void performFly(){
        flyBehaviour.fly();
    }
}
