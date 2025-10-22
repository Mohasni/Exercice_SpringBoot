package com.exercice.exo9.model;

public class BankMapper {
    public static BankDTO toDTO(BankAccount bankAccount){
        return new BankDTO(
                bankAccount.getOwner(),
                bankAccount.getBalance()
        );
    }

    public static BankAccount toEntity(BankDTO bankDTO){
        return new BankAccount(
                bankDTO.getOwner(),
                bankDTO.getBalance()
        );
    }
}
