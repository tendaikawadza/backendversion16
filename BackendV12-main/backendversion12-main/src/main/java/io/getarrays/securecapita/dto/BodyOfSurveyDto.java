package io.getarrays.securecapita.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class BodyOfSurveyDto {
    private Long id;

    private String fullName;

    private String receiverEmail;
    private String signature;

}
