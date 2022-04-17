package com.anodiam.StudentMasterData.serviceRepository.masterData.Level;

import com.anodiam.StudentMasterData.model.masterData.Level;

import java.util.List;

abstract class LevelServiceImpl implements LevelService {

    @Override
    public List<Level> findAll() {
        return new LevelServiceDal().findAll();
    }
}
