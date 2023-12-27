package whlsteq.backend.dataAccess.abstracts;

import whlsteq.backend.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);//burda jpa kendisi bir sorgu ceviriyor ve ayni epostaya ait bir veri var mi yok mu kontrol ediyor.
    User findByEmail(String email);
}
