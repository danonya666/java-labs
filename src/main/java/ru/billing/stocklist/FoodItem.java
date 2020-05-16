package ru.billing.stocklist;

import java.util.Date;
import java.util.Objects;

public class FoodItem extends GenericItem {
    private Date dateOfIncome;
    private short expires;

    public FoodItem(String name, float price, GenericItem analogue, Date dateOfIncome, short expires) {
        super(name, price, analogue);
        this.dateOfIncome = dateOfIncome;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires) {
        super(name, price, Category.GENERAL);
        analogue = null;
        dateOfIncome = new Date();
        this.expires = expires;
    }

    public FoodItem(String name) {
        this.name = name;
    }

    public FoodItem() {
    }

    @Override
    public void printAll() {
        super.printAll();
        System.out.format("date of income: %s, expires after: %d days\n", dateOfIncome, expires);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodItem)) return false;
        if (!super.equals(o)) return false;
        FoodItem foodItem = (FoodItem) o;
        return id == foodItem.id && expires == foodItem.expires &&
                Objects.equals(dateOfIncome, foodItem.dateOfIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfIncome, expires);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "ru.billing.stocklist.FoodItem{" +
                "dateOfIncome=" + dateOfIncome +
                ", expires=" + expires +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", analogue=" + analogue +
                ", category=" + category +
                '}';
    }

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }
}
