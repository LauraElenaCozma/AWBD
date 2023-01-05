package com.awbd.lab5.repositories;

import com.awbd.lab5.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
