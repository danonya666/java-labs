package ru.billing.stocklist;

import jdk.jshell.spi.ExecutionControl;
import org.bson.Document;

public class GenericItem {
    protected int id;
    protected String name;
    protected float price;
    protected GenericItem analogue;
    protected Category category = Category.GENERAL;
    static int currentID = 0;
    public void printAll() {
        System.out.printf("ID: %d , Name: %-20s , price:%5.2f category: %s\n", id, name, price, category);
    }

    public GenericItem(String name, float price, Category category) {
        this();
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public GenericItem(String name, float price, GenericItem analogue) {
        this();
        this.name = name;
        this.price = price;
        this.analogue = analogue;
    }

    public GenericItem(String name, float price) {
        this();
        this.name = name;
        this.price = price;
    }

    public GenericItem(Document doc) {
        this();
        System.out.print(doc);
    }

    public GenericItem() {
        this.id = GenericItem.currentID++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericItem)) return false;
        GenericItem that = (GenericItem) o;
        return id == that.id &&
                Float.compare(that.price, price) == 0 &&
                name.equals(that.name) &&
                category == that.category;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return analogue;
    }

    @Override
    public String toString() {
        return "ru.billing.stocklist.GenericItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", analogue=" + analogue +
                ", category=" + category +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public GenericItem getAnalogue() {
        return analogue;
    }

    public Category getCategory() {
        return category;
    }

    public static int getCurrentID() {
        return currentID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAnalogue(GenericItem analogue) {
        this.analogue = analogue;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static void setCurrentID(int currentID) {
        GenericItem.currentID = currentID;
    }

}
