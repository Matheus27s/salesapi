package com.salesapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesapi.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, UUID> {}