package striver.parkinglot.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;


@Getter
@ToString
public class PricingRule {

    private UUID id;
    private Vehicle.VehicleType vehicleType;
    private double flatRate;
    private double ratePerHour;

    public PricingRule(Vehicle.VehicleType vehicleType, double flatRate, double ratePerHour) {
        this.id = UUID.randomUUID();
        this.vehicleType = vehicleType;
        this.flatRate = flatRate;
        this.ratePerHour = ratePerHour;
    }

    public void updateRates(double ratePerHour, double flatRate) {
        updateFlatRate(flatRate);
        updateHourlyRate(ratePerHour);
    }

    public void updateFlatRate(double flatRate) {
        this.flatRate = flatRate;
    }

    public void updateHourlyRate(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }
}
