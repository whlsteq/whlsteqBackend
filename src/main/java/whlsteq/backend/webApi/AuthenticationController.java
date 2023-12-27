package whlsteq.backend.webApi;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import whlsteq.backend.business.abstracts.AuthenticationService;
import whlsteq.backend.business.request.AuthenticationRequest;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/authenticate")
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @PostMapping()
    public ResponseEntity<Boolean> authenticate(@RequestBody AuthenticationRequest authenticationRequest){
        Boolean isAuthenticated= authenticationService.authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        return ResponseEntity.ok(isAuthenticated);
    }
}
