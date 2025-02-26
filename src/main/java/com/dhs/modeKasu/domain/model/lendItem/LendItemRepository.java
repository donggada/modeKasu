package com.dhs.modeKasu.domain.model.lendItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendItemRepository extends JpaRepository<LendItem, Long> {
}
