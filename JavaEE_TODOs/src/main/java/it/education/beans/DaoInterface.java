package it.education.beans;

import java.util.Collection;

public interface DaoInterface<T ,K> 
{
	
	Collection<T> retriveAll();
	//retiveone();  using unique id
	 T retrieveOne(K id);
	 int create(T t);
	 void Delete(K id);
	 void update(T t);

}