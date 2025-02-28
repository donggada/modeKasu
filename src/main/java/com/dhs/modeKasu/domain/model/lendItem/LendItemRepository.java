package com.dhs.modeKasu.domain.model.lendItem;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendItemRepository extends JpaRepository<LendItem, Long> {
    @EntityGraph(attributePaths = {"category"})
    List<LendItem> findAll();
}
