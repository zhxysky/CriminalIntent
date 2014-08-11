package com.bignerdranch.android.criminalintent;

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
	private Date mDate;
	private boolean mSolved;
	
	public Crime() {
		// ����Ψһ��ʶ��
		mId = UUID.randomUUID();
		mDate = new Date();
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

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		mDate = date;
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
	
	
	
}
