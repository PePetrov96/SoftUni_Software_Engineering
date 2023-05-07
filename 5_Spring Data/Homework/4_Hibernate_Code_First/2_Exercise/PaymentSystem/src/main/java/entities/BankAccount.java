package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetail{
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "SWIFT_code")
    private String SWIFTCode;

    public BankAccount() {}

    public BankAccount(String number, String bankName, String SWIFTCode) {
        super(number);
        setBankName(bankName);
        setSWIFTCode(SWIFTCode);
    }

    public String getBankName() {
        return bankName;
    }

    public String getSWIFTCode() {
        return SWIFTCode;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setSWIFTCode(String SWIFTCode) {
        this.SWIFTCode = SWIFTCode;
    }
}