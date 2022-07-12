package ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.builder;

import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.cars.CarType;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.components.Engine;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.components.GPSNavigator;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.components.Transmission;
import ratanak.pek.moneyexpense.experiment.designpattern.builder.carbuilder.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
