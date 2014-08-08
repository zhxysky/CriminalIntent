package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * 托管fragtment且兼容Froyo以及GingerBread的activity
 * 
 * 
 * 为了托管UI gragment，activity必须做到：
 * 1.在不居中为fragment的视图安排位置
 * 2.管理fragment实例的生命周期
 * 
 * 
 * 在activity中托管一个UI fragment，有如下两种方法：1.添加fragment到activity布局中。2.在activity代码中添加fragment
 * @author w3
 *
 */
public class CrimeActivity extends FragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crime);
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		
		if(fragment == null) {
			fragment = new CrimeFragment();
			fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
		}
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
