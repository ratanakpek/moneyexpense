package ratanak.pek.moneyexpense.experiment.designpattern.strategy.outofthebox;

public class WooCuteGirl {
    StrategyWooCuteGirl strategyWooCuteGirl;

    public WooCuteGirl(StrategyWooCuteGirl strategyWooCuteGirl) {
        this.strategyWooCuteGirl = strategyWooCuteGirl;
    }

    public void perform() {
        strategyWooCuteGirl.startWoo();
    }
}
