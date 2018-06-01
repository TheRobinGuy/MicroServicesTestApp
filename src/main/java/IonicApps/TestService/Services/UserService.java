package IonicApps.TestService.Services;

import IonicApps.TestService.Repos.UserRepository;

import javax.inject.Inject;

public class UserService {
    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
