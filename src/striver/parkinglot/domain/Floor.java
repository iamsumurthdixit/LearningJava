package striver.parkinglot.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@ToString
public class Floor {

    private UUID id;
    private int floorNumber;
    @Setter private List<ParkingSlot> slots;

    public Floor(int floorNumber) {
        this.id = UUID.randomUUID();
        this.floorNumber = floorNumber;
        this.slots = new ArrayList<>();
    }

    public void addSlot(ParkingSlot slot) {
        slots.add(slot);
    }

    public List<ParkingSlot> getAvailableSlots(Vehicle.VehicleType type) {
        List<ParkingSlot> availableSlots = new ArrayList<>();
        for (var slot: slots) {
            if (slot.getSlotType() == type && !slot.isOccupied()) {
                availableSlots.add(slot);
            }
        }
        return availableSlots;
    }

    public int getAvailableSlotsCount(Vehicle.VehicleType type) {
        return getAvailableSlots(type).size();
    }
}
