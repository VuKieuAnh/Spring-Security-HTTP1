package com.example.securityHTTP.repo;

import com.example.securityHTTP.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String name);
}
