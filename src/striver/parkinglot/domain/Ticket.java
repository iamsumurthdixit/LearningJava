package striver.parkinglot.domain;

import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@Getter
@ToString
public class Ticket {

    /*
    "I'd store timestamps as Instant because it represents an absolute UTC point in time and avoids timezone ambiguity across distributed servers. LocalDateTime is more appropriate for user-facing calendar values. For billing, auditing, event ordering, and persistence, I'd use Instant and convert it to the user's timezone only when displaying it."
     */

    private UUID id;
    private UUID slotId;
    private UUID vehicleId;
    private Instant entryTime; // not using LocalDateTime
    private boolean isActive;

    public Ticket(UUID slotId, UUID vehicleId) {
        this.id = UUID.randomUUID();
        this.slotId = slotId;
        this.vehicleId = vehicleId;
        this.entryTime = Instant.now();
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }
}
