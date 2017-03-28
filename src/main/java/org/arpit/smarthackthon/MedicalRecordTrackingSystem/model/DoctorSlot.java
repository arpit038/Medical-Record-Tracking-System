package org.arpit.smarthackthon.MedicalRecordTrackingSystem.model;

import java.util.Date;

public class DoctorSlot {

	private int id;
	private int docId;
	private int begin;
	private int end;
	private String day;
	
	public DoctorSlot(){}

	public DoctorSlot(int id, int docId, int begin, int end, String day) {
		super();
		this.id = id;
		this.docId = docId;
		this.begin = begin;
		this.end = end;
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getStart() {
		return begin;
	}

	public void setStart(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}	
}