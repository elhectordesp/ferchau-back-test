package com.ferchauapp.infrastructure;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ferchauapp.infrastructure.dto.ForecastDTO;
import com.ferchauapp.infrastructure.dto.MunicipalityDTO;

@Component
public class AemetClient {
  private final RestTemplate restTemplate;
  private final String apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZWN0b3JkdXJhNzRAZ21haWwuY29tIiwianRpIjoiMGM5YWM3NTktMTE5OC00MDg5LWI0ZjEtNjNiOTM2NmNkNjcxIiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE3MjU5MTcwMDYsInVzZXJJZCI6IjBjOWFjNzU5LTExOTgtNDA4OS1iNGYxLTYzYjkzNjZjZDY3MSIsInJvbGUiOiIifQ.ytdQqGZjignu_TtE3-8O60meIEw4Jz5YEasrsT38qoY";
  private final String municipalitiesUrl = "https://opendata.aemet.es/opendata/api/maestro/municipios?api_key="
      + apiKey;
      
  
  public AemetClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }
      
  public List<MunicipalityDTO> getAllMunicipalities() {
    try {
        String response = restTemplate.getForObject(municipalitiesUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response);
        String dataUrl = root.path("datos").asText();
        
        if (dataUrl == null || dataUrl.isEmpty()) {
            throw new RuntimeException("URL de datos no encontrada en la respuesta");
        }
        
        String dataResponse = restTemplate.getForObject(dataUrl, String.class);
        MunicipalityDTO[] municipalities = mapper.readValue(dataResponse, MunicipalityDTO[].class);
        
        if (municipalities == null) {
            throw new RuntimeException("No se pudieron mapear los datos de los municipios");
        }
        
        return Arrays.asList(municipalities);
    } catch (JsonProcessingException | RuntimeException e) {
        throw new RuntimeException("Error al obtener los municipios", e);
    }
}
  
   public Optional<ForecastDTO> getForecast(String municipalityId) {
    try {
        String url = String.format("https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/%s?api_key=%s", municipalityId, apiKey);
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response);
        String dataUrl = root.path("datos").asText();
        
        if (dataUrl == null || dataUrl.isEmpty()) {
            throw new RuntimeException("URL de datos no encontrada en la respuesta");
        }
        
        String dataResponse = restTemplate.getForObject(dataUrl, String.class);
        JsonNode dataRoot = mapper.readTree(dataResponse);
        JsonNode forecastNode = dataRoot.get(0).path("prediccion").path("dia").get(0);
        
        ForecastDTO forecast = mapper.treeToValue(forecastNode, ForecastDTO.class);

        if (forecast == null) {
            throw new RuntimeException("No se pudieron mapear los datos de la predicción");
        }
        
        return Optional.of(forecast);
    } catch (Exception e) {
        throw new RuntimeException("Error al obtener la predicción", e);
    }
}
}
