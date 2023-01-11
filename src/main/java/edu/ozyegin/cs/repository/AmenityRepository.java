package edu.ozyegin.cs.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.ozyegin.cs.entity.Amenity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class AmenityRepository {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Amenity> findAll() {
		Query query = entityManager.createNativeQuery("select * from amenity");
		System.out.println(Arrays.toString(query.getResultList().toArray()));
		List<Amenity> resultList = query.getResultList();
		return resultList;
	}	

}
