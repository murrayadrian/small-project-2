package fa.training.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import fa.training.entities.Type;

public class TypeDao implements Dao<Type> {
	
	private static String GET_ALL_TYPE = "from Type";
	private List<Type> type = new ArrayList<>();
	
	public TypeDao() {
		type.add(new Type("action"));
		type.add(new Type("fantasy"));
		type.add(new Type("advanture"));
	}
	

	@Override
	public Type getById(Session session, int id) {
		return session.find(Type.class, id);
	}

	@Override
	public List<Type> getAll(Session session) {
		Query<Type> query = session.createQuery(GET_ALL_TYPE,Type.class);
		List<Type> lists = query.getResultList();
		return lists;
	}

	@Override
	public Type updateById(Session session, int id) {
		if(!session.beginTransaction().isActive()) {
			session.beginTransaction();
		}
		Type type = session.find(Type.class, id);
		type.setTypeDescription("changed");
		session.save(type);
		session.getTransaction().commit();
		return type;
	}

	@Override
	public void deleteById(Session session, int id) {
		Type type = session.find(Type.class,id);
		session.delete(type);
		session.getTransaction().commit();
	}
	public List<Type> getType() {
		return type;
	}

}
