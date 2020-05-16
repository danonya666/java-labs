import ru.billing.stocklist.FoodItem;

public class ThirdStringsMain {
    public static void main(String[] argc) {
        String line = "Конфеты 'Маска';45;120";
        String[] item_fld = new String[3];
        item_fld = line.split(";");
        FoodItem fi = new FoodItem(item_fld[0], Float.valueOf(item_fld[1]), Byte.valueOf(item_fld[2]));
        fi.printAll();
    }
}
