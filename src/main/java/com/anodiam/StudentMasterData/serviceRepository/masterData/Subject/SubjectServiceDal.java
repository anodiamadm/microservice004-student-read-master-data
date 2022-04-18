package com.anodiam.StudentMasterData.serviceRepository.masterData.Subject;

import com.anodiam.StudentMasterData.model.common.MessageResponse;
import com.anodiam.StudentMasterData.model.common.ResponseCode;
import com.anodiam.StudentMasterData.model.masterData.Level;
import com.anodiam.StudentMasterData.model.masterData.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
class SubjectServiceDal extends SubjectServiceImpl {

    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectServiceDal(){}

    @Override
    public List<Subject> findAll() {
        try {
            List<Subject> subjects = subjectRepository.findAll();
            if(!subjects.isEmpty()) {
                return subjects;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Subject> findById(BigInteger subjectId) {
        Optional<Subject> subjectById = subjectRepository.findById(subjectId);
        try {
            if(subjectById.isPresent()){
                subjectById.get().setMessageResponse(new MessageResponse(ResponseCode.SUCCESS.getID(),
                        ResponseCode.SUCCESS.getMessage()));
                return subjectById;
            } else {
                subjectById.get().setMessageResponse(new MessageResponse(ResponseCode.SUBJECT_ID_NOT_FOUND.getID(),
                        ResponseCode.SUBJECT_ID_NOT_FOUND.getMessage() + subjectId));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            subjectById.get().setMessageResponse(new MessageResponse(ResponseCode.FAILURE.getID(),
                    ResponseCode.FAILURE.getMessage() + exception.getMessage()));
        }
        return subjectById;
    }

}
