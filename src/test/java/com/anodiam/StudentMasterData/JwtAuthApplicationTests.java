package com.anodiam.StudentMasterData;

import com.anodiam.StudentMasterData.model.common.ResponseCode;
import com.anodiam.StudentMasterData.model.masterData.Board;
import com.anodiam.StudentMasterData.model.masterData.Level;
import com.anodiam.StudentMasterData.model.masterData.Subject;
import com.anodiam.StudentMasterData.serviceRepository.masterData.Board.BoardService;
import com.anodiam.StudentMasterData.serviceRepository.masterData.Level.LevelService;
import com.anodiam.StudentMasterData.serviceRepository.masterData.Subject.SubjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@SpringBootTest
class JwtAuthApplicationTests {

	@Autowired
	private BoardService boardService;

	@Autowired
	private LevelService levelService;

	@Autowired
	private SubjectService subjectService;

	//	List Boards
	@Test
	public void testPositiveListAllBoards() throws Exception
	{
		String response = "";
		try {
			List<Board> boards = boardService.findAll();
			if(boards.isEmpty()) {
				response = "EMPTY";
			} else {
				response = "NOT_EMPTY";
			}
		} catch (Exception exception) {
			response = exception.getMessage();
		}
		assertEquals("NOT_EMPTY", response);
	}

	//	List Levels
	@Test
	public void testPositiveListAllLevels() throws Exception
	{
		String response = "";
		try {
			List<Level> levels = levelService.findAll();
			if(levels.isEmpty()) {
				response = "EMPTY";
			} else {
				response = "NOT_EMPTY";
			}
		} catch (Exception exception) {
			response = exception.getMessage();
		}
		assertEquals("NOT_EMPTY", response);
	}

	//	List Subjects
	@Test
	public void testPositiveListAllSubjects() throws Exception
	{
		String response = "";
		try {
			List<Subject> subjects = subjectService.findAll();
			if(subjects.isEmpty()) {
				response = "EMPTY";
			} else {
				response = "NOT_EMPTY";
			}
		} catch (Exception exception) {
			response = exception.getMessage();
		}
		assertEquals("NOT_EMPTY", response);
	}

	//	Get Board for invalid BoardId = 2000
	@Test
	public void testNegativeGetBoardByInvalidBoardId() throws Exception
	{
		String response = "";
		try {
			Optional<Board> optBoard = boardService.findById(BigInteger.valueOf(2000));
			if(optBoard.isPresent()) {
				response = optBoard.get().getMessageResponse().getMessage();
			}
		} catch (Exception exception) {
			response = exception.getMessage();
		}
		assertEquals("No value present", response);
	}

	//	Get Board for valid BoardId = 2
	@Test
	public void testPositiveGetBoardByValidBoardId() throws Exception
	{
		String response = "";
		try {
			Optional<Board> optBoard = boardService.findById(BigInteger.valueOf(2));
			if(optBoard.isPresent()) {
				response = optBoard.get().getMessageResponse().getMessage();
			}
		} catch (Exception exception) {
			response = exception.getMessage();
		}
		assertEquals(ResponseCode.SUCCESS.getMessage(), response);
	}

	//	Get Level for invalid levelId = 2000
	@Test
	public void testNegativeGetLevelByInvalidLevelId() throws Exception
	{
		String response = "";
		try {
			Optional<Level> optLevel = levelService.findById(BigInteger.valueOf(2000));
			if(optLevel.isPresent()) {
				response = optLevel.get().getMessageResponse().getMessage();
			}
		} catch (Exception exception) {
			response = exception.getMessage();
		}
		assertEquals("No value present", response);
	}

	//	Get Level for valid LevelId = 2
	@Test
	public void testPositiveGetLevelByValidLevelId() throws Exception
	{
		String response = "";
		try {
			Optional<Level> optLevel = levelService.findById(BigInteger.valueOf(2));
			if(optLevel.isPresent()) {
				response = optLevel.get().getMessageResponse().getMessage();
			}
		} catch (Exception exception) {
			response = exception.getMessage();
		}
		assertEquals(ResponseCode.SUCCESS.getMessage(), response);
	}

	//	Get Subject for invalid SubjectId = 2000
	@Test
	public void testNegativeGetSubjectByInvalidSubjectId() throws Exception
	{
		String response = "";
		try {
			Optional<Subject> optSubject = subjectService.findById(BigInteger.valueOf(2000));
			if(optSubject.isPresent()) {
				response = optSubject.get().getMessageResponse().getMessage();
			}
		} catch (Exception exception) {
			response = exception.getMessage();
		}
		assertEquals("No value present", response);
	}

	//	Get Subject for valid SubjectId = 2
	@Test
	public void testPositiveGetSubjectByValidSubjectId() throws Exception
	{
		String response = "";
		try {
			Optional<Subject> optSubject = subjectService.findById(BigInteger.valueOf(2));
			if(optSubject.isPresent()) {
				response = optSubject.get().getMessageResponse().getMessage();
			}
		} catch (Exception exception) {
			response = exception.getMessage();
		}
		assertEquals(ResponseCode.SUCCESS.getMessage(), response);
	}
}
