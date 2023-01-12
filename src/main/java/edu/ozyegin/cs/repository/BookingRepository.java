package edu.ozyegin.cs.repository;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.ozyegin.cs.entity.Booking;
@Repository
public class BookingRepository {
    @PersistenceContext
    private EntityManager entityManager;

}
