package billow.`fun`.cms.server.m

import billow.`fun`.cms.server.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.ManyToMany

@Entity
data class Post(
        val title: String,
        val content: String,
        @ManyToMany val categories: MutableCollection<Category>
) : BaseEntity()


interface PostRepo : JpaRepository<Post, Long>
