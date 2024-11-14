package br.com.einsteinlimeira.exceptions.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class NotFoundResponseDTO {

    private int statusCode;
    private String error;
    private String message;
    private String details;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime timestamp;

    public NotFoundResponseDTO(int statusCode, String error, String message, String details) {
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    public static NotFoundResponseDTO notFoundResponseDTO = new NotFoundResponseDTO(
            404,
            "Not Found",
            "Registro não encontrado!",
            "Não foi possível localizar um registro com o ID informado!"
    );
}