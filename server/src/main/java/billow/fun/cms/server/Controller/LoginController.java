package billow.fun.cms.server.Controller;

import billow.fun.cms.server.model.User;
import billow.fun.cms.server.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    @Autowired
    private UserRepo userRepo;

    @RequestMapping(value = "/api/admin/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody User user) {
        User u = userRepo.findByUsername(user.getUsername());
        if (u != null) {
            if(u.getPassword().equals(user.getPassword())){
                return ResponseEntity.ok("login success");
            }
            else{
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("login error");
            }

        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("login error");
        }
    }


}
