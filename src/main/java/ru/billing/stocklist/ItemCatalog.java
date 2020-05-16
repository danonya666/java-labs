package ru.billing.stocklist;

import ru.itmo.exceptions.ItemAlreadyExistsException;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
    private ArrayList<GenericItem> ALCatalog = new ArrayList<GenericItem>();

    public ItemCatalog addItem(GenericItem item) throws ItemAlreadyExistsException {
        System.out.print(item.id);
        System.out.print(catalog.get(item.id));
        if (catalog.get(item.id) != null) {
            throw new ItemAlreadyExistsException();
        }
        catalog.put(item.id, item); // Добавляем товар в HashMap
        ALCatalog.add(item); // Добавляем тот же товар в ArrayList
        return this;
    }

    public void printItems(){
        for(GenericItem i : ALCatalog){
            System.out.println(i);
        }
    }

    public GenericItem findItemByID(int id){
        //Если нет такого ID, возвращаем пустое значение
        if(!catalog.containsKey(id)) {
            return null;
        } else {
            return catalog.get(id);
        }
    }

    public GenericItem findItemByIDAL(int id){
        for(GenericItem i : ALCatalog){
            if(i.id==id) return i;
        }
        return null;
    }

}
