package com.onepay.balance.repository;

import com.onepay.balance.entity.OperationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<OperationHistory, Integer> {

    List<OperationHistory> getOperationHistoriesByUserId(Integer userId);
}
