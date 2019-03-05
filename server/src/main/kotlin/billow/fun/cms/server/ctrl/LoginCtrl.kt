package billow.`fun`.cms.server.ctrl

import billow.`fun`.cms.server.model.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/admin")
class LoginCtrl {
    @PostMapping("/login")
    fun login(@RequestBody user: User): ResponseEntity<String> {
        return if (user.username == "admin" && user.password == "admin") ResponseEntity.ok("login success")
        else ResponseEntity.status(HttpStatus.FORBIDDEN).body("login error")
    }
}
