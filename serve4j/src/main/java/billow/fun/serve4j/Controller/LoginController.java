package billow.fun.serve4j.Controller;

import billow.fun.serve4j.model.User;
import billow.fun.serve4j.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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
