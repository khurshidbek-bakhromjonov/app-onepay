package com.onepay.balance.controller;

import com.onepay.balance.service.BalanceService;
import com.onepay.balance.service.BalanceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/balances")
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping("/{userId}")
    public ResponseEntity<BigDecimal> getUserBalance(@PathVariable("userId") Integer userId) {
        BigDecimal balance = balanceService.getUserBalance(userId);
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }

    @PostMapping("/{userId}/deb")
    public ResponseEntity<String> debitingFromUserBalance(@PathVariable("userId") Integer userId,
                                                          @RequestParam("sum") BigDecimal sum) {
        boolean changingUserBalance = balanceService.debitingFundsFromBankAccount(userId, sum);

        return changingUserBalance ?
                new ResponseEntity<>("Successfully debiting.", HttpStatus.OK) :
                new ResponseEntity<>("Error debiting.", HttpStatus.LOCKED);

    }

    @PostMapping("/{userId}/ent")
    public ResponseEntity<String> entranceToUserBalance(@PathVariable("userId") Integer userId,
                                                        @RequestParam("sum") BigDecimal sum) {
        balanceService.entranceFundsToBankAccount(userId, sum);
        return ResponseEntity.ok("Successfully entrance " + sum);
    }
}
