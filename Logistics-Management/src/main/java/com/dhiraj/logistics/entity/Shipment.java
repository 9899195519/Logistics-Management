package com.dhiraj.logistics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("shipments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {
    @PrimaryKey
    private UUID id;
    private String customerName;
    private String source;
    private String destination;
    private String status; // PENDING, IN_TRANSIT, DELIVERED
    private LocalDateTime createdAt;
}
