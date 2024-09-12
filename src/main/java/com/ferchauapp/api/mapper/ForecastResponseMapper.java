package com.ferchauapp.api.mapper;

import java.util.stream.Collectors;

import com.ferchauapp.api.dto.ForecastResponseDTO;
import com.ferchauapp.api.dto.RainfallProbabilityResponseDTO;
import com.ferchauapp.api.dto.TemperatureResponseDTO;
import com.ferchauapp.domain.Forecast;

public class ForecastResponseMapper {
  public static ForecastResponseDTO toResponseDTO(Forecast entity) {
    if (entity == null) {
      return null;
    }
        
    ForecastResponseDTO responseDTO = new ForecastResponseDTO();
    responseDTO.setMediaTemperatura(entity.getMediaTemperatura());
    responseDTO.setUnidadTemperatura(entity.getUnidadTemperatura());
    responseDTO.setProbPrecipitacion(
            entity.getProbPrecipitacion().stream()
                .map(probPrecipitacion -> {
                    RainfallProbabilityResponseDTO rainfallDTO = new RainfallProbabilityResponseDTO();
                    rainfallDTO.setValue(probPrecipitacion.getValue());
                    rainfallDTO.setPeriodo(probPrecipitacion.getPeriodo());
                    return rainfallDTO;
                })
                .collect(Collectors.toList())
        );

    TemperatureResponseDTO temperatureDTO = new TemperatureResponseDTO();
        temperatureDTO.setMaxima(entity.getTemperatura().getMaxima());
        temperatureDTO.setMinima(entity.getTemperatura().getMinima());
        responseDTO.setTemperatura(temperatureDTO);
    return responseDTO;
  }
}

