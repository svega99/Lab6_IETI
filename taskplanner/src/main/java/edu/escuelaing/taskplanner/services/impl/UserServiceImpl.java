package edu.escuelaing.taskplanner.services.impl;

import java.util.List;

import edu.escuelaing.taskplanner.model.User;
import edu.escuelaing.taskplanner.persistance.TaskPlannerNotFoundException;
import edu.escuelaing.taskplanner.persistance.TaskPlannerPersistanceException;
import edu.escuelaing.taskplanner.persistance.UserPersistance;
import edu.escuelaing.taskplanner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;

@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
    @Qualifier("UserPersistanceImpl")
	 UserPersistance up;
	
	@Override
	public List<User> getAll() {
		
		return up.getAll();
	}

	@Override
	public User getById(String userId)  throws TaskPlannerNotFoundException{
		return up.getById(userId);
	}

	@Override
	public User create(User user) throws TaskPlannerPersistanceException{
		
		return up.create(user);
	}

	@Override
	public User update(User user) throws TaskPlannerNotFoundException{

		return up.update(user);
	}

	@Override
	public void remove(String userId) throws TaskPlannerNotFoundException {
		up.remove(userId);
		
	}

}
