package com.omnifood.omnifoodorder.services;

import com.omnifood.omnifoodorder.deo.UserInfoRepository;
import com.omnifood.omnifoodorder.dto.UserConfiguration;
import com.omnifood.omnifoodorder.model.UserInfo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersInfoServices implements UserDetailsService {

    private UserInfoRepository userInfoRepository;

    @Autowired
    public UsersInfoServices(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo user = userInfoRepository.findByEmail(email);
        System.out.println(user.getEmail() + "         " + user.getPassword());
        UserConfiguration userConfiguration = new UserConfiguration(user);
        return userConfiguration;
    }
}
