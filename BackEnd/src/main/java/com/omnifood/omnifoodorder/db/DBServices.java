package com.omnifood.omnifoodorder.db;

import com.omnifood.omnifoodorder.deo.AuthoritiesRepository;
import com.omnifood.omnifoodorder.deo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBServices implements CommandLineRunner {
    private UserInfoRepository userInfoRepository;
    private AuthoritiesRepository authoritiesRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DBServices(UserInfoRepository userInfoRepository, AuthoritiesRepository authoritiesRepository, PasswordEncoder passwordEncoder) {
        this.userInfoRepository = userInfoRepository;
        this.authoritiesRepository = authoritiesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
       /* UserInfo user1 = new UserInfo();
        user1.setEmail("Mouawiya@mail.com");
        user1.setPassword(passwordEncoder.encode("Mou123"));
        user1.setIsActive(1);
        List<Authorities> authorities = authoritiesRepository.findAll();
        user1.getAuthorities().add(authorities.get(0));
        user1.getAuthorities().add(authorities.get(1));
        userInfoRepository.save(user1);*/

    }
}
