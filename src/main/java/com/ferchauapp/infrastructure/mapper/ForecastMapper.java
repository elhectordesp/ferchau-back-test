package com.ferchauapp.infrastructure.mapper;

import java.util.stream.Collectors;

import com.ferchauapp.domain.Forecast;
import com.ferchauapp.domain.ProbPrecipitacion;
import com.ferchauapp.domain.Temperatura;
import com.ferchauapp.infrastructure.dto.ForecastDTO;

public class ForecastMapper {

    public static Forecast toEntity(ForecastDTO dto) {
        if (dto == null) {
            return null;
        }

        Forecast response = new Forecast();
        response.setMediaTemperatura(dto.getMediaTemperatura());
        response.setUnidadTemperatura(dto.getUnidadTemperatura());
        response.setProbPrecipitacion(
            dto.getProbPrecipitacion().stream()
                .map(probPrecipitacion -> {
                    ProbPrecipitacion probPrecipitaciones = new ProbPrecipitacion();
                    probPrecipitaciones.setValue(probPrecipitacion.getValue());
                    probPrecipitaciones.setPeriodo(probPrecipitacion.getPeriodo());
                    return probPrecipitaciones;
                })
                .collect(Collectors.toList())
        );

    Temperatura temperatura = new Temperatura();
        temperatura.setMaxima(dto.getTemperatura().getMaxima());
        temperatura.setMinima(dto.getTemperatura().getMinima());
        response.setTemperatura(temperatura);
    return response;
    }
}
