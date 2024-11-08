
package com.example.democourierservicemanagementsystem.repositories;

import com.example.democourierservicemanagementsystem.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
