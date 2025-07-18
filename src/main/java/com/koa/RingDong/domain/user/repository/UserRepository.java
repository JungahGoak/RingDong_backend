package com.koa.RingDong.domain.user.repository;

import com.koa.RingDong.domain.user.repository.OAuthProvider;
import com.koa.RingDong.domain.user.repository.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByOauthIdAndOauthProvider(String oauthId, OAuthProvider oauthProvider);

}