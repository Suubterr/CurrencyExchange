package pojo.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @Column(name = "currency_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int currentyId;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "long_name")
    private String longName;

    public int getCurrentyId() {
        return currentyId;
    }

    @Column(name = "country")
    private String country;

    @Column(name = "sell")
    private float sell;

    @Column(name = "buy")
    private float buy;

    public void setCurrentyId(int currentyId) {
        this.currentyId = currentyId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getSell() {
        return sell;
    }

    public void setSell(float sell) {
        this.sell = sell;
    }

    public float getBuy() {
        return buy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }
}
