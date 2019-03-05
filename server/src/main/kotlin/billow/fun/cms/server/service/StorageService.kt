package billow.`fun`.cms.server.service

import org.springframework.core.io.Resource
import org.springframework.util.StringUtils
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.util.stream.Stream
import java.net.MalformedURLException
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service


interface StorageService {
    fun init()
    fun store(file: MultipartFile)
    fun loadAll(): Stream<Path>
    fun load(filename: String): Path
    fun loadAsResource(filename: String): Resource
    fun deleteAll()
}

@Service
class FSStorageService : StorageService {
    private val root: Path = Path.of("upload-dir")

    override fun init() {
        if (Files.notExists(root))
            try {
                Files.createDirectories(root)
            } catch (e: IOException) {
                println("failed create $root")
                e.printStackTrace()
            }
    }

    override fun store(file: MultipartFile) {
        val filename = StringUtils.cleanPath(file.originalFilename!!)
        if (file.isEmpty || filename.contains("..")) throw RuntimeException("failed store file" + file.name)
        try {
            val inputStream = file.inputStream
            Files.copy(inputStream, root.resolve(filename), StandardCopyOption.REPLACE_EXISTING)
        } catch (e: IOException) {
            throw RuntimeException("failed store file" + file.name)
        }
    }

    override fun loadAll(): Stream<Path> {
        try {
            return Files.walk(root, 1)
                    .filter { it != root }
                    .map { root.relativize(it) }
        } catch (e: IOException) {
            throw RuntimeException("Failed to read stored files", e)
        }

    }

    override fun load(filename: String): Path = root.resolve(filename)

    override fun loadAsResource(filename: String): Resource {
        try {
            val file = load(filename)
            val resource = UrlResource(file.toUri())
            return if (resource.exists() || resource.isReadable) {
                resource
            } else {
                throw RuntimeException("Could not read file: $filename")
            }
        } catch (e: MalformedURLException) {
            throw RuntimeException("Could not read file: $filename", e)
        }

    }

    override fun deleteAll() {
        try {
            Files.createDirectories(root)
        } catch (e: IOException) {
            throw RuntimeException("Could not initialize storage", e)
        }
    }
}
