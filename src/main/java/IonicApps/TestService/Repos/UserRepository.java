package IonicApps.TestService.Repos;

import IonicApps.TestService.Entities.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository <User, ID> {
}
