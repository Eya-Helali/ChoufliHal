package com.example.ChoufliHal.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);


    @Transactional
    @Modifying
    @Query("UPDATE User u" + " SET u.evaluation=?1 WHERE u.userId=?2")
    int evaluateUser(int evaluation, Long userId);


    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.userRole=?1 WHERE u.userId=?2")
    void changeUserRole(UserRole userRole, Long userId);
}
