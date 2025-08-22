package com.dhiraj.logistics.repository;

import com.dhiraj.logistics.entity.Shipment;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ShipmentRepository extends CassandraRepository<Shipment, UUID> {
}
