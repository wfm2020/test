package pawnshop.dto;

import java.time.LocalDateTime;

public class DeliveryDataDTO {

    private LocalDateTime deliveryDate;

    private long pawnedItemId;

    public DeliveryDataDTO() {
    }

    public DeliveryDataDTO(LocalDateTime deliveryDate, long pawnedItemId) {
        this.deliveryDate = deliveryDate;
        this.pawnedItemId = pawnedItemId;
    }

    public long getPawnedItemId() {
        return pawnedItemId;
    }

    public void setPawnedItemId(long pawnedItemId) {
        this.pawnedItemId = pawnedItemId;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
