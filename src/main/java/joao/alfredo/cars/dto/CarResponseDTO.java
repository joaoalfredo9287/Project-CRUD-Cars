package joao.alfredo.cars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarResponseDTO {
        private long idChassi;
        private String name;
        private String brand;
        private String color;
        private String fabricationYear;

}
