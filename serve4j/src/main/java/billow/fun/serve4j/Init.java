package billow.fun.serve4j;

import billow.fun.serve4j.model.User;
import billow.fun.serve4j.repo.PostRepo;
import billow.fun.serve4j.repo.UserRepo;
import billow.fun.serve4j.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init {
    @Bean
    CommandLineRunner initStore(StorageService storageService,
                                PostRepo postRepo,
                                UserRepo userRepo) {
        return (args) -> {
            storageService.init();
            var logger = LoggerFactory.getLogger(this.getClass());
            List.of(new User("admin", "wtuadmin"), new User("root", "wtu_root"))
                    .forEach(user -> userRepo.findByUsername(user.getUsername()).ifPresentOrElse(
                            u -> logger.info(user.getUsername() + " is exist"),
                            () -> userRepo.save(user)));
        };
    }
}
