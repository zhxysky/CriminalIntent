package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * CrimeFragment类是与模型及视图对象交互的控制器，用于显示特定crime的明细信息，并在用户修改这些信息后立即进行内容更新。
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
	 * 从fragment_crime.xml布局中产生并返回视图
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_crime, parent, false);
		return v;
	}
}
