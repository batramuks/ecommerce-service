package com.batra.dao;

import com.batra.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetail,Long> {
    /***
     *
     * @param firstName
     * @return
     */
    UserDetail findByUsername(String firstName);
}