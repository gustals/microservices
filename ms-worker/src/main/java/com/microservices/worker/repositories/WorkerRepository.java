package com.microservices.worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.worker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
