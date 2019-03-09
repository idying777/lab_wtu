package billow.`fun`.cms.server.model

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

data class User(val username: String,
                val password: String)

interface UserRepo : JpaRepository<User, Long> {
    fun findByUsername(@Param("username") username: String): User?
}
