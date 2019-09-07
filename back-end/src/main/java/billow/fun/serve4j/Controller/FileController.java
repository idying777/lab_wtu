package billow.fun.serve4j.Controller;


import billow.fun.serve4j.model.File;
import billow.fun.serve4j.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController
@RequestMapping({"/api"})
public final class FileController {
    private final StorageService storageService;


    @Autowired
    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping({"/admin/files"})
    public final ResponseEntity upload(@RequestParam("file") MultipartFile file) {
        storageService.store(file);
        return ResponseEntity.ok("upload ok");
    }

    @GetMapping({"/files"})
    public final ResponseEntity getAllFile() {
        return ResponseEntity.ok(storageService.loadAll()
                .map(path ->
                {
                    var filename = path.getFileName().toString();
                    return new File(filename,
                            MvcUriComponentsBuilder.fromMethodName(this.getClass(), "getFile", filename)
                                    .build().toString());
                }));
    }

    @DeleteMapping({"/files/{filename}"})
    public final ResponseEntity deleteFile(@PathVariable String filename) {
        storageService.delete(filename);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping({"/files/{filename}"})
    public final ResponseEntity getFile(@PathVariable String filename) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=" + filename)
                .body(storageService.loadAsResource(filename));
    }
}
