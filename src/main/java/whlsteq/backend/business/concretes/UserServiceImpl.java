package whlsteq.backend.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import whlsteq.backend.business.abstracts.UserService;
import whlsteq.backend.business.request.CreateUserRequest;
import whlsteq.backend.business.request.UpdateUserRequest;
import whlsteq.backend.business.responses.GetAllUserResponse;
import whlsteq.backend.business.responses.GetByIdUserResponse;
import whlsteq.backend.business.rules.UserBusinessRules;
import whlsteq.backend.core.mappers.ModelMapperService;
import whlsteq.backend.dataAccess.abstracts.UserRepository;
import whlsteq.backend.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    private UserBusinessRules userBusinessRules;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse>userResponses= users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetAllUserResponse.class)).collect(Collectors.toList());
        return userResponses;
    }

    @Override
    public GetByIdUserResponse getById(int id) {
        User user =this.userRepository.findById(id).orElseThrow();
        GetByIdUserResponse response=this.modelMapperService.forResponse().map(user, GetByIdUserResponse.class);
        return response;
    }

    @Override
    public void add(CreateUserRequest createUserRequest) {
        this.userBusinessRules.checkIfUserEmailExists(createUserRequest.getEmail());
        User user =this.modelMapperService.forRequest().map(createUserRequest, User.class);
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        this.userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User user =this.modelMapperService.forRequest().map(updateUserRequest, User.class);
        this.userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        this.userRepository.deleteById(id);
    }

}
