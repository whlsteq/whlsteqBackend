package whlsteq.backend.business.abstracts;

public interface AuthenticationService {
    boolean authenticate(String email, String password);
}
