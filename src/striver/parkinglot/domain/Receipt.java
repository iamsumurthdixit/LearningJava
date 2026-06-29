package striver.parkinglot.domain;

import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@Getter
@ToString
public class Receipt {

    private UUID id;
    private UUID ticketId;
    private Instant exitTime;
    private double totalFee;
    private Payment.PaymentStatus paymentStatus;

    public Receipt(UUID ticketId, double totalFee) {
        this.id = UUID.randomUUID();
        this.ticketId = ticketId;
        this.totalFee = totalFee;
        this.exitTime = Instant.now();
        this.paymentStatus = Payment.PaymentStatus.PENDING;
    }

    public void markAsPaid() {
        this.paymentStatus = Payment.PaymentStatus.SUCCESS;
    }

    public void markAsFailed() {
        this.paymentStatus = Payment.PaymentStatus.FAILED;
    }
}
