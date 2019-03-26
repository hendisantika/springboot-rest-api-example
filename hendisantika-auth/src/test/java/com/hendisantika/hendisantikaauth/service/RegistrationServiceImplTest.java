package com.hendisantika.hendisantikaauth.service;

import com.hendisantika.hendisantikaauth.config.AuthProperties;
import com.hendisantika.hendisantikaauth.repository.UserRepository;
import org.mockito.Mock;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-rest-api-example
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-03-26
 * Time: 07:08
 */
public class RegistrationServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailService emailService;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private AuthProperties properties;
    private RegistrationService registrationService;


}