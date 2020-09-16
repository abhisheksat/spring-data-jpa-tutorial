package com.ablive.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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

    @Transient
    private String roleName;

    //  The user has a associated role. A user has a role, but a role can have multiple users
    //  So here, the role_id becomes the foreign key for the respective user
    //  Also, CascadeType.ALL enables us to create a User object and supply the role data as well
    //  This will store the role details of the user in t_role table and user details will be stored in t_user table
    //  JsonIgnore: Prevents recursive calling from Role -> User -> Role -> User : StackOverflowError
    //  So, we can get Role and all the associated Users. To get the role of a user we have a custom property defined above
    //  roleName can be extracted from the role object and return in place of the whole role object
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Role role;

    public String getRoleName() {
        return getRole().getName();
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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