package com.hotel.reservation.room;

import com.hotel.reservation.roomcategory.RoomCategory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public List<Room> getAll() {
        return repository.findAll();
    }

    public Room getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found: " + id));
    }

    public Room save(Room room) {
        return repository.save(room);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Factory method — creates the right subclass based on type string
    public Room createRoomOfType(String type, String roomNumber, int floor,
                                 String status, RoomCategory category) {
        Room room;
        switch (type.toUpperCase()) {
            case "STANDARD" -> room = new StandardRoom();
            case "DELUXE"   -> room = new DeluxeRoom();
            case "SUITE"    -> room = new SuiteRoom();
            default -> throw new IllegalArgumentException("Unknown room type: " + type);
        }
        room.setRoomNumber(roomNumber);
        room.setFloor(floor);
        room.setStatus(status);
        room.setCategory(category);
        return room;
    }
}