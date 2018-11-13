package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "[pizzeria].[dbo].[discount]")
public class Discount extends AbstractModel {
    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private int percentValue;

    private long useTimestamp;

    @Column(nullable = false)
    private boolean used = false;

    @Column(nullable = false)
    private long expireTimestamp;

    @Column(nullable = false)
    private boolean active = true;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPercentValue() {
        return percentValue;
    }

    public void setPercentValue(int percent) {
        this.percentValue = percent;
    }

    public long getUseTimestamp() {
        return useTimestamp;
    }

    public void setUseTimestamp(long activateTimestamp) {
        this.useTimestamp = activateTimestamp;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean activated) {
        if (!this.used && activated) {
            useTimestamp = System.currentTimeMillis();
        }
        this.used = activated;
    }

    public long getExpireTimestamp() {
        return expireTimestamp;
    }

    public void setExpireTimestamp(long expireTimestamp) {
        this.expireTimestamp = expireTimestamp;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
