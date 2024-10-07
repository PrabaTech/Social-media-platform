package com.socialmedia.Social_Media_App.repository;

import com.socialmedia.Social_Media_App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
