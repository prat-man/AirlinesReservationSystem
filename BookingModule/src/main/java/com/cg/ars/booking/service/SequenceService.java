package com.cg.ars.booking.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.ars.booking.dto.Sequence;

public interface SequenceService extends MongoRepository<Sequence, Integer> {

}
