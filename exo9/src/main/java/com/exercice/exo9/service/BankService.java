package com.exercice.exo9.service;

import com.exercice.exo9.Error.InsuffisantExeption;
import com.exercice.exo9.model.BankAccount;
import com.exercice.exo9.model.BankDTO;
import com.exercice.exo9.model.BankMapper;
import com.exercice.exo9.repository.BankRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankRepository bankRepository;

        public BankDTO postAccount(BankDTO bankDTO){
        BankAccount bankAccount = BankMapper.toEntity(bankDTO);
        bankAccount = bankRepository.save(bankAccount);
        return BankMapper.toDTO(bankAccount);
    }


    public void tansfer(Long fromId, Long toId, Long amount) {
        BankAccount from = bankRepository.findById(fromId).orElse(null);
        BankAccount to = bankRepository.findById(toId).orElse(null);
        if (from.getBalance() < amount) throw new InsuffisantExeption("Solde insuffisant");
            from.setBalance(from.getBalance() - amount);
            bankRepository.save(from);

           if (true)throw new IllegalArgumentException("Solde insufisant");

            to.setBalance(to.getBalance() + amount);
            bankRepository.save(to);

    }
}
