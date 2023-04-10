package com.github.joaovictorjpg.codeblack.services;

import com.github.joaovictorjpg.codeblack.model.Enum.CategoryEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public record ProductDTO(
        @NotNull @NotEmpty String title,
        @NotNull @NotEmpty String Description,
        @NotNull @URL String photo,
        @NotNull @NotEmpty Integer size,
        @NotNull @NotEmpty @DecimalMin(value = "0.0", inclusive = false) @Digits(integer = 3, fraction = 2)BigDecimal price,
        @NotNull @NotEmpty Integer preparation,
        @NotNull @NotEmpty CategoryEnum categoryEnum
        ) {
}
