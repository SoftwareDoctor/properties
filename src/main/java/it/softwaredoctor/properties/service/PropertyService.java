/**
 * @Author: SoftwareDoctor andrea_italiano87@yahoo.com
 * @Date: 2024-10-15 08:26:24
 * @LastEditors: SoftwareDoctor andrea_italiano87@yahoo.com
 * @LastEditTime: 2024-10-16 09:55:09
 * @FilePath: src/main/java/it/softwaredoctor/properties/service/PropertyService.java
 * @Description: 这是默认设置, 可以在设置》工具》File Description中进行配置
 */
package it.softwaredoctor.properties.service;

import it.softwaredoctor.properties.config.WebClientConfig;
import it.softwaredoctor.properties.model.Property;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PropertyService {

    private final WebClient webClient;
    private final WebClientConfig config;
    
    public List<Property> getAllProperties() {
        return webClient.get()
                .uri(config.getSheetDbBaseUrl())
                .retrieve()
                .bodyToFlux(Property.class)
                .collectList()
                .block();
    }

    public void addProperty(Property property) {
        if (property == null) {
            throw new IllegalArgumentException("Property cannot be null");
        }
        Mono<Void> response = webClient.post()
                .uri(config.getSheetDbBaseUrl())
                .bodyValue(property)
                .retrieve()
                .bodyToMono(Void.class);
        response.subscribe(
                null,
                error -> {
                    System.err.println("Failed to add property: " + error.getMessage());
                },
                () -> {
                    System.out.println("Property added: " + property);
                }
        );
    }

    public void updateProperty(String id, String status) {
        webClient.patch()
                .uri(config.getSheetDbBaseUrl() + "/id/" + id)
                .header("Content-Type", "application/json") 
                .bodyValue(Collections.singletonMap("status", status)) 
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
    
    public void deleteProperty(String id) {
        webClient.delete()
                .uri(config.getSheetDbBaseUrl() + "/id/" + id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}

