package com.cg.ars.booking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.Query;

import com.cg.ars.booking.dto.Sequence;

public class BookingUtilsImpl implements BookingUtils
{
	@Autowired
	SequenceService seqSer;
	
	@Override
	public String generateBookingId(String flightNo)
	{
		Optional<Sequence> opSeq = seqSer.findById(0);
		
		int seqId;
		
		if (opSeq.isPresent()) {
			Sequence seq = opSeq.get();
			seqId = seq.getSequenceId();
			seq.setSequenceId(seqId + 1);
			seqSer.save(seq);
		}
		else {
			seqId = 1000;
			Sequence seq = new Sequence(0, 1001);
			seqSer.insert(seq);
		}
		
		return flightNo.substring(0, 3) + seqId;
	}
}
