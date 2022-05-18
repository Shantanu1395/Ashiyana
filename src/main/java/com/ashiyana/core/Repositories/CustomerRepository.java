package com.ashiyana.core.Repositories;

import com.ashiyana.core.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
