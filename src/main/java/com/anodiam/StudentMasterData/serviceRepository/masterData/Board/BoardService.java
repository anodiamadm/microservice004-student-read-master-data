package com.anodiam.StudentMasterData.serviceRepository.masterData.Board;

import com.anodiam.StudentMasterData.model.masterData.Board;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface BoardService {
    List<Board> findAll();
    Optional<Board> findById(BigInteger boardId);
}
