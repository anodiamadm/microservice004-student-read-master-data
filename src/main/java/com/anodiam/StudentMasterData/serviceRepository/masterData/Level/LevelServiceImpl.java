package com.anodiam.StudentMasterData.serviceRepository.masterData.Level;

import com.anodiam.StudentMasterData.model.masterData.Level;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

abstract class LevelServiceImpl implements LevelService {

    @Override
    public List<Level> findAll() {
        return new LevelServiceDal().findAll();
    }

    @Override
    public Optional<Level> findById(BigInteger levelId) {
        return new LevelServiceDal().findById(levelId);
    }
}
