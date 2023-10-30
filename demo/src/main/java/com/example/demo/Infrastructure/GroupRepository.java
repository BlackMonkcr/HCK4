package com.example.demo.Infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Domain.Groups;

public interface GroupRepository extends JpaRepository<Groups, Long> {}
