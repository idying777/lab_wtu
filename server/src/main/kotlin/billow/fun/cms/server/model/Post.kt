package billow.`fun`.cms.server.model

import billow.`fun`.cms.server.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import javax.persistence.Entity

@Entity
data class Post(
        val title: String,
        val content: String,
        val category: String
) : BaseEntity()


interface PostRepo : JpaRepository<Post, Long> {
    fun findByCategory(@Param("category") category: String): Collection<Post>
}
