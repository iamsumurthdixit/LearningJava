package striver.parkinglot.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class Vehicle {

    private UUID id;
    private String licensePlate;
    private VehicleType type;

    public enum VehicleType {
        CAR, BIKE, TRUCK, EV
    }
}
