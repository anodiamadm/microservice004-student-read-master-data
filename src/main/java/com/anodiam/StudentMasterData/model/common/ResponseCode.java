package com.anodiam.StudentMasterData.model.common;
public enum ResponseCode {
    SUCCESS(0, "SUCCESS: Microsvc004: Student Read Master Data: Success!"),
    FAILURE(1, "ERR: Microsvc004: Student Read Master Data: Failure with exception message: "),
    USER_EXISTS(3, "Microsvc002: Student Login: Username / Email exists: "),
    USER_NOT_REGISTERED(4, "ERR: Microsvc002: Student Login: Username/Email NOT registered: "),
    BOARD_ID_NOT_FOUND(5, "ERR: Microsvc004: Student Read Master Data: " +
            "Board Id not found!"),
    LEVEL_ID_NOT_FOUND(6, "ERR: Microsvc004: Student Read Master Data: " +
            "Level Id not found!"),
    SUBJECT_ID_NOT_FOUND(7, "ERR: Microsvc004: Student Read Master Data: " +
            "Subject Id not found!"),
    ROLE_NAME_EXISTS(100, "Microsvc004: Student Read Master Data: Role name exists: "),
    ROLE_NAME_INVALID(101, "ERR: Microsvc004: Student Read Master Data: Role name INVALID: "),
    PERMISSION_NAME_EXISTS(200, "Microsvc004: Student Read Master Data: Permission name" +
            " exists: "),
    PERMISSION_NAME_INVALID(201, "ERR: Microsvc004: Student Read Master Data: Permission " +
            "name INVALID: ");

    private Integer id;
    private String message;

    ResponseCode(Integer id, String message){
        this.id = id;
        this.message=message;
    }

    public Integer getID(){
        return id;
    }
    public String getMessage() {return message;}
}