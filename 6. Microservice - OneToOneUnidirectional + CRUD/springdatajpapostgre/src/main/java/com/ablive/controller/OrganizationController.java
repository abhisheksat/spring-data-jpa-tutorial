package com.ablive.controller;

import com.ablive.entity.Organization;
import com.ablive.repository.OrganizationRepository;
import com.ablive.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {

    private OrganizationService organizationService;
    private OrganizationRepository organizationRepository;

    public OrganizationController(OrganizationService organizationService, OrganizationRepository organizationRepository) {
        this.organizationService = organizationService;
        this.organizationRepository = organizationRepository;
    }

    @PostMapping(value = "/organization/create")
    public ResponseEntity<Object> createOrganization(@RequestBody Organization organization) {
        return organizationService.createOrganization(organization);
    }

    @DeleteMapping(value = "/organization/delete/{id}")
    public ResponseEntity<Object> deleteOrganization(@PathVariable Long id) {
        if (organizationRepository.findById(id).isPresent()) {
            organizationRepository.deleteById(id);
            if (organizationRepository.findById(id).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the organization");
            } else {
                return ResponseEntity.ok("Organization Deleted Successfully");
            }
        } else {
            return ResponseEntity.unprocessableEntity().body("Given organization not found");
        }
    }

    @GetMapping(value = "/organization/get/{id}")
    public Organization getOrganization(@PathVariable Long id) {
        if (organizationRepository.findById(id).isPresent()) {
            return organizationRepository.findById(id).get();
        } else {
            return null;
        }
    }

    @GetMapping(value = "/organization/get")
    public List<Organization> getOrganizations() {
        return organizationRepository.findAll();
    }

    @PutMapping(value = "/organization/update/{id}")
    public ResponseEntity<Object> updateOrganization(@PathVariable Long id, @RequestBody Organization org) {
        return organizationService.updateOrganization(id, org);
    }

}