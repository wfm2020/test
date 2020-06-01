package pawnshop.dto;

import java.time.LocalDateTime;

public class DeliveryDataDTO {

    private LocalDateTime dateTime;

    private long pawnedItemId;

    public DeliveryDataDTO() {
    }

    public DeliveryDataDTO(LocalDateTime dateTime, long pawnedItemId) {
        this.dateTime = dateTime;
        this.pawnedItemId = pawnedItemId;
    }

    public long getPawnedItemId() {
        return pawnedItemId;
    }

    public void setPawnedItemId(long pawnedItemId) {
        this.pawnedItemId = pawnedItemId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
