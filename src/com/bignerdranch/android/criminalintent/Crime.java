package com.bignerdranch.android.criminalintent;

import java.util.UUID;

/**
 * ���ģ�Ͳ��Crime��
 * @author w3
 *
 */
public class Crime {

	private UUID mId;
	private String mTitle;
	
	public Crime() {
		// ����Ψһ��ʶ��
		mId = UUID.randomUUID();
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
	
	
}
