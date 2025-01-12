package com.example.demo.rank;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ranksRepository extends JpaRepository<Ranks, Long> {
    @Query("SELECT r FROM Ranks r WHERE r.nameRank = :nameRank")
    Optional<Ranks> findByRankName(@Param("nameRank") String nameRank);
}
