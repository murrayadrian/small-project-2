package fa.training.dao;

import java.util.List;
import org.hibernate.Session;

public interface Dao<T> {
	
	public abstract T getById(Session session,int id);
	
	public abstract List<T> getAll(Session session);
	
	public abstract T updateById(Session session,int id);
	
	public abstract void deleteById(Session session,int id);
}
