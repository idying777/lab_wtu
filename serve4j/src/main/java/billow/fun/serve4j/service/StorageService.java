package billow.fun.serve4j.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@Service
public class StorageService implements IStorageService {

    private Path root = Path.of("upload-dir");

    @Override
    public void init() {
        if (Files.notExists(root))
            try {
                Files.createDirectories(root);
            } catch (IOException e) {
                System.out.println("failed create $root");
                e.printStackTrace();
            }
    }

    @Override
    public void store(MultipartFile file) {

    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(root, 1)
                    .filter(f -> f != root)
                    .map(f -> root.relativize(f));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read stored files", e);
        }
    }

    @Override
    public Path load(String filename) {
        return root.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            var file = load(filename);
            var resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: $filename", e);
        }
    }

    @Override
    public void delete(String filename) {
        var path = root.resolve(filename);
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("delete failed. $filename is not exist");
        }
    }

    @Override
    public void deleteAll() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage", e);
        }
    }
}
