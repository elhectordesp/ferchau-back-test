package com.ferchauapp.application;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ferchauapp.api.dto.ForecastResponseDTO;
import com.ferchauapp.api.mapper.ForecastResponseMapper;
import com.ferchauapp.domain.Forecast;
import com.ferchauapp.infrastructure.AemetClient;
import com.ferchauapp.infrastructure.mapper.ForecastMapper;

@Service
public class ForecastServiceImpl implements ForecastService {
  private final AemetClient aemetClient;

  public ForecastServiceImpl(AemetClient aemetClient) {
    this.aemetClient = aemetClient;
  }

  @Override
  public Optional<ForecastResponseDTO> getForecast(String municipalityId, String measurementUnit) {
    return aemetClient.getForecast(municipalityId).map(forecast -> {
      Forecast forecastResponse = ForecastMapper.toEntity(forecast);  
       double temperaturaMedia = (forecastResponse.getTemperatura().getMaxima() + forecastResponse.getTemperatura().getMinima()) / 2;
      if ("G_FAH".equals(measurementUnit)) {
        temperaturaMedia = (temperaturaMedia * 9/5) + 32;
      }
      forecastResponse.setMediaTemperatura(temperaturaMedia);
      forecastResponse.setUnidadTemperatura(measurementUnit);
      return ForecastResponseMapper.toResponseDTO(forecastResponse);
    });  
  }
}
