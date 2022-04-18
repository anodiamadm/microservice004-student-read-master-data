package com.anodiam.StudentMasterData.serviceRepository.masterData.Level;

import com.anodiam.StudentMasterData.model.masterData.Board;
import com.anodiam.StudentMasterData.model.masterData.Level;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface LevelService {
    List<Level> findAll();
    Optional<Level> findById(BigInteger levelId);
}
