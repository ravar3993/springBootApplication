package com.ravar.sikka.repository;

import com.ravar.sikka.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("SELECT u from User u WHERE u.userName = :userName AND u.password = :password")
    User getUserByLogin(@Param(value = "userName") String userName, @Param(value = "password") String password);

    @Query("SELECT count(u) from User u WHERE u.userName = :userName")
    int checkUserByUserName(@Param(value = "userName") String userName);
}
