package billow.`fun`.cms.server.model

import billow.`fun`.cms.server.BaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class Post(
        val title: String,
        @Column(columnDefinition = "LONGTEXT")
        val content: String,
        val category: String,
        val fileList: Array<String>
) : BaseEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (title != other.title) return false
        if (content != other.content) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + content.hashCode()
        return result
    }
}


interface PostRepo : JpaRepository<Post, Long> {
    fun findByCategory(@Param("category") category: String): Collection<Post>
}
