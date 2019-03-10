package billow.fun.serve4j;

import billow.fun.serve4j.model.User;
import billow.fun.serve4j.repo.PostRepo;
import billow.fun.serve4j.repo.UserRepo;
import billow.fun.serve4j.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Init {
    @Bean
    CommandLineRunner initStore(StorageService storageService,
                                PostRepo postRepo,
                                UserRepo userRepo) {
        return (args) -> {
            storageService.init();
            userRepo.save(new User("admin", "wtuadmin"));
            userRepo.save(new User("root", "wtu_root"));
        };
    }
}
