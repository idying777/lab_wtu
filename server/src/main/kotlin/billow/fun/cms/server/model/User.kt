package billow.`fun`.cms.server.model

import billow.`fun`.cms.server.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import javax.persistence.Entity

@Entity
data class User(val username: String,
                val password: String)
    : BaseEntity()

interface UserRepo : JpaRepository<User, Long> {
    fun findByUsername(@Param("username") username: String): User?
}
