package com.anodiam.StudentMasterData.serviceRepository.masterData.Board;

import com.anodiam.StudentMasterData.model.masterData.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class BoardServiceDal extends BoardServiceImpl {

    @Autowired
    private BoardRepository boardRepository;

    public BoardServiceDal(){}

    @Override
    public List<Board> findAll() {
        try {
            List<Board> boards = boardRepository.findAll();
            if(!boards.isEmpty()) {
                return boards;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
