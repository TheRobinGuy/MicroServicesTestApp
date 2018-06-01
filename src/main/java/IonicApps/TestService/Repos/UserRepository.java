package IonicApps.TestService.Repos;

import IonicApps.TestService.Entities.User;
//import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User getByUserName();
}
