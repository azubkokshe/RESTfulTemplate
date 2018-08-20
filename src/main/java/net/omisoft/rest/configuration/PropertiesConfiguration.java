package net.omisoft.rest.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.net.URL;

@Component
@ConfigurationProperties(prefix = "app")
@Validated
@Data
public class PropertiesConfiguration {

    private Amazon amazon;

    private Token token;

    @Data
    public static class Amazon {

        @NotBlank
        private String accessKeyId;

        @NotBlank
        private String secretAccessKey;

        @NotBlank
        private String bucket;

        @NotNull
        private URL endpoint;

        @NotBlank
        private String region;

    }

    @Data
    public static class Token {

        @NotBlank
        private String secret;

        @Min(60)
        private long duration;

    }

}
