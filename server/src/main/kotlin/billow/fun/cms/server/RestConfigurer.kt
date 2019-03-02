package billow.`fun`.cms.server

import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.stereotype.Component

@Component
class RestConfigurer : RepositoryRestConfigurer {
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration?) {
        config!!.corsRegistry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
    }
}
