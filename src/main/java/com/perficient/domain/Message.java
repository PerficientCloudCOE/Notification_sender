package com.perficient.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String message;
	private String groupIdList;
	private String status;

	@Transient // ensure the field is not persisted in DB, as we have this field
				// in User table already
	private String mailId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getGroupIdList() {
		return groupIdList;
	}

	public void setGroupIdList(String groupList) {
		this.groupIdList = groupList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

}
