package com.example.Backend.domain.common.repositories;

import com.example.Backend.domain.common.entities.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechStackRepository extends JpaRepository<TechStack, Long> {
}
