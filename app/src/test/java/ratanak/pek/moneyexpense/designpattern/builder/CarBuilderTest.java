package ratanak.pek.moneyexpense.designpattern.builder;

import org.junit.Test;

import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.builder.CarBuilder;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.builder.CarManualBuilder;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.cars.Car;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.cars.Manual;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.director.Director;

public class CarBuilderTest {

    @Test
    public void helloWorld() {
        Director director = new Director();

        // Director gets the concrete builder object from the client
        // (application code). That's because application knows better which
        // builder to use to get a specific product.
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        // The final product is often retrieved from a builder object, since
        // Director is not aware and not dependent on concrete builders and
        // products.
        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());


        CarManualBuilder manualBuilder = new CarManualBuilder();

        // Director may know several building recipes.
        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}
