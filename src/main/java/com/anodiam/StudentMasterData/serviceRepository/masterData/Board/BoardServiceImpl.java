package com.anodiam.StudentMasterData.serviceRepository.masterData.Board;

import com.anodiam.StudentMasterData.model.masterData.Board;

import java.util.List;

abstract class BoardServiceImpl implements BoardService {

    @Override
    public List<Board> findAll() {
        return new BoardServiceDal().findAll();
    }
}
