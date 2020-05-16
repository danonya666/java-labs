package ru.billing.stocklist;

import java.util.Objects;

public class TechnicalItem extends GenericItem {
    private short warrantyTime;

    @Override
    public void printAll() {
        super.printAll();
        System.out.format("warranty time: %d\n", warrantyTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TechnicalItem)) return false;
        if (!super.equals(o)) return false;
        TechnicalItem that = (TechnicalItem) o;
        return id == that.id && warrantyTime == that.warrantyTime && id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(warrantyTime);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "ru.billing.stocklist.TechnicalItem{" +
                "warrantyTime=" + warrantyTime +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", analogue=" + analogue +
                ", category=" + category +
                '}';
    }

    public short getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }
}
