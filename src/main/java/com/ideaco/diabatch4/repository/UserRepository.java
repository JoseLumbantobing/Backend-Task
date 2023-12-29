package com.ideaco.diabatch4.repository;

import com.ideaco.diabatch4.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    @Query(value = "SELECT * FROM tab_jose", nativeQuery = true)
    List<UserModel> findAllUsers();

    @Query(value = "SELECT j FROM UserModel j WHERE j.userId = :userId")
    Optional<UserModel> findByJPQLUser(int userId);

    Optional<UserModel> findByUserName(String userName);

    Optional<UserModel> findByUserEmail(String userEmail);

    Optional<UserModel> findByUserEmailAndUserPassword(String userEmail, String userPassword);
}