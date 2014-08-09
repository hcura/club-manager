package com.bwu.cm.models;

import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Club member
 *
 * @author Hugo Cura
 */
@Entity
@Table(
        name = "member",
        uniqueConstraints = @UniqueConstraint(columnNames = "member")
)
public class Member extends BaseEntity {

    @Constraints.Required
    private String member;
    @Constraints.Required
    private String name;
    @Past
    private Date birth;
    @Constraints.Required
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Constraints.Required
    private String country;
    @OneToMany
    @JoinTable(
            name = "member_address",
            joinColumns = {@JoinColumn(name = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "address_id")}
    )
    private Set<Address> addresses;
    @OneToMany
    @JoinTable(
            name = "member_contact",
            joinColumns = {@JoinColumn(name = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "contact_id")}
    )
    private Set<Contact> contacts;
    @Constraints.Required
    private Date admission;
    @ManyToOne
    private Category category;
    @OneToMany
    @JoinColumn(name = "member_id")
    private Set<CustomAttribute> customAttributes;

    public Member() {
        addresses = new HashSet<>();
        contacts = new HashSet<>();
        customAttributes = new HashSet<>();
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Date getAdmission() {
        return admission;
    }

    public void setAdmission(Date admission) {
        this.admission = admission;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Member{" +
                "member='" + member + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", addresses=" + addresses +
                ", contacts=" + contacts +
                ", admission=" + admission +
                ", category=" + category +
                ", customAttributes=" + customAttributes +
                "} " + super.toString();
    }

    @Entity
    @Table(name = "member_category")
    public static class Category extends BaseEntity {
        @Constraints.Required
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
                    '}';
        }
    }

    /**
     * Member custom attribute
     */
    @Entity
    @Table(name = "member_custom_attribute")
    public static class CustomAttribute extends BaseEntity {
        @Constraints.Required
        private String value;
        @ManyToOne
        @JoinColumn(name = "type_id")
        private CustomAttributeType type;

        public CustomAttribute() {
        }

        public CustomAttribute(String value, CustomAttributeType type) {
            this.value = value;
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public CustomAttributeType getType() {
            return type;
        }

        public void setType(CustomAttributeType type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "CustomAttribute{" +
                    "value='" + value + '\'' +
                    ", type=" + type +
                    "} " + super.toString();
        }
    }

    /**
     * Configurable extra custom data type
     */
    @Entity
    @Table(name = "member_custom_attribute_type")
    public static class CustomAttributeType extends BaseEntity {
        @Constraints.Required
        private String name;

        public CustomAttributeType() {
        }

        public CustomAttributeType(String name) {
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
            return "CustomAttributeType{" +
                    "name='" + name + '\'' +
                    "} " + super.toString();
        }
    }

}
