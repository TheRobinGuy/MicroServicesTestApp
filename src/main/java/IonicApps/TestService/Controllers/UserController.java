package IonicApps.TestService.Controllers;

import IonicApps.TestService.Entities.User;
import IonicApps.TestService.Services.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @RequestMapping(method=GET)
    @GetMapping("/greeting")
    public HttpEntity greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new ResponseEntity(userService.getByUserName(), HttpStatus.OK);
    }
}
