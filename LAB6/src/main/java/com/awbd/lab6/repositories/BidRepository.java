package com.awbd.lab6.repositories;

import com.awbd.lab6.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
