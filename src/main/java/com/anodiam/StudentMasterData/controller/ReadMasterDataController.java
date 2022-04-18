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
        try {
            return boardService.findAll();
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }

    //  @GetMapping("levels") :: List all levels - to populate dropdowns in the frontend
    @GetMapping("/levels")
    @ResponseBody
    public List<Level> getAllLevels() throws Exception {
        try {
            return levelService.findAll();
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }

    //  @GetMapping("subjects") :: List all subjects - to populate dropdowns in the frontend
    @GetMapping("/subjects")
    @ResponseBody
    public List<Subject> getAllSubjects() throws Exception {
        try {
            return subjectService.findAll();
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }

    //  GET :: api/master-data/board/(BigInt board_id) :: show board with board_id
    @GetMapping("/board/{id}")
    @ResponseBody
    public Board getBoardById(@PathVariable("id") BigInteger boardId) throws Exception {
        try {
            return boardService.findById(boardId).get();
        } catch (Exception e) {
//            e.printStackTrace();
            Board nullBoard = new Board();
            nullBoard.setMessageResponse(new MessageResponse(ResponseCode.BOARD_ID_NOT_FOUND.getID(),
                    ResponseCode.BOARD_ID_NOT_FOUND.getMessage() + boardId));
            return nullBoard;
        }
    }

//  GET :: api/master-data/level/(BigInt level_id) :: show level with level_id
    @GetMapping("/level/{id}")
    @ResponseBody
    public Level getLevelById(@PathVariable("id") BigInteger levelId) throws Exception {
        try {
            return levelService.findById(levelId).get();
        } catch (Exception e) {
//            e.printStackTrace();
            Level nullLevel = new Level();
            nullLevel.setMessageResponse(new MessageResponse(ResponseCode.LEVEL_ID_NOT_FOUND.getID(),
                    ResponseCode.LEVEL_ID_NOT_FOUND.getMessage() + levelId));
            return nullLevel;
        }
    }

//  GET :: api/master-data/subject/(BigInt subject_id) :: show subject with subject_id
    @GetMapping("/subject/{id}")
    @ResponseBody
    public Subject getSubjectById(@PathVariable("id") BigInteger subjectId) throws Exception {
        try {
            return subjectService.findById(subjectId).get();
        } catch (Exception e) {
    //            e.printStackTrace();
            Subject nullSubject = new Subject();
            nullSubject.setMessageResponse(new MessageResponse(ResponseCode.SUBJECT_ID_NOT_FOUND.getID(),
                    ResponseCode.SUBJECT_ID_NOT_FOUND.getMessage() + subjectId));
            return nullSubject;
        }
    }
}