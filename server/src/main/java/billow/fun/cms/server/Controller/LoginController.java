package billow.fun.cms.server.Controller;

import billow.fun.cms.server.model.User;
import billow.fun.cms.server.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {
    private final UserRepo userRepo;

    @Autowired
    public LoginController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping(value = "/api/admin/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User u = userRepo.findByUsername(user.getUsername());
        if (u != null) {
            if (u.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok("login success");
            } else {
                return ResponseEntity.status(226).body("password error");
            }
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("login error");
        }
    }


}
