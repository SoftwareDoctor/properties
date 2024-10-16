package it.softwaredoctor.properties.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Data
@Configuration
public class WebClientConfig {

    @Value("${sheetdb.base-url}")
    private String sheetDbBaseUrl;

    @Value("${api.token}")
    private String auth;


    @Bean
    public WebClient webClient(WebClient.Builder builder) {
//        String basicAuth = "Basic " + Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        return builder
                .baseUrl(sheetDbBaseUrl)
                .defaultHeader(HttpHeaders.AUTHORIZATION, auth)
                .build();
    }
}
