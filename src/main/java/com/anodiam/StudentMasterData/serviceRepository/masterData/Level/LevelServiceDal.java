package com.anodiam.StudentMasterData.serviceRepository.masterData.Level;

import com.anodiam.StudentMasterData.model.common.MessageResponse;
import com.anodiam.StudentMasterData.model.common.ResponseCode;
import com.anodiam.StudentMasterData.model.masterData.Board;
import com.anodiam.StudentMasterData.model.masterData.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
class LevelServiceDal extends LevelServiceImpl {

    @Autowired
    private LevelRepository levelRepository;

    public LevelServiceDal(){}

    @Override
    public List<Level> findAll() {
        List<Level> returnedLevels = Collections.emptyList();
        try {
            returnedLevels = levelRepository.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return returnedLevels;
    }

    @Override
    public Optional<Level> findById(BigInteger levelId) {
        Level levelReturned = new Level();
        try {
            Optional<Level> optionalLevel = levelRepository.findById(levelId);
            if(optionalLevel.isPresent()){
                levelReturned = optionalLevel.get();
                levelReturned.setMessageResponse(new
                        MessageResponse(ResponseCode.SUCCESS.getID(),
                        ResponseCode.SUCCESS.getMessage() + levelReturned.getLevelName()));
            } else {
                levelReturned.setMessageResponse(new MessageResponse(ResponseCode.LEVEL_ID_NOT_FOUND.getID(),
                        ResponseCode.LEVEL_ID_NOT_FOUND.getMessage() + levelId));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            levelReturned.setMessageResponse(new MessageResponse(ResponseCode.FAILURE.getID(),
                    ResponseCode.FAILURE.getMessage() + exception.getMessage()));
        }
        return Optional.of(levelReturned);
    }
}
