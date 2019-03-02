package billow.`fun`.cms.server.m

import billow.`fun`.cms.server.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.ManyToMany

@Entity
data class Category(
        val me: String,
        @ManyToMany val posts: MutableCollection<Post>
) : BaseEntity()

interface CategoryRepo : JpaRepository<Category, Long>
