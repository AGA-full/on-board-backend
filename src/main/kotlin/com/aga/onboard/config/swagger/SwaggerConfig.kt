package com.aga.onboard.config.swagger

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.boot.info.BuildProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Configuration
class SwaggerConfiguration {
    @Bean
    fun customOpenAPI(
        buildProperties: BuildProperties?,
    ): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("OnBoard")
                    .version(if (buildProperties != null) buildProperties.version else "dev"),
            )
    }
}

@Controller
internal class SwaggerUIController {
    @RequestMapping(value = ["/"])
    fun index(): String {
        return "redirect:swagger-ui.html"
    }
}
