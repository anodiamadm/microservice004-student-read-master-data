package com.anodiam.StudentMasterData.serviceRepository.masterData.Subject;

import com.anodiam.StudentMasterData.model.masterData.Subject;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> findAll();
    Optional<Subject> findById(BigInteger subjectId);
}
