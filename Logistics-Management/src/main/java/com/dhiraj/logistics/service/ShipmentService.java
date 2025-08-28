package com.dhiraj.logistics.service;

import com.dhiraj.logistics.entity.Shipment;
import com.dhiraj.logistics.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.time.LocalDate;
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
    public Shipment getShipmentById(UUID id){
        return shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Shipment not found"));
    }
   public Shipment updateShipment(UUID id, Shipment shipment){
        Shipment shipmentObj=shipmentRepository.findById(id).orElseThrow(() -> new RuntimeException("shipment not found"));
        shipmentObj.setCustomerName(shipment.getCustomerName());
        shipmentObj.setSource(shipment.getSource());
        shipmentObj.setDestination(shipment.getDestination());
        shipmentObj.setStatus(shipment.getStatus());
        shipmentObj.setCreatedAt(LocalDateTime.now());
       return shipmentRepository.save(shipmentObj);
   }
   public void deleteShipment(UUID id){
        shipmentRepository.deleteById(id);
   }
}
