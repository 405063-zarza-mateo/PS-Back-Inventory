package org.utn.tup.backinventory.Service;

import org.utn.tup.backinventory.Dto.PostItemDto;
import org.utn.tup.backinventory.Entity.ItemEntity;

import java.util.List;

public interface InventoryService {
    List<ItemEntity> findAll();
    ItemEntity findById(Long id);
    PostItemDto addItem (PostItemDto itemDto);
    ItemEntity updateItem (ItemEntity item);
    void delteItem (Long id);
}
