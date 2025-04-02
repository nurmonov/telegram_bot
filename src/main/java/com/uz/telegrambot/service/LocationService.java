package com.uz.telegrambot.service;

import com.uz.telegrambot.dto.LocationDTO;
import com.uz.telegrambot.entity.Location;
import com.uz.telegrambot.mapper.LocationMapper;
import com.uz.telegrambot.repo.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
        this.locationMapper = LocationMapper.INSTANCE;
    }

    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(locationMapper::toLocationDTO)
                .collect(Collectors.toList());
    }

    public LocationDTO getLocationById(Integer id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.map(locationMapper::toLocationDTO).orElse(null);
    }

    public LocationDTO createLocation(LocationDTO locationDTO) {
        Location location = locationMapper.toLocation(locationDTO);
        location = locationRepository.save(location);
        return locationMapper.toLocationDTO(location);
    }

    public LocationDTO updateLocation(Integer id, LocationDTO locationDTO) {
        if (!locationRepository.existsById(id)) {
            return null;
        }
        Location location = locationMapper.toLocation(locationDTO);
        location.setId(id);
        location = locationRepository.save(location);
        return locationMapper.toLocationDTO(location);
    }

    public void deleteLocation(Integer id) {
        locationRepository.deleteById(id);
    }
}


