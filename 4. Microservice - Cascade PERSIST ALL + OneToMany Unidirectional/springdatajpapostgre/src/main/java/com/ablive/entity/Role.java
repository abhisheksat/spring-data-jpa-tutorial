package com.ablive.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    //  CascadeType.PERSIST alone will not remove the associated user records for a role,
    //  however, using CascadeType.PERSIST with orphanRemoval = true works as CascadeType.ALL
    //  So, when a role, say 1 ADMIN is removed then all the users that have the role as 1 ADMIN are removed
    //  The mapping table where the relationship between role-user is maintained is also cleared for the role code 1 ADMIN
    //  @OneToMany(targetEntity = User.class, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                '}';
    }

}