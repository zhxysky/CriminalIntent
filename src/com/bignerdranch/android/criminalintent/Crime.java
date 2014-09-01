package com.bignerdranch.android.criminalintent;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * ���ģ�Ͳ��Crime��
 * @author w3
 *
 */
public class Crime {

	private UUID mId;
	private String mTitle;
	//private Date mDate;
	private Calendar mCalendar;
	private boolean mSolved;
	
	public Crime() {
		// ����Ψһ��ʶ��
		mId = UUID.randomUUID();
		mCalendar = Calendar.getInstance();
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public UUID getId() {
		return mId;
	}


	public Calendar getCalendar() {
		return mCalendar;
	}

	public void setCalendar(Calendar calendar) {
		mCalendar = calendar;
	}

	public boolean isSolved() {
		return mSolved;
	}

	public void setSolved(boolean solved) {
		mSolved = solved;
	}

	public void setId(UUID id) {
		mId = id;
	}
	
	@Override
	public String toString() {
		return mTitle;
	}
	
}
