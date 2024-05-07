package com.lbg.PersonalProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.PersonalProject.domain.Transaction;

public interface TransactionRepo extends  JpaRepository<Transaction, Integer> {

}
