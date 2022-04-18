package com.anodiam.StudentMasterData.serviceRepository.user.user;

import com.anodiam.StudentMasterData.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {

    Optional<User> findByUsername(String username);

    User save(User user);
}
