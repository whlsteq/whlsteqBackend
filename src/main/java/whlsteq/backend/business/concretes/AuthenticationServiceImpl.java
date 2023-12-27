package whlsteq.backend.business.concretes;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import whlsteq.backend.business.abstracts.AuthenticationService;
import whlsteq.backend.dataAccess.abstracts.UserRepository;
import whlsteq.backend.entities.concretes.User;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Transactional
    public boolean authenticate(String email, String password){
        User user=userRepository.findByEmail(email);
        if (user!=null){
            return passwordEncoder.matches(password,user.getPassword()) ;
        }
        return false;
    }

}
