package models;

import java.util.Date;
import java.util.UUID;

/**
 * Base class
 */
public abstract class Entity {
    private final String id;
    private final Date createdAt;
    private Date updatedAt;

    protected Entity() {
        id = UUID.randomUUID().toString().replaceAll("-", "");
        createdAt = new Date();
        updatedAt = new Date();
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
