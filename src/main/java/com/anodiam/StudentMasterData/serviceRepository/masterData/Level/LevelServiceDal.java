package com.anodiam.StudentMasterData.serviceRepository.masterData.Level;

import com.anodiam.StudentMasterData.model.common.MessageResponse;
import com.anodiam.StudentMasterData.model.common.ResponseCode;
import com.anodiam.StudentMasterData.model.masterData.Board;
import com.anodiam.StudentMasterData.model.masterData.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
class LevelServiceDal extends LevelServiceImpl {

    @Autowired
    private LevelRepository levelRepository;

    public LevelServiceDal(){}

    @Override
    public List<Level> findAll() {
        try {
            List<Level> levels = levelRepository.findAll();
            if(!levels.isEmpty()) {
                return levels;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Level> findById(BigInteger levelId) {
        Optional<Level> levelById = levelRepository.findById(levelId);
        try {
            if(levelById.isPresent()){
                levelById.get().setMessageResponse(new MessageResponse(ResponseCode.SUCCESS.getID(),
                        ResponseCode.SUCCESS.getMessage()));
                return levelById;
            } else {
                levelById.get().setMessageResponse(new MessageResponse(ResponseCode.LEVEL_ID_NOT_FOUND.getID(),
                        ResponseCode.LEVEL_ID_NOT_FOUND.getMessage() + levelId));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            levelById.get().setMessageResponse(new MessageResponse(ResponseCode.FAILURE.getID(),
                    ResponseCode.FAILURE.getMessage() + exception.getMessage()));
        }
        return levelById;
    }

}
