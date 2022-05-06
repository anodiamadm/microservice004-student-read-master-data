package com.anodiam.StudentMasterData.serviceRepository.masterData.Board;

import com.anodiam.StudentMasterData.model.Permission;
import com.anodiam.StudentMasterData.model.common.MessageResponse;
import com.anodiam.StudentMasterData.model.common.ResponseCode;
import com.anodiam.StudentMasterData.model.masterData.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
class BoardServiceDal extends BoardServiceImpl {

    @Autowired
    private BoardRepository boardRepository;

    public BoardServiceDal(){}

    @Override
    public List<Board> findAll() {
        List<Board> returnedBoards = Collections.emptyList();
        try {
            returnedBoards = boardRepository.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return returnedBoards;
    }

    @Override
    public Optional<Board> findById(BigInteger boardId) {
        Board boardReturned = new Board();
        try {
            Optional<Board> optionalBoard = boardRepository.findById(boardId);
            if(optionalBoard.isPresent()){
                boardReturned = optionalBoard.get();
                boardReturned.setMessageResponse(new
                        MessageResponse(ResponseCode.SUCCESS.getID(),
                        ResponseCode.SUCCESS.getMessage() + boardReturned.getBoardName()));
            } else {
                boardReturned.setMessageResponse(new MessageResponse(ResponseCode.BOARD_ID_NOT_FOUND.getID(),
                        ResponseCode.BOARD_ID_NOT_FOUND.getMessage() + boardId));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            boardReturned.setMessageResponse(new MessageResponse(ResponseCode.FAILURE.getID(),
                    ResponseCode.FAILURE.getMessage() + exception.getMessage()));
        }
        return Optional.of(boardReturned);
    }
}
