package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Base model for database entities
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "seq")
    private Long id;
    private Date createdAt;
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }
}
