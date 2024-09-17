package com.ferchauapp.application;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ferchauapp.api.dto.ForecastResponseDTO;
import com.ferchauapp.api.dto.RainfallProbabilityResponseDTO;
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
            
            List<RainfallProbabilityResponseDTO> probPrecipitacionDTO = forecastResponse.getProbPrecipitacion().stream()
                .filter(prob -> 
                    "00-06".equals(prob.getPeriodo()) ||
                    "06-12".equals(prob.getPeriodo()) ||
                    "12-18".equals(prob.getPeriodo()) ||
                    "18-24".equals(prob.getPeriodo()))
                .map( prob -> { 
                 RainfallProbabilityResponseDTO dto = new RainfallProbabilityResponseDTO();
                 dto.setValue(prob.getValue());
                dto.setPeriodo(prob.getPeriodo());
                return dto;
                })
                .collect(Collectors.toList());
            
            ForecastResponseDTO responseDTO = ForecastResponseMapper.toResponseDTO(forecastResponse);
            responseDTO.setProbPrecipitacion(probPrecipitacionDTO);
            return responseDTO;
        });
    }
}
