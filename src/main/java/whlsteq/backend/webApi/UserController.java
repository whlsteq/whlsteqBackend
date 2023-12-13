package whlsteq.backend.webApi;

import jakarta.validation.Valid;
import whlsteq.backend.business.abstracts.UserService;
import whlsteq.backend.business.request.CreateUserRequest;
import whlsteq.backend.business.responses.GetAllUserResponse;
import whlsteq.backend.business.request.UpdateUserRequest;
import whlsteq.backend.business.responses.GetByIdUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;


    @GetMapping("/{id}")
    public GetByIdUserResponse getById(@PathVariable int id){
        return userService.getById(id);
    }
    @GetMapping()
    public List<GetAllUserResponse>getAll(){return userService.getAll();}

//    @CrossOrigin //bu ozellik farkli portlardan yani frontend localhost:5453 te calisiyorsa ve backend localhost:8080 de calisiyorsa ikisi arasinda baglanti olmasina portlar arasinda izin veriyor.
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateUserRequest createUserRequest){
        this.userService.add(createUserRequest);
    }
    @PutMapping()
    public void update(@RequestBody() UpdateUserRequest updateUserRequest){
        this.userService.update(updateUserRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){this.userService.delete(id);}
}
