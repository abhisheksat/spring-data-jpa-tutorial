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

    //  JoinColumn on the role id establishes the foreign key relation
    //  CascadeType.ALL helps us operate on the associated user objects as we have bidirectional relationship
    //  So a change to role will affect all the corresponding users as well
    @JoinColumn(name = "role_id")
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