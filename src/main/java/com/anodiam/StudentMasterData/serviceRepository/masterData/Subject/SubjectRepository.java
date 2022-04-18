package com.anodiam.StudentMasterData.serviceRepository.masterData.Subject;

import com.anodiam.StudentMasterData.model.masterData.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, BigInteger> {
}
