package entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_first_name")
    private String firstName;

    @Column(name = "customer_last_name")
    private String lastName;

    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    private String phone;

    @Column(name = "create_date", updatable = false)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts;

    public Customer() {
    }

    public Customer(
            Long id,
            String address,
            String postalCode,
            String firstName,
            String lastName,
            String phone,
            Division division
    ) {
        this.id = id;
        this.address = address;
        this.postalCode = postalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.division = division;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }
}

