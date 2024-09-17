package com.ferchauapp.infrastructure;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ferchauapp.application.exception.AemetClientException;
import com.ferchauapp.infrastructure.dto.ForecastDTO;
import com.ferchauapp.infrastructure.dto.MunicipalityDTO;

@Component
public class AemetClient {

    private final RestTemplate restTemplate;
    
    @Value("${aemet.api.key}")
    private String apiKey;
    
    @Value("${aemet.municipalities.url}")
    private String municipalitiesUrl;
    
    @Value("${aemet.forecast.url}")
    private String forecastUrl;

    public AemetClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<MunicipalityDTO> getAllMunicipalities() {
        try {
            String response = restTemplate.getForObject(municipalitiesUrl + "?api_key=" + apiKey, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            String dataUrl = root.path("datos").asText();

            if (dataUrl == null || dataUrl.isEmpty()) {
                throw new AemetClientException("URL de datos no encontrada en la respuesta");
            }

            String dataResponse = restTemplate.getForObject(dataUrl, String.class);
            MunicipalityDTO[] municipalities = mapper.readValue(dataResponse, MunicipalityDTO[].class);

            if (municipalities == null) {
                throw new AemetClientException("No se pudieron mapear los datos de los municipios");
            }

            return Arrays.asList(municipalities);
        } catch (JsonProcessingException e) {
            throw new AemetClientException("Error de procesamiento de JSON", e);
        }
    }

    public Optional<ForecastDTO> getForecast(String municipalityId) {
        try {
          String url = String.format(forecastUrl + "%s?api_key=%s", municipalityId, apiKey);
            String response = restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            String dataUrl = root.path("datos").asText();

            if (dataUrl == null || dataUrl.isEmpty()) {
                throw new AemetClientException("URL de datos no encontrada en la respuesta");
            }

            String dataResponse = restTemplate.getForObject(dataUrl, String.class);
            JsonNode dataRoot = mapper.readTree(dataResponse);
            JsonNode forecastNode = dataRoot.get(0).path("prediccion").path("dia").get(0);

            ForecastDTO forecast = mapper.treeToValue(forecastNode, ForecastDTO.class);

            if (forecast == null) {
                throw new AemetClientException("No se pudieron mapear los datos de la predicción");
            }

            return Optional.of(forecast);
        } catch (Exception e) {
            throw new AemetClientException("Error al obtener la predicción", e);
        }
    }
}
