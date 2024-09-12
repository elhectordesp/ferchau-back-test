package com.ferchauapp.application;

import java.util.Optional;

import com.ferchauapp.api.dto.ForecastResponseDTO;

public interface ForecastService {
  Optional<ForecastResponseDTO> getForecast(String municipalityId, String measurementUnit);
}
