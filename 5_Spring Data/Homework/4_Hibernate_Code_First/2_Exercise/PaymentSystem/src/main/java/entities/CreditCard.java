package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail{
    @Column(name = "type")
    private String type;

    @Column(name = "expiration_month")
    private String expirationMonth;

    @Column(name = "expiration_year")
    private String expirationYear;

    public CreditCard() {}

    public CreditCard(String number, String type, String expirationMonth, String expirationYear) {
        super(number);
        setType(type);
        setExpirationMonth(expirationMonth);
        setExpirationYear(expirationYear);
    }

    public String getType() {
        return type;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }
}