package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * �й�fragtment�Ҽ���Froyo�Լ�GingerBread��activity
 * 
 * 
 * Ϊ���й�UI gragment��activity����������
 * 1.�ڲ�����Ϊfragment����ͼ����λ��
 * 2.����fragmentʵ������������
 * 
 * 
 * ��activity���й�һ��UI fragment�����������ַ�����1.���fragment��activity�����С�2.��activity���������fragment
 * @author w3
 *
 */
public class CrimeActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crime);
	}


	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_crime,
					container, false);
			return rootView;
		}
	}

}
