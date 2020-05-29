package pawnshop.dto;

import java.time.LocalDateTime;

public class DeliveryDataDTO {

    private LocalDateTime dateTime;

    public DeliveryDataDTO(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
