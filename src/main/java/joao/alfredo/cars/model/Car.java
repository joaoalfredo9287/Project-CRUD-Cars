package joao.alfredo.cars.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chassi")
    private long idChassi;
    @NotBlank(message = "nem da")
    @Column(name = "name")
    private String name;
    @NotBlank(message = "nem da")
    @Column(name = "brand")
    private String brand;
    @NotBlank(message = "nem da")
    @Column(name = "color")
    private String color;
    @NotBlank(message = "nem da")
    @Column(name = "fabrication_year")
    private String fabricationYear;
}
