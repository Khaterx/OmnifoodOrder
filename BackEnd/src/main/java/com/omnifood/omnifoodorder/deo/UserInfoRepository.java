package com.omnifood.omnifoodorder.deo;

import com.omnifood.omnifoodorder.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {
    public UserInfo findByEmail(String email);

    public boolean existsByEmail(String email);
}
