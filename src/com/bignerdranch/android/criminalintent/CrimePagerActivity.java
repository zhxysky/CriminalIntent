package com.bignerdranch.android.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class CrimePagerActivity extends FragmentActivity {

	private ViewPager mViewPager;
	private ArrayList<Crime> mCrimes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		mViewPager = new ViewPager(this);
		mViewPager.setId(R.id.viewPager);
		setContentView(mViewPager);
		
		
		mCrimes = CrimeLab.get(this).getCrimes();
		FragmentManager fm = getSupportFragmentManager();
		mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
			
			@Override
			public int getCount() {
				return mCrimes.size();
			}
			
			@Override
			public Fragment getItem(int pos) {
				Crime crime = mCrimes.get(pos);
				return CrimeFragment.newInstance(crime.getId());
			}
		});
		
		//������ǰҳ���״̬�仯��ҳ��״̬�仯ʱ�����Խ�Crimeʵ���ı������ø�CrimePagerActivity
		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				Crime crime = mCrimes.get(pos);
				if(crime.getTitle() != null) {
					setTitle(crime.getTitle());
				}
			}
			
			@Override
			public void onPageScrolled(int pos, float posOffset, int posOffsetPixels) {}
			
			@Override
			public void onPageScrollStateChanged(int state) {}
		});
		
		//ѭ���б���crime��ID���ҳ����û������Crime��id��ͬ��crime������λ�á�
		UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		for(int i=0;i<mCrimes.size();i++) {
			if(mCrimes.get(i).getId().equals(crimeId)) {
				mViewPager.setCurrentItem(i);
				break;
			}
		}
	}
}
