package com.example.alist.repository;

import com.example.alist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByRole(int role);
    boolean creatUser(User user);
}
