package example.jdbc.dao;

import java.util.Collection;
//this ineterface provide basic template for Dao pattern
//its implementaion class desides th actual entity type 
//and the id type.
public interface DaoInterface<T ,K> 
{
	
	Collection<T> retriveAll();
	//retiveone();  using unique id
	 T retrieveOne(K id);
	
	 void create(T t);
	 void Delete(K id);

}
//customer id:int --->integer----->  CustomerDao <Customer ,integer>
