package striver.parkinglot.controller;

import java.util.UUID;

public class EntryController {

    public EntryController() {

    }

    // VERY IMPORTANT written inside because outer class "OWNS" this class
    public record EntryResult(boolean success, UUID ticketId, UUID slotId, String message) { }
}
