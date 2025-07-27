package entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    @Column(name = "excursion_title")
    private String excursionTitle;

    @Column(name = "excursion_price")
    private BigDecimal excursionPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "create_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;

    public Excursion() {}

    public Excursion(String excursionTitle, BigDecimal excursionPrice, String imageUrl, Vacation vacation) {
        this.excursionTitle = excursionTitle;
        this.excursionPrice = excursionPrice;
        this.imageUrl = imageUrl;
        this.vacation = vacation;
        this.createDate = new Date();
        this.lastUpdate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExcursionTitle() {
        return excursionTitle;
    }

    public void setExcursionTitle(String excursionTitle) {
        this.excursionTitle = excursionTitle;
    }

    public BigDecimal getExcursionPrice() {
        return excursionPrice;
    }

    public void setExcursionPrice(BigDecimal excursionPrice) {
        this.excursionPrice = excursionPrice;
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

    public Vacation getVacation() {
        return vacation;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}