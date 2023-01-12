package edu.ozyegin.cs.repository;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import edu.ozyegin.cs.entity.Amenity;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AmenityRepository {
	@PersistenceContext

	private EntityManager entityManager;

	public String check_role (int callerUserId){
		Query query = entityManager.createNativeQuery("SELECT userTypeName\n" +
				"FROM userType \n" +
				"JOIN users\n" +
				"ON userType.userTypeID = users.userTypeID\n" +
				"WHERE users.userID ="+callerUserId+"\n");
		List<String> resultString = query.getResultList();
		String value = resultString.get(0);
		return value;
	}

	public List<Amenity> getAllAmenity() {
		Query query = entityManager.createNativeQuery("select * from amenity");
		List<Amenity> resultList = query.getResultList();
		return resultList;
	}
	@Transactional
	@Modifying
	public boolean createAmentiy(String AmenityName){
		entityManager.createNativeQuery("INSERT INTO amenity (amenityName) VALUES ('"+AmenityName+"')").executeUpdate();
		return true;
	}
	@Transactional
	@Modifying
	public boolean modifyAmenity(String amenityName, int amenityID) {
			entityManager.createNativeQuery("UPDATE amenity SET amenityName='"+amenityName+"' WHERE amenityID="+amenityID+";").executeUpdate();
			return true;
	}
	@Transactional
	@Modifying
	public boolean deleteAmenity(int amenityId) {
			entityManager.createNativeQuery("DELETE FROM amenity WHERE amenityID=" + amenityId + ";").executeUpdate();
			return true;
	}
}
