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
public class CrimeActivity extends SingleFragmentActivity {

	//创建Fragment的时候调用Fragment的newInstance方法获取实例
	@Override
	protected Fragment createFragment() {
//		return new CrimeFragment();
		
		UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
		return CrimeFragment.newInstance(crimeId);
	}

}
