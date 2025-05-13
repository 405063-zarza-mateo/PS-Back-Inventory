package org.utn.tup.backinventory.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.utn.tup.backinventory.Dto.PostItemDto;
import org.utn.tup.backinventory.Entity.ItemEntity;
import org.utn.tup.backinventory.Repository.InventoryRepository;
import org.utn.tup.backinventory.Service.InventoryService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<ItemEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ItemEntity findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Item doesnt exist."));
    }

    @Override
    public PostItemDto addItem(PostItemDto itemDto) {
        ItemEntity entity = modelMapper.map(itemDto, ItemEntity.class);
        repository.save(entity);
        return itemDto;
    }

    @Override
    public ItemEntity updateItem(ItemEntity item) {
        return repository.save(item);

    }

    @Override
    public void delteItem(Long id) {
        if (repository.findById(id).isPresent())
            repository.deleteById(id);
        else
            throw new IllegalArgumentException("Item doesnt exist.");
    }
}
