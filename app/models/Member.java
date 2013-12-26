package models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Club member
 *
 * @author Hugo Cura
 */
@Entity
@Table(name = "member")
public class Member extends BaseEntity {

    private String member;
    private String name;
    private Date birth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(length = 2)
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
    private Date admission;
    @ManyToOne
    private Category category;
    @OneToMany
    @JoinTable(
            name = "member_custom_attribute",
            joinColumns = {@JoinColumn(name = "member_id")},
            inverseJoinColumns = {@JoinColumn(name = "custom_attribute_id")}
    )
    private Set<CustomAttribute> customAttributes;

    public Member() {
        super();
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

        private String name;

        public Category() {
            super();
        }

        public Category(String name) {
            super();
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
        private String value;
        @ManyToOne
        private CustomAttributeType type;

        public CustomAttribute() {
            super();
        }

        public CustomAttribute(String value, CustomAttributeType type) {
            super();
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
        private String name;

        public CustomAttributeType() {
            super();
        }

        public CustomAttributeType(String name) {
            super();
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
