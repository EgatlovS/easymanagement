package de.egatlovs.challengemanagementservice.entity;

import java.util.Date;

public class TaskDto {

	private long id;
	private String name;
	private String description;
	private Date creationDate;
	private Date modificationDate;
	private String status;

	public TaskDto() {
	}

	public TaskDto(long id, String name, String description, Date creationDate, Date modificationDate, String status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Task toTask() {
		return new Task(id, name, description, creationDate, modificationDate, status);
	}

}
