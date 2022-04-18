package com.anodiam.StudentMasterData.model.common;
public enum ResponseCode {
    SUCCESS(0, "SUCCESS: Microsvc004: Student Read Master Data: Success!"),
    FAILURE(1, "ERR: Microsvc004: Student Read Master Data: Failure with exception message: "),
    BOARD_ID_NOT_FOUND(20, "ERR: Microsvc004: Student Read Master Data: " +
            "Board Id not found!"),
    LEVEL_ID_NOT_FOUND(30, "ERR: Microsvc004: Student Read Master Data: " +
            "Level Id not found!"),
    SUBJECT_ID_NOT_FOUND(40, "ERR: Microsvc004: Student Read Master Data: " +
            "Subject Id not found!");

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