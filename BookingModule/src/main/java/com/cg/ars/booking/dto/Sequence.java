package com.cg.ars.booking.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="BookingSequence")
public class Sequence
{
	@Id
	private int id;
	
	private int sequenceId;

	public Sequence(int id, int sequenceId) {
		this.id = id;
		this.sequenceId = sequenceId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(int sequenceId) {
		this.sequenceId = sequenceId;
	}
}
