package com.bignerdranch.android.criminalintent;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class CrimeListFragment extends ListFragment {

	
	private static final String TAG = "CrimeListFragment"; 
	
	private ArrayList<Crime> mCrimes;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActivity().setTitle(R.string.crimes_title);
		mCrimes = CrimeLab.get(getActivity()).getCrimes();
		
		CrimeAdapter adapter = new CrimeAdapter(mCrimes);
		setListAdapter(adapter);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Crime c = ((CrimeAdapter) getListAdapter()).getItem(position);
//		Log.d(TAG, c.getTitle()+" was clicked");
		//启动明细的activity
		Intent intent = new Intent(getActivity(),CrimePagerActivity.class); //启动CrimePagerActivity
		intent.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getId());
		startActivity(intent);
		
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		((CrimeAdapter) getListAdapter()).notifyDataSetChanged(); //刷新显示列表
	}
	
	

	
	private class CrimeAdapter extends ArrayAdapter<Crime> {
		public CrimeAdapter(ArrayList<Crime> crimes) {
			super(getActivity(),0,crimes);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			if(convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
			}
			
			Crime c = getItem(position);
			
			TextView titleTextView = (TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
			titleTextView.setText(c.getTitle());
			TextView dateTextView = (TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
			dateTextView.setText(CalendarUtil.formatCalendarDate(c.getCalendar())+" "+CalendarUtil.formatCalendarTime(c.getCalendar()));
			CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
			solvedCheckBox.setChecked(c.isSolved());
			return convertView;
		}
	}
	
	
}
