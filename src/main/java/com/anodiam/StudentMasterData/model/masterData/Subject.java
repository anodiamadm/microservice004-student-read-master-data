package com.anodiam.StudentMasterData.model.masterData;

import com.anodiam.StudentMasterData.model.common.MessageResponse;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "mst_subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="subject_id")
	private BigInteger subjectId;

	@Column(name="subject_name")
	private String subjectName;

	@Column(name="subject_code")
	private String subjectCode;

	@Transient
	private MessageResponse messageResponse;

	public Subject(String subjectName, String subjectCode) {
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
	}

	public Subject() {
	}

	public MessageResponse getMessageResponse() {
		return messageResponse;
	}

	public void setMessageResponse(MessageResponse messageResponse) {
		this.messageResponse = messageResponse;
	}

	public void setSubjectId(BigInteger subjectId) {
		this.subjectId = subjectId;
	}

	public BigInteger getSubjectId() {
		return subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
}
