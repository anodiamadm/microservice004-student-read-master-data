package com.anodiam.StudentMasterData;

import com.anodiam.StudentMasterData.model.Permission;
import com.anodiam.StudentMasterData.model.Role;
import com.anodiam.StudentMasterData.model.User;
import com.anodiam.StudentMasterData.model.common.ResponseCode;
import com.anodiam.StudentMasterData.model.masterData.Board;
import com.anodiam.StudentMasterData.model.masterData.Level;
import com.anodiam.StudentMasterData.model.masterData.Subject;
import com.anodiam.StudentMasterData.serviceRepository.masterData.Board.BoardService;
import com.anodiam.StudentMasterData.serviceRepository.masterData.Level.LevelService;
import com.anodiam.StudentMasterData.serviceRepository.masterData.Subject.SubjectService;
import com.anodiam.StudentMasterData.serviceRepository.user.Permission.PermissionService;
import com.anodiam.StudentMasterData.serviceRepository.user.Role.RoleService;
import com.anodiam.StudentMasterData.serviceRepository.user.user.UserService;
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
	private UserService userService;

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private BoardService boardService;

	@Autowired
	private LevelService levelService;

	@Autowired
	private SubjectService subjectService;

	//	Role should not be fetched against invalid Role Name
	@Test
	public void testNegativeFindRoleByInvalidRoleName() throws Exception
	{
		String roleName="INVALID_ROLE";
		Role role = roleService.findByRoleName(roleName).get();
		assertEquals(ResponseCode.ROLE_NAME_INVALID.getMessage() + roleName,
				role.getMessageResponse().getMessage());
	}

	//	Correct Role should be fetched against valid Role Name
	@Test
	public void testPositiveFindRoleByValidRoleName() throws Exception
	{
		String roleName="USER";
		Role role = roleService.findByRoleName(roleName).get();
		assertEquals(ResponseCode.ROLE_NAME_EXISTS.getMessage() + role.getRoleName(),
				role.getMessageResponse().getMessage());
	}

	//	Permission should not be fetched against invalid Permission Name
	@Test
	public void testNegativeFindPermissionByInvalidPermissionName() throws Exception
	{
		String permissionName="INVALID_ACCESS";
		Permission permission = permissionService.findByPermissionName(permissionName).get();
		assertEquals(ResponseCode.PERMISSION_NAME_INVALID.getMessage() + permissionName,
				permission.getMessageResponse().getMessage());
	}

	//	Correct Permission should be fetched against valid Permission Name
	@Test
	public void testPositiveFindPermissionByValidPermissionName() throws Exception
	{
		String permissionName="STUDENT_ACCESS";
		Permission permission = permissionService.findByPermissionName(permissionName).get();
		assertEquals(ResponseCode.PERMISSION_NAME_EXISTS.getMessage()
				+ permission.getPermissionName(), permission.getMessageResponse().getMessage());
	}

	//	User should NOT be fetched against invalid Email
	@Test
	public void testNegativeFindUserByWrongEmail() throws Exception
	{
		String email="invalidemail@gmail.com";
		User foundUser = userService.findByUsername(email).get();
		assertEquals(ResponseCode.USER_NOT_REGISTERED.getMessage() + email,
				foundUser.getMessageResponse().getMessage());
	}

	//	Correct User should be fetched against valid Email
	@Test
	public void testPositiveFindUserByCorrectEmail() throws Exception
	{
		String email="pinaki.sen@gmail.com";
		User foundUser = userService.findByUsername(email).get();
		assertEquals(ResponseCode.USER_EXISTS.getMessage() + foundUser.getUsername(),
				foundUser.getMessageResponse().getMessage());
	}

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
	public void testNegativeGetBoardByInvalidBoardId() throws Exception {
		String response = "";
		try {
			Optional<Board> optBoard = boardService.findById(BigInteger.valueOf(2000));
			if (optBoard.isPresent()) {
				response = optBoard.get().getMessageResponse().getMessage();
			}
		} catch (Exception exception) {
			response = exception.getMessage();
		}
		assertEquals(ResponseCode.BOARD_ID_NOT_FOUND.getMessage()
				+ (BigInteger.valueOf(2000)).toString(), response);
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
		assertEquals(ResponseCode.SUCCESS.getMessage()
				+ boardService.findById(BigInteger.valueOf(2)).get().getBoardName(), response);
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
		assertEquals(ResponseCode.LEVEL_ID_NOT_FOUND.getMessage()
				+ (BigInteger.valueOf(2000)).toString(), response);
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
		assertEquals(ResponseCode.SUCCESS.getMessage()
				+ levelService.findById(BigInteger.valueOf(2)).get().getLevelName(), response);
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
		assertEquals(ResponseCode.SUBJECT_ID_NOT_FOUND.getMessage()
				+ (BigInteger.valueOf(2000)).toString(), response);
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
		assertEquals(ResponseCode.SUCCESS.getMessage()
				+ subjectService.findById(BigInteger.valueOf(2)).get().getSubjectName(), response);
	}
}
