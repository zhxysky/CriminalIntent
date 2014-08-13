package com.bignerdranch.android.criminalintent;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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
public class CrimeActivity extends SingleFragmentActivity {

//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_fragment);
//		FragmentManager fm = getSupportFragmentManager();
//		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
//		
//		if(fragment == null) {
//			fragment = new CrimeFragment();
//			fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
//		}
//	}


	@Override
	protected Fragment createFragment() {
//		return new CrimeFragment();
		
		UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		return CrimeFragment.newInstance(crimeId);
	}

}
