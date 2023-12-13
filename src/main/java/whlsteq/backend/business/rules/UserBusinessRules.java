package whlsteq.backend.business.rules;

import whlsteq.backend.core.utilities.BusinessException;
import whlsteq.backend.dataAccess.abstracts.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserBusinessRules {
    private UserRepository userRepository;

    public void checkIfUserEmailExists(String email){
        if (this.userRepository.existsByEmail(email)){
            throw new BusinessException("This e-mail already exist");
        }
    }
}
