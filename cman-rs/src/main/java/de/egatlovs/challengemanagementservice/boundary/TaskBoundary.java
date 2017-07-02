package de.egatlovs.challengemanagementservice.boundary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import de.egatlovs.challengemanagementservice.entity.Task;
import de.egatlovs.challengemanagementservice.entity.TaskDao;
import de.egatlovs.challengemanagementservice.entity.TaskDto;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TaskBoundary {

	@Inject
	private TaskDao dao;

	public List<TaskDto> getAll() {
		List<Task> tasks = dao.findAll();
		List<TaskDto> dtos = new ArrayList<TaskDto>();
		for (Task task : tasks) {
			dtos.add(task.toTaskDto());
		}
		return dtos;
	}

	public void add(TaskDto dto) {
		dto.setCreationDate(Calendar.getInstance().getTime());
		dao.create(dto.toTask());
	}

	public void update(TaskDto dto) {
		dto.setModificationDate(Calendar.getInstance().getTime());
		dao.update(dto.toTask());
	}

	public void remove(TaskDto dto) {
		dao.remove(dto.toTask());
	}

	public TaskDto getTask(long id) {
		return dao.find(id).toTaskDto();
	}

}
