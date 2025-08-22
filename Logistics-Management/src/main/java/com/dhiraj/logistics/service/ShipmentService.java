package com.dhiraj.logistics.service;

import com.dhiraj.logistics.entity.Shipment;
import com.dhiraj.logistics.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service

public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    public Shipment createShipment(Shipment shipment) {
        shipment.setId(UUID.randomUUID());
        shipment.setStatus("PENDING");
        shipment.setCreatedAt(LocalDateTime.now());
        return shipmentRepository.save(shipment);
    }
   public List<Shipment> getAllShipment(){
        return shipmentRepository.findAll();
   }
}
