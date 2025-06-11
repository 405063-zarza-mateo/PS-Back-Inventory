package org.utn.tup.backinventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utn.tup.backinventory.Entity.ItemEntity;
@Repository

public interface InventoryRepository extends JpaRepository<ItemEntity, Long> {
}
