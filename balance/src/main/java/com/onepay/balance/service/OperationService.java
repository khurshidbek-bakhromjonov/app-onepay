package com.onepay.balance.service;

import com.onepay.balance.dto.CommitOperationDTO;
import com.onepay.balance.dto.OperationHistoryDTO;
import com.onepay.balance.entity.OperationHistory;

import java.time.LocalDate;
import java.util.List;

public interface OperationService {
    OperationHistory getOperationHistoryById(Integer id);
    List<OperationHistoryDTO> getUserOperationHistory(Integer id, LocalDate dateFrom);
    void commitOperation(CommitOperationDTO operation);
    void deleteById(Integer id);
}
