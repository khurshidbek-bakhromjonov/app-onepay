package com.onepay.balance.mapper;

import com.onepay.balance.dto.OperationHistoryDTO;
import com.onepay.balance.entity.OperationHistory;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OperationHistoryDTOMapper implements Function<OperationHistory, OperationHistoryDTO> {

    @Override
    public OperationHistoryDTO apply(OperationHistory operationHistory) {
        return OperationHistoryDTO.builder()
                .id(operationHistory.getId())
                .sum(operationHistory.getSum())
                .dateCreatedAt(operationHistory.getDateCreatedAt())
                .timeCreatedAt(operationHistory.getTimeCreatedAt())
                .type(operationHistory.getType())
                .status(operationHistory.getStatus())
                .build();
    }
}
