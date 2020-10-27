package com.exalt.sprintboot.repository;

import com.exalt.sprintboot.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,Long> {
}
