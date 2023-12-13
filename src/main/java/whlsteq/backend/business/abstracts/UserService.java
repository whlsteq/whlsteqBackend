package whlsteq.backend.business.abstracts;

import whlsteq.backend.business.request.CreateUserRequest;
import whlsteq.backend.business.request.UpdateUserRequest;
import whlsteq.backend.business.responses.GetAllUserResponse;
import whlsteq.backend.business.responses.GetByIdUserResponse;

import java.util.List;

public interface UserService {

    List<GetAllUserResponse>getAll();
    GetByIdUserResponse getById(int id);
    void add(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(int id);
}
