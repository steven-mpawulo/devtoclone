package com.example.devtoclone.controllers;

import com.example.devtoclone.models.Organization;
import com.example.devtoclone.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrganizationController {
    @Autowired
    private OrganizationRepository organizationRepository;
    @PostMapping("/organizations")
    public Organization addOrganization(@RequestBody Organization organization) {
        return organizationRepository.save(organization);
    }
}
