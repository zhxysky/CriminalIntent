package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * CrimeFragment������ģ�ͼ���ͼ���󽻻��Ŀ�������������ʾ�ض�crime����ϸ��Ϣ�������û��޸���Щ��Ϣ�������������ݸ��¡�
 * @author w3
 *
 */
public class CrimeFragment extends Fragment {

	private  Crime mCrime;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mCrime = new Crime();
	}
	
	/**
	 * ��fragment_crime.xml�����в�����������ͼ
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_crime, parent, false);
		return v;
	}
}
