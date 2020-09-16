package com.ablive.entity;

import javax.persistence.*;
import java.util.List;

/**
 *  User Entity
 */
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email", unique = true)
    private String email;

    //  Many to Many - Unidirectional
    //  So, for a given User, there are multiple roles, and a role type can have multiple users for it
    //  Such a relationship is maintained using role-user table, where for role-id we have a user-id
    //  In this case, we only see who roles does the given user carry with itself, hence unidirectional
    //  CascadeType.ALL ensures that if a user is deleted and that role does not have any other users,
    //  the role record will also be deleted
    //  When a user is created with role details, then the role record is also added if it is not present and the
    //  relationship of the role-id and user-id is recorded in the many-to-many table
    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}