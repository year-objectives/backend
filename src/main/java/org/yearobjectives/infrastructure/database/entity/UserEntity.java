package org.yearobjectives.infrastructure.database.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_generator")
    @SequenceGenerator(name = "users_generator", sequenceName = "users_seq", allocationSize = 1)
    private Long id;

    @Column
    private String name;

    @Column
    private UUID resourceId;

    @Column
    private String email;

    @Column
    private String userName;
    
    @Column
    private String password;

    public UserEntity(String name, UUID resourceId, String email, String userName, String password) {
        this.name = name;
        this.resourceId = resourceId;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, resourceId, email, userName, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserEntity other = (UserEntity) obj;
        return Objects.equals(id, other.id) && Objects.equals(name, other.name)
                && Objects.equals(resourceId, other.resourceId) && Objects.equals(email, other.email)
                && Objects.equals(userName, other.userName) && Objects.equals(password, other.password);
    }
  
    
}
