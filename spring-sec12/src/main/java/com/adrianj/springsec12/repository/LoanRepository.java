package com.adrianj.springsec12.repository;

import java.util.List;

import com.adrianj.springsec12.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<Loans, Long> {

	// @PreAuthorize("hasRole('USER')") // TODO 3 Checks role before executing the method
	List<Loans> findByCustomerIdOrderByStartDtDesc(long customerId);

}
