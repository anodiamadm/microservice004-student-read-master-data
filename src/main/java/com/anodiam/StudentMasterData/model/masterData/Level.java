package com.anodiam.StudentMasterData.model.masterData;

import com.anodiam.StudentMasterData.model.common.MessageResponse;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "mst_level")
public class Level {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="level_id")
	private BigInteger levelId;

	@Column(name="level_name")
	private String levelName;

	@Column(name="level_code")
	private String levelCode;

	@Transient
	private MessageResponse messageResponse;

	public Level(String levelName, String levelCode) {
		this.levelName = levelName;
		this.levelCode = levelCode;
	}

	public Level() {
	}

	public MessageResponse getMessageResponse() {
		return messageResponse;
	}

	public void setMessageResponse(MessageResponse messageResponse) {
		this.messageResponse = messageResponse;
	}

	public void setLevelId(BigInteger levelId) {
		this.levelId = levelId;
	}

	public BigInteger getLevelId() {
		return levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
}
