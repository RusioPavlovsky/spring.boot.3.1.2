package com.rusio.pavlovsky.spring.boot312.repository;

import com.rusio.pavlovsky.spring.boot312.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
