package com.anodiam.StudentMasterData.model;

import com.anodiam.StudentMasterData.model.common.MessageResponse;
import com.anodiam.StudentMasterData.model.masterData.Board;
import com.anodiam.StudentMasterData.model.masterData.Level;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "student_profile")
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_profile_id")
    private BigInteger studentProfileId;

    @Column(name="full_name")
    private String fullName;

    @Column(name="phone_number")
    private String phoneNumber;

    private String address;

    private String latitude;

    private String longitude;

    @Column(name="guardians_name")
    private String guardiansName;

    @Column(name="guardians_email")
    private String guardiansEmail;

    @Column(name="guardians_phone_number")
    private String guardiansPhoneNumber;

    @Column(name="profile_image_link")
    private String profileImageLink;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "boardId", referencedColumnName = "board_id")
    private Board board;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "levelId", referencedColumnName = "level_id")
    private Level level;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    @Transient
    private MessageResponse messageResponse;

    @Transient
    private BigInteger boardId;

    @Transient
    private BigInteger levelId;

    @Transient
    private Integer languageId;

    public StudentProfile(){}

    public MessageResponse getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(MessageResponse messageResponse) {
        this.messageResponse = messageResponse;
    }

    public BigInteger getBoardId() {
        return boardId;
    }

    public void setBoardId(BigInteger boardId) {
        this.boardId = boardId;
    }

    public BigInteger getLevelId() {
        return levelId;
    }

    public void setLevelId(BigInteger levelId) {
        this.levelId = levelId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public BigInteger getStudentProfileId() {
        return studentProfileId;
    }

    public void setStudentProfileId(BigInteger studentProfileId) {
        this.studentProfileId = studentProfileId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfileImageLink() {
        return profileImageLink;
    }

    public void setProfileImageLink(String profileImageLink) {
        this.profileImageLink = profileImageLink;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getGuardiansName() {
        return guardiansName;
    }

    public void setGuardiansName(String guardiansName) {
        this.guardiansName = guardiansName;
    }

    public String getGuardiansEmail() {
        return guardiansEmail;
    }

    public void setGuardiansEmail(String guardiansEmail) {
        this.guardiansEmail = guardiansEmail;
    }

    public String getGuardiansPhoneNumber() {
        return guardiansPhoneNumber;
    }

    public void setGuardiansPhoneNumber(String guardiansPhoneNumber) {
        this.guardiansPhoneNumber = guardiansPhoneNumber;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}