package com.anodiam.StudentMasterData.serviceRepository.masterData.Board;

import com.anodiam.StudentMasterData.model.masterData.Board;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

abstract class BoardServiceImpl implements BoardService {

    @Override
    public List<Board> findAll() {
        return new BoardServiceDal().findAll();
    }

    @Override
    public Optional<Board> findById(BigInteger boardId) {
        return new BoardServiceDal().findById(boardId);
    }
}
