package edu.ozyegin.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ozyegin.cs.entity.Booking;
import edu.ozyegin.cs.repository.BookingRepository;
@Service
public class BookingService {

    @Autowired
    BookingRepository repository;
}