package billow.fun.serve4j.repo;

import billow.fun.serve4j.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
