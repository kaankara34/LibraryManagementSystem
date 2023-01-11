package edu.ozyegin.cs.repository;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.ozyegin.cs.entity.Amenity;

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
