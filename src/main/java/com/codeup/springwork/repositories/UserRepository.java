package com.codeup.springwork.repositories;

import com.codeup.springwork.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
