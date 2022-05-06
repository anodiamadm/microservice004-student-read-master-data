package com.anodiam.StudentMasterData.controller;

import com.anodiam.StudentMasterData.model.common.MessageResponse;
import com.anodiam.StudentMasterData.model.common.ResponseCode;
import com.anodiam.StudentMasterData.model.masterData.Subject;
import com.anodiam.StudentMasterData.serviceRepository.masterData.Board.BoardService;
import com.anodiam.StudentMasterData.model.masterData.Board;
import com.anodiam.StudentMasterData.model.masterData.Level;
import com.anodiam.StudentMasterData.serviceRepository.masterData.Level.LevelService;
import com.anodiam.StudentMasterData.serviceRepository.masterData.Subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/master-data")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReadMasterDataController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private LevelService levelService;

    @Autowired
    private SubjectService subjectService;

    //  @GetMapping("boards") :: List all boards - to populate dropdowns in the frontend
    @GetMapping("/boards")
    @ResponseBody
    public List<Board> getAllBoards() throws Exception {
        List<Board> returnedBoards = Collections.emptyList();
        try {
            returnedBoards = boardService.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return returnedBoards;
    }

    //  @GetMapping("levels") :: List all levels - to populate dropdowns in the frontend
    @GetMapping("/levels")
    @ResponseBody
    public List<Level> getAllLevels() throws Exception {
        List<Level> returnedLevels = Collections.emptyList();
        try {
            returnedLevels = levelService.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return returnedLevels;
    }

    //  @GetMapping("subjects") :: List all subjects - to populate dropdowns in the frontend
    @GetMapping("/subjects")
    @ResponseBody
    public List<Subject> getAllSubjects() throws Exception {
        List<Subject> returnedSubjects = Collections.emptyList();
        try {
            returnedSubjects = subjectService.findAll();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return returnedSubjects;
    }

    //  GET :: api/master-data/board/(BigInt board_id) :: show board with board_id
    @GetMapping("/board/{id}")
    @ResponseBody
    public Board getBoardById(@PathVariable("id") BigInteger boardId) throws Exception {
        Board boardReturned = new Board();
        try {
            boardReturned = boardService.findById(boardId).get();
        } catch (Exception exception) {
            exception.printStackTrace();
            boardReturned.setMessageResponse(new MessageResponse(ResponseCode.FAILURE.getID(),
                    ResponseCode.FAILURE.getMessage() + exception.getMessage()));
        }
        return boardReturned;
    }

//  GET :: api/master-data/level/(BigInt level_id) :: show level with level_id
    @GetMapping("/level/{id}")
    @ResponseBody
    public Level getLevelById(@PathVariable("id") BigInteger levelId) throws Exception {
        Level levelReturned = new Level();
        try {
            levelReturned = levelService.findById(levelId).get();
        } catch (Exception exception) {
            exception.printStackTrace();
            levelReturned.setMessageResponse(new MessageResponse(ResponseCode.FAILURE.getID(),
                    ResponseCode.FAILURE.getMessage() + exception.getMessage()));
        }
        return levelReturned;
    }

//  GET :: api/master-data/subject/(BigInt subject_id) :: show subject with subject_id
    @GetMapping("/subject/{id}")
    @ResponseBody
    public Subject getSubjectById(@PathVariable("id") BigInteger subjectId) throws Exception {
        Subject subjectReturned = new Subject();
        try {
            subjectReturned = subjectService.findById(subjectId).get();
        } catch (Exception exception) {
            exception.printStackTrace();
            subjectReturned.setMessageResponse(new MessageResponse(ResponseCode.FAILURE.getID(),
                    ResponseCode.FAILURE.getMessage() + exception.getMessage()));
        }
        return subjectReturned;
    }
}