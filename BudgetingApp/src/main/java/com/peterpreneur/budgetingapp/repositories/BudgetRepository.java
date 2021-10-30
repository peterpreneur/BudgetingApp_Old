package com.peterpreneur.budgetingapp.repositories;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peterpreneur.budgetingapp.domain.Budget;
import com.peterpreneur.budgetingapp.domain.User;

public interface BudgetRepository extends JpaRepository<Budget, Long> 
{
	TreeSet<Budget> findByUsers(Set<User> users);
}
