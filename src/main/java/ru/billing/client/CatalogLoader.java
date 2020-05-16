package ru.billing.client;

import ru.billing.stocklist.ItemCatalog;
import ru.itmo.exceptions.CatalogLoadException;

public interface CatalogLoader {
    void load(ItemCatalog cat) throws CatalogLoadException;
}
