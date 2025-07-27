package entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vacations")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @Column(name = "vacation_title")
    private String vacationTitle;

    @Column(name = "description")
    private String description;

    @Column(name = "travel_fare_price")
    private BigDecimal travelPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "create_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
    private Set<Excursion> excursions;

    public Vacation() {}

    public Vacation(String vacationTitle, String description, BigDecimal travelPrice, String imageUrl) {
        this.vacationTitle = vacationTitle;
        this.description = description;
        this.travelPrice = travelPrice;
        this.imageUrl = imageUrl;
        this.createDate = new Date();
        this.lastUpdate = new Date();
    }

    public String getTitle() {
        return this.vacationTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVacationTitle() {
        return vacationTitle;
    }

    public void setVacationTitle(String vacationTitle) {
        this.vacationTitle = vacationTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getTravelPrice() {
        return travelPrice;
    }

    public void setTravelPrice(BigDecimal travelPrice) {
        this.travelPrice = travelPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Set<Excursion> getExcursions() {
        return excursions;
    }

    public void setExcursions(Set<Excursion> excursions) {
        this.excursions = excursions;
    }
}