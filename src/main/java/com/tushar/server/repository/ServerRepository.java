package com.tushar.server.repository;

import com.tushar.server.models.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<Server, Long> {
    Server findByIpAddress(String ipAddress);
//    Server findByName(String name);
}
