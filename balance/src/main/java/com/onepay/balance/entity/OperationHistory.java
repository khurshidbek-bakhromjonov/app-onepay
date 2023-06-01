package com.onepay.balance.entity;

import com.onepay.balance.entity.enums.OperationStatus;
import com.onepay.balance.entity.enums.OperationType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "operation_history")
@Getter
@Setter
public class OperationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "user_id")
    Integer userId;

    BigDecimal sum;

    @Column(name = "date_crated_at")
    LocalDate dateCreatedAt;

    @Column(name = "time_crated_ct")
    LocalTime timeCreatedAt;

    @Enumerated(EnumType.STRING)
    OperationType type;

    @Enumerated(EnumType.STRING)
    OperationStatus status;

    @PrePersist
    void initialize() {
        dateCreatedAt = LocalDate.now();
        timeCreatedAt = LocalTime.now();
    }
}
