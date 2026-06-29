package striver.parkinglot.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class ParkingSlot {

    private UUID id;
    private Vehicle.VehicleType slotType;
    @Setter private boolean isOccupied;
    private int floorNumber;

    public ParkingSlot(Vehicle.VehicleType slotType, int floorNumber) {
        this.id = UUID.randomUUID();
        this.slotType = slotType;
        this.isOccupied = false;
        this.floorNumber = floorNumber;
    }
}
