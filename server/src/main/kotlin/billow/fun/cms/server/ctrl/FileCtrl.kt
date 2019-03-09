package billow.`fun`.cms.server.ctrl

import billow.`fun`.cms.server.model.File
import billow.`fun`.cms.server.service.StorageService
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder
import java.util.stream.Stream


@RestController
@RequestMapping("/api")
class FileCtrl(
        val storageService: StorageService
) {
    @PostMapping("/admin/files")
    fun upload(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        storageService.store(file)
        return ResponseEntity.ok("upload ok")
    }

    @GetMapping("/files")
    fun getAllFile(): ResponseEntity<Stream<File>> {
        return ResponseEntity.ok(storageService.loadAll()
                .map { path ->
                    val filename = path.fileName.toString()
                    File(filename,
                            MvcUriComponentsBuilder.fromMethodName(this.javaClass, "getFile", filename)
                                    .build().toString())
                })
    }

    @GetMapping("/files/search")
    fun getFile(@RequestParam("filename") filename: String): ResponseEntity<Resource> {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=$filename")
                .body(storageService.loadAsResource(filename))
    }
}


