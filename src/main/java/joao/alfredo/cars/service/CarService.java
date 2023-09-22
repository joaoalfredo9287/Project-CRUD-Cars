package joao.alfredo.cars.service;

import joao.alfredo.cars.dto.CarRequestDTO;
import joao.alfredo.cars.dto.CarResponseDTO;
import joao.alfredo.cars.exceptions.CarNotFoundException;
import joao.alfredo.cars.model.Car;
import joao.alfredo.cars.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;



import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;

    private final ModelMapper modelMapper;

    public CarService(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    public CarResponseDTO convertCarToResponseDTO(Car car) {
        return modelMapper.map(car, CarResponseDTO.class);
    }

    public CarResponseDTO createCar(CarRequestDTO requestDTO) {
        String brand = requestDTO.getBrand();
        if (!isValidBrand(brand)) {
            throw new IllegalArgumentException("Marca não permitida");
        }

        Car car = new Car();
        car.setName(requestDTO.getName());
        car.setBrand(requestDTO.getBrand());
        car.setColor(requestDTO.getColor());
        car.setFabricationYear(requestDTO.getFabricationYear());

        Car savedCar = carRepository.save(car);

        return convertCarToResponseDTO(savedCar);

    }
    private boolean isValidBrand(String brand) {
        return "Chevrolet".equalsIgnoreCase(brand) || "Volvo".equalsIgnoreCase(brand) || "Ford".equalsIgnoreCase(brand) || "Bmw".equalsIgnoreCase(brand) ;
    }

    public List<CarResponseDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(this::convertCarToResponseDTO).collect(Collectors.toList());
    }

    public CarResponseDTO getCarsById(Long idChassi) throws CarNotFoundException {
        Car car = carRepository.findById(idChassi).orElseThrow(() -> new CarNotFoundException("n achei iagod"));
        return convertCarToResponseDTO(car);
    }

    public CarResponseDTO updateCar(CarRequestDTO requestDTO, Long idChassi) throws CarNotFoundException {
        Car car = carRepository.findById(idChassi).orElseThrow(() -> new CarNotFoundException("n achei iagod"));
        car.setName(requestDTO.getName());
        car.setBrand(requestDTO.getBrand());
        car.setColor(requestDTO.getColor());
        car.setFabricationYear(requestDTO.getFabricationYear());

        Car savedCar = carRepository.save(car);

        return convertCarToResponseDTO(savedCar);

    }

    public void deleteCar(Long idChassi) throws CarNotFoundException{
        Car car = carRepository.findById(idChassi).orElseThrow(() -> new CarNotFoundException("n achei iagod"));
        carRepository.delete(car);

    }


}







