package com.onepay.balance.service;

import com.onepay.balance.dto.CommitOperationDTO;
import com.onepay.balance.dto.OperationHistoryDTO;
import com.onepay.balance.entity.OperationHistory;
import com.onepay.balance.exception.OperationNotFoundException;
import com.onepay.balance.mapper.OperationHistoryDTOMapper;
import com.onepay.balance.repository.OperationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    private final OperationRepository operationRepository;
    private final OperationHistoryDTOMapper operationHistoryDTOMapper;

    @Override
    public OperationHistory getOperationHistoryById(Integer id) {
        return operationRepository.findById(id)
                .orElseThrow(() -> new OperationNotFoundException("Operation not found. Id: " + id));
    }

    @Override
    public List<OperationHistoryDTO> getUserOperationHistory(Integer id, LocalDate dateFrom) {
        Stream<OperationHistoryDTO> operations = operationRepository
                .getOperationHistoriesByUserId(id)
                .stream()
                .map(operationHistoryDTOMapper)
                .sorted(OperationHistoryDTO::compareTo);

        return dateFrom != null ? operations
                        .filter(operation -> operation.getDateCreatedAt().isAfter(dateFrom))
                        .toList() :
                operations
                        .toList();
    }

    @Override
    public void commitOperation(CommitOperationDTO operation) {
        int userId = operation.getUserId();

        operationRepository.save(
                OperationHistory.builder()
                        .userId(userId)
                        .sum(operation.getSum())
                        .type(operation.getType())
                        .status(operation.getStatus())
                        .build()
        );
        log.info("Commit operation. User id: {}", userId);
    }

    @Override
    public void deleteById(Integer id) {
        operationRepository.deleteById(id);
        log.info("Delete operation. Id: {}", id);
    }
}
