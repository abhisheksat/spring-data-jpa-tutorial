package com.ablive.service;

import com.ablive.entity.Organization;
import com.ablive.repository.AddressRepository;
import com.ablive.repository.OrganizationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    private AddressRepository addressRepository;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, AddressRepository addressRepository) {
        this.organizationRepository = organizationRepository;
        this.addressRepository = addressRepository;
    }

    //  As we create an organization, the corresponding address is also created
    //  The one-to-one mapping and CascadeType.ALL with @Transactional, ensure that the address record is added and the
    //  foreign key reference is made available to the organization
    @Override
    @Transactional
    public ResponseEntity<Object> createOrganization(Organization organization) {
        Organization org = new Organization();
        org.setName(organization.getName());
        org.setOrgId(organization.getOrgId());
        org.setAddress(organization.getAddress());

        Organization savedOrg = organizationRepository.save(org);
        if (organizationRepository.findById(savedOrg.getId()).isPresent()) {
            return ResponseEntity.ok().body("Organization created successfully");
        } else {
            return ResponseEntity.unprocessableEntity().body("Failed to created the given organization");
        }
    }

    //  Find the organization to update
    //  Delete the previous address record
    //  Add the new address to the table and update the address id as foreign key
    @Override
    @Transactional
    public ResponseEntity<Object> updateOrganization(Long id, Organization org) {
        if (organizationRepository.findById(id).isPresent()) {
            Organization organization = organizationRepository.findById(id).get();
            organization.setName(org.getName());
            organization.setOrgId(org.getOrgId());
            addressRepository.deleteById(organization.getAddress().getId());
            organization.setAddress(org.getAddress());
            Organization savedOrganization = organizationRepository.save(organization);
            if (organizationRepository.findById(savedOrganization.getId()).isPresent()) {
                return ResponseEntity.ok().body("Successfully updated organization");
            } else {
                return ResponseEntity.unprocessableEntity().body("Failed to update the specified organization");
            }
        } else {
            return ResponseEntity.unprocessableEntity().body("Organization Not Found");
        }
    }
}