package com.onepay.balance.dto;

import com.onepay.balance.entity.enums.OperationStatus;
import com.onepay.balance.entity.enums.OperationType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommitOperationDTO {

    Integer userId;
    BigDecimal sum;
    OperationType type;
    OperationStatus status;
}
