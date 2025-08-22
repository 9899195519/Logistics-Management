package com.dhiraj.logistics.controller;

import com.dhiraj.logistics.entity.Shipment;
import com.dhiraj.logistics.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String saveShipment(@ModelAttribute Shipment shipment) {
        shipmentService.createShipment(shipment);
        return "redirect:/shipments";
    }
}
