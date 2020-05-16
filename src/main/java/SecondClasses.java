import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.TechnicalItem;

public class SecondClasses {
    public static void main(String[] argc) {
        GenericItem item1 = new GenericItem();
        GenericItem item2 = new GenericItem();
        GenericItem item3 = new GenericItem();
        item1.printAll();
        item2.printAll();
        item3.printAll();

        GenericItem item4 = new FoodItem();
        GenericItem item5 = new TechnicalItem();

        GenericItem[] arr = {item4, item5};

        for (GenericItem el: arr) {
            el.printAll();
        }
    }
}

