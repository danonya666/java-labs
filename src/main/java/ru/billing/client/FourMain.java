package ru.billing.client;

import ru.billing.stocklist.GenericItem;
import ru.billing.stocklist.ItemCatalog;
import ru.itmo.exceptions.CatalogLoadException;
import ru.itmo.exceptions.ItemAlreadyExistsException;

import java.util.Date;

public class FourMain {
    public static void main(String[] argc) throws ItemAlreadyExistsException, CatalogLoadException {
        ItemCatalog itemCatalog = new ItemCatalog();
//        GenericItem item = new GenericItem();
        for (int i = 0 ; i < 20; ++i) {
            itemCatalog.addItem(new GenericItem());
//            itemCatalog.addItem(item);
        }

        long begin = new Date().getTime();

        for(int i=0; i<100000;i++)
            itemCatalog.findItemByID(10);
        long end = new Date().getTime();
        System.out.println("In HashMap: "+(end-begin)); begin = new
                Date().getTime();
        for(int i=0; i<100000;i++)
            itemCatalog.findItemByIDAL(10);
        end = new Date().getTime();
        System.out.println("In ArrayList: "+(end-begin));


        CatalogLoader loader = new CatalogSubLoader();

        loader.load(itemCatalog);
        itemCatalog.printItems();

    }
}
