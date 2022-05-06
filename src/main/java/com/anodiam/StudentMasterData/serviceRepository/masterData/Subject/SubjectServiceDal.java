package com.anodiam.StudentMasterData.serviceRepository.masterData.Subject;

import com.anodiam.StudentMasterData.model.common.MessageResponse;
import com.anodiam.StudentMasterData.model.common.ResponseCode;
import com.anodiam.StudentMasterData.model.masterData.Level;
import com.anodiam.StudentMasterData.model.masterData.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
class SubjectServiceDal extends SubjectServiceImpl {

    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectServiceDal(){}

    @Override
    public List<Subject> findAll() {
        List<Subject> returnedSubjects = Collections.emptyList();
        try {
            returnedSubjects = subjectRepository.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return returnedSubjects;
    }

    @Override
    public Optional<Subject> findById(BigInteger subjectId) {
        Subject subjectReturned = new Subject();
        try {
            Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
            if(optionalSubject.isPresent()){
                subjectReturned = optionalSubject.get();
                subjectReturned.setMessageResponse(new MessageResponse(ResponseCode.SUCCESS.getID(),
                        ResponseCode.SUCCESS.getMessage() + subjectReturned.getSubjectName()));
            } else {
                subjectReturned.setMessageResponse(new MessageResponse(ResponseCode.SUBJECT_ID_NOT_FOUND.getID(),
                        ResponseCode.SUBJECT_ID_NOT_FOUND.getMessage() + subjectId));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            subjectReturned.setMessageResponse(new MessageResponse(ResponseCode.FAILURE.getID(),
                    ResponseCode.FAILURE.getMessage() + exception.getMessage()));
        }
        return Optional.of(subjectReturned);
    }
}
