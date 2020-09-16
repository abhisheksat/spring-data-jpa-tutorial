package com.ablive.service;

import com.ablive.entity.Organization;
import org.springframework.http.ResponseEntity;

public interface OrganizationService {
    ResponseEntity<Object> createOrganization(Organization organization);
    ResponseEntity<Object> updateOrganization(Long id, Organization org);
}