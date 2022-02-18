package com.salesapi.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesapi.dto.response.SellerResponseDTO;
import com.salesapi.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, UUID> {
	Seller findOneByName(String name);
		
	@Query(value = "SELECT a.id, a.name, (SELECT COUNT(id) FROM tb_sales WHERE a.id=seller_id AND date BETWEEN :start AND :end) AS salesAmount, (SELECT AVG(value) FROM tb_sales WHERE a.id =seller_id  AND date BETWEEN :start AND :end) AS averageDailySales from tb_sellers a", nativeQuery = true)
	List<SellerResponseDTO> findAllSeller(LocalDate start, LocalDate end);
}