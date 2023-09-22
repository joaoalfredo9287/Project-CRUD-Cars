package joao.alfredo.cars.controller;

import joao.alfredo.cars.dto.CarRequestDTO;
import joao.alfredo.cars.dto.CarResponseDTO;
import joao.alfredo.cars.exceptions.CarNotFoundException;
import joao.alfredo.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarsController {
    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarResponseDTO> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/{idChassi}")
    public CarResponseDTO getCarById(@PathVariable Long idChassi) throws CarNotFoundException {
        return carService.getCarsById(idChassi);
    }

    @PostMapping
    public ResponseEntity<String> createCar(@RequestBody CarRequestDTO requestDTO) {
        carService.createCar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Car created successfully");
    }

    @PutMapping("/{idChassi}")
    public ResponseEntity<String> updateCar(@PathVariable Long idChassi, @RequestBody CarRequestDTO requestDTO ) throws CarNotFoundException {
        carService.updateCar(requestDTO, idChassi);
        return ResponseEntity.status(HttpStatus.CREATED).body("updated bacana");
    }

    @DeleteMapping("/{idChassi}")
    public ResponseEntity<String> deleteCar(@PathVariable Long idChassi) throws CarNotFoundException {
        carService.deleteCar(idChassi);
        return ResponseEntity.status(HttpStatus.CREATED).body("foi de ralo");
    }
}
