package edu.escuelaing.taskplanner.persistance;

import java.util.List;

import edu.escuelaing.taskplanner.model.User;

public interface UserPersistance {
		
	List<User> getAll();
    
    User getById(String userId) throws TaskPlannerNotFoundException;
    
    User create(User user) throws TaskPlannerPersistanceException;
    
    User update(User user) throws TaskPlannerNotFoundException;
    
    void remove(String userId) throws TaskPlannerNotFoundException;
}
