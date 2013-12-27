package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Contact
 */
@Entity
@Table(name = "contact")
public class Contact extends BaseEntity {

    private String value;
    @ManyToOne
    private Type type;
    @ManyToOne
    private Category category;
    private int preference;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "value='" + value + '\'' +
                ", type=" + type +
                ", category=" + category +
                ", preference=" + preference +
                "} " + super.toString();
    }

    @Entity
    @Table(name = "contact_type")
    public static class Type extends BaseEntity {
        private String name;

        public Type() {
        }

        public Type(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Type{" +
                    "name='" + name + '\'' +
                    "} " + super.toString();
        }
    }

    @Entity
    @Table(name = "contact_category")
    public static class Category extends BaseEntity {
        private String name;

        public Category() {
        }

        public Category(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "name='" + name + '\'' +
                    "} " + super.toString();
        }
    }

}
