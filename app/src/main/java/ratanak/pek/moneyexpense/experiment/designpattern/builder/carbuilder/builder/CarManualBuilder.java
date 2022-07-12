package ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.builder;

import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.cars.Car;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.cars.CarType;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.cars.Manual;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.components.Engine;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.components.GPSNavigator;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.components.Transmission;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.components.TripComputer;

public class CarManualBuilder implements Builder {
    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Manual getResult() {
        return new Manual(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
