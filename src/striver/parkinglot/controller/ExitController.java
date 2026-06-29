package striver.parkinglot.controller;

import java.util.UUID;

public class ExitController {

    public ExitController() {
    }

    public record ExitResult(boolean success, UUID receiptId, double fee, String message) {}
}
