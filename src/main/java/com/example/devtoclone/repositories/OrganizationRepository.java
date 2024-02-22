package com.example.devtoclone.repositories;

import com.example.devtoclone.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
