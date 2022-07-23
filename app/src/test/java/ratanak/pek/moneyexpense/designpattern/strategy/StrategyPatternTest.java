package ratanak.pek.moneyexpense.designpattern.strategy;

import org.junit.Test;

import ratanak.pek.moneyexpense.experiment.designpattern.strategy.Duck;
import ratanak.pek.moneyexpense.experiment.designpattern.strategy.FlyBehaviour;
import ratanak.pek.moneyexpense.experiment.designpattern.strategy.FlyWithWings;
import ratanak.pek.moneyexpense.experiment.designpattern.strategy.FlyWithoutWings;
import ratanak.pek.moneyexpense.experiment.designpattern.strategy.Mallarduck;
import ratanak.pek.moneyexpense.experiment.designpattern.strategy.outofthebox.ChatStrategy;
import ratanak.pek.moneyexpense.experiment.designpattern.strategy.outofthebox.StrategyWooCuteGirl;
import ratanak.pek.moneyexpense.experiment.designpattern.strategy.outofthebox.WooCuteGirl;

public class StrategyPatternTest {

    @Test
    public void initPattern() {
        FlyBehaviour flyWithWings = new FlyWithWings();
        Duck mallarDuck = new Mallarduck(flyWithWings);

        mallarDuck.performFly();

        FlyBehaviour flyWithoutWings = new FlyWithoutWings();
        Duck withoutWings = new Mallarduck(flyWithoutWings);
        withoutWings.performFly();
    }

    @Test
    public void outofthebox(){

        StrategyWooCuteGirl chatStrategy = new ChatStrategy();
        WooCuteGirl wooCuteGirl = new WooCuteGirl(chatStrategy);

        wooCuteGirl.perform();
    }
}
