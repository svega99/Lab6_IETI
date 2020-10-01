package edu.escuelaing.taskplanner.services;

import java.util.List;

import edu.escuelaing.taskplanner.model.User;
import edu.escuelaing.taskplanner.persistance.TaskPlannerNotFoundException;
import edu.escuelaing.taskplanner.persistance.TaskPlannerPersistanceException;

public interface UserService {
	
	List<User> getAll();
    
    User getById(String userId) throws TaskPlannerNotFoundException;
    
    User create(User user) throws TaskPlannerPersistanceException;
    
    User update(User user) throws TaskPlannerNotFoundException;
    
    void remove(String userId) throws TaskPlannerNotFoundException;
}
