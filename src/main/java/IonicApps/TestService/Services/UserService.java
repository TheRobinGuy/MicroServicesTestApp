package IonicApps.TestService.Services;

import IonicApps.TestService.Entities.User;
import IonicApps.TestService.Repos.UserRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserService {
    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getByUserName(){
        return userRepository.getByUserName();
    }
}
