package com.alurachallenge.foro.hub.domain.topico;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        LocalDateTime fecha,
        Boolean status,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
    public DatosListadoTopicos(Topico topico) {
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha(),topico.getStatus(),topico.getAutor(),topico.getCurso());
    }
}
