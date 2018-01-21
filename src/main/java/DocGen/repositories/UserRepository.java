package DocGen.repositories;

import DocGen.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alloyer on 11.01.2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);
}
