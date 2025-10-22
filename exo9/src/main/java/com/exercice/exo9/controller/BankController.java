package com.exercice.exo9.controller;
import com.exercice.exo9.model.BankDTO;
import com.exercice.exo9.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;

    @PostMapping("/api/account")
    public BankDTO postAccount(@RequestBody BankDTO bankDTO){
        System.out.println(bankDTO);
        return bankService.postAccount(bankDTO);
    }

    @PutMapping("/api/transfer")
    public void transfer(@RequestParam Long fromId,@RequestParam Long toId,@RequestParam Long amount){
        bankService.tansfer(fromId, toId, amount);
    }
}
