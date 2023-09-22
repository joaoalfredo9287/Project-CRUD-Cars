package joao.alfredo.cars.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarRequestDTO {
        private String name;
        private String brand;
        private String color;
        @JsonProperty(namespace = "fabrication_year")
        private String fabricationYear;
    }


