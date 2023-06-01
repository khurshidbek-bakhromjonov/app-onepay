package com.onepay.balance.dto;

import com.onepay.balance.entity.enums.OperationStatus;
import com.onepay.balance.entity.enums.OperationType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationHistoryDTO implements Comparable<OperationHistoryDTO> {

    Integer id;
    BigDecimal sum;
    LocalDate dateCreatedAt;
    LocalTime timeCreatedAt;
    OperationType type;
    OperationStatus status;

    @Override
    public int compareTo(OperationHistoryDTO o) {
        boolean isDatesEquals = this.getDateCreatedAt().isEqual(o.getDateCreatedAt());
        if (isDatesEquals)
            return o.getTimeCreatedAt().compareTo(this.getTimeCreatedAt());

        return o.getDateCreatedAt().compareTo(this.getDateCreatedAt());
    }
}
