package com.onepay.balance.controller;

import com.onepay.balance.dto.OperationHistoryDTO;
import com.onepay.balance.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/operations")
public class OperationController {

    private final OperationService operationService;

    @GetMapping("/user/{id}")
    public ResponseEntity<List<OperationHistoryDTO>> getUserOperationHistory(@PathVariable("id") Integer id,
                                                                             @RequestParam(name = "dateFrom", required = false)
                                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom) {
        List<OperationHistoryDTO> operations = operationService.getUserOperationHistory(id, dateFrom);
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOperation(@PathVariable("id") Integer id) {
        operationService.deleteById(id);
        return ResponseEntity.ok("Delete operation.");
    }
}
