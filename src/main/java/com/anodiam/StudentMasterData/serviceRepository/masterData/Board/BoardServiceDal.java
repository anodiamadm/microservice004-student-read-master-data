package com.anodiam.StudentMasterData.serviceRepository.masterData.Board;

import com.anodiam.StudentMasterData.model.common.MessageResponse;
import com.anodiam.StudentMasterData.model.common.ResponseCode;
import com.anodiam.StudentMasterData.model.masterData.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Board> findById(BigInteger boardId) {
        Optional<Board> boardById = boardRepository.findById(boardId);
        try {
            if(boardById.isPresent()){
                boardById.get().setMessageResponse(new MessageResponse(ResponseCode.SUCCESS.getID(),
                        ResponseCode.SUCCESS.getMessage()));
                return boardById;
            } else {
                boardById.get().setMessageResponse(new MessageResponse(ResponseCode.BOARD_ID_NOT_FOUND.getID(),
                        ResponseCode.BOARD_ID_NOT_FOUND.getMessage() + boardId));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            boardById.get().setMessageResponse(new MessageResponse(ResponseCode.FAILURE.getID(),
                    ResponseCode.FAILURE.getMessage() + exception.getMessage()));
        }
        return boardById;
    }
}
