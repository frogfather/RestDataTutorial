package com.mistymorning.housekeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mistymorning.housekeeper.classes.DeviceMetadata;

import java.util.List;

public interface DeviceMetadataRepository extends JpaRepository<DeviceMetadata, Long> {

    List<DeviceMetadata> findByUserId(Long userId);
}