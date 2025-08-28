package com.dhiraj.logistics.controller;

import com.dhiraj.logistics.entity.Shipment;
import com.dhiraj.logistics.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/shipments")
public class ShipmentController {
    @Autowired
    private ShipmentService shipmentService;

    @GetMapping
    public String listShipments(Model model) {
        model.addAttribute("shipments", shipmentService.getAllShipment());
        return "shipments/list";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("shipment", new Shipment());
        return "shipments/form";
    }

    @PostMapping
    public String saveOrUpdateShipment(@ModelAttribute Shipment shipment) {
        if(shipment.getId() !=null){
        shipmentService.updateShipment(shipment.getId(),shipment);
        }
        else {
            shipmentService.createShipment(shipment);
        }
        return "redirect:/shipments";
    }
    @GetMapping("/edit/{id}")
    public String updateShipment(@PathVariable UUID id,Model model){
        model.addAttribute("shipment",shipmentService.getShipmentById(id));
        return "shipments/update";
    }
    @GetMapping("/delete/{id}")
        public String deleteShipment(@PathVariable UUID id){
        shipmentService.deleteShipment(id);
        return "redirect:/shipments";

    }
}
