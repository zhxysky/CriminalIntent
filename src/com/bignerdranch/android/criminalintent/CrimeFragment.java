package com.bignerdranch.android.criminalintent;

import java.util.Calendar;
import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

/**
 * CrimeFragment������ģ�ͼ���ͼ���󽻻��Ŀ�������������ʾ�ض�crime����ϸ��Ϣ�������û��޸���Щ��Ϣ�������������ݸ��¡�
 * @author w3
 *
 */
public class CrimeFragment extends Fragment {

	public static final String EXTRA_CRIME_ID = "com.bignerdranch.android.criminallintent.crime_id";
	private  Crime mCrime;
	private EditText mTitleField;
	private Button mDateButton;
	private Button mTimeButton;
	private CheckBox mSolvedCheckBox;
	
	private static final String DIALOG_DATE = "date";
	private static final int REQUEST_DATE = 0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		UUID crimeId = (UUID) getActivity().getIntent().getSerializableExtra(EXTRA_CRIME_ID);
		
		//��Bundle��ӵĲ���argument�л�ȡ��Ϣ
		UUID crimeId = (UUID) getArguments().getSerializable(EXTRA_CRIME_ID);
		
		mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
	}
	
	/**
	 * ��fragment_crime.xml�����в�����������ͼ
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_crime, parent, false);
		
		mTitleField = (EditText) v.findViewById(R.id.crime_title);
		mTitleField.setText(mCrime.getTitle());
		mTitleField.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mCrime.setTitle(c.toString());
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
			}
		});
		
		
		//��������ӵİ�ť
		mDateButton = (Button) v.findViewById(R.id.crime_date);
		updateDate();
//		mDateButton.setEnabled(false);
		//���õ�����ڰ�ť�����Ի���
		mDateButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fm = getActivity().getSupportFragmentManager();
				DatePickerFragment dialog = DatePickerFragment.newInstance(mCrime.getCalendar());
				dialog.setTargetFragment(CrimeFragment.this, REQUEST_DATE);
				dialog.show(fm, DIALOG_DATE);
				
			}
		});
		
		mTimeButton = (Button) v.findViewById(R.id.crime_time);
		updateTime();
		mTimeButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fm = getActivity().getSupportFragmentManager();
				TimePickerFragment timeDialog = TimePickerFragment.newInstance(mCrime.getCalendar());
				timeDialog.setTargetFragment(CrimeFragment.this, REQUEST_DATE);
				timeDialog.show(fm, DIALOG_DATE);
			}
		});
		
		mSolvedCheckBox = (CheckBox) v.findViewById(R.id.crime_solved);
		mSolvedCheckBox.setChecked(mCrime.isSolved());
		mSolvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mCrime.setSolved(isChecked);
			}
		});
		
		return v;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode != Activity.RESULT_OK) return;
		if(requestCode == REQUEST_DATE) {
			Calendar calendar = (Calendar) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
			mCrime.setCalendar(calendar);
			updateDate();
			updateTime();
		}
	}
	
	
	public void updateDate() {
		mDateButton.setText(CalendarUtil.formatCalendarDate(mCrime.getCalendar()));
	}
	
	public void updateTime() {
		mTimeButton.setText(CalendarUtil.formatCalendarTime(mCrime.getCalendar()));
	}
	
	public static CrimeFragment newInstance(UUID crimeId) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_CRIME_ID, crimeId);
		
		CrimeFragment fragment = new CrimeFragment();
		fragment.setArguments(args);
		
		return fragment;
	}
}
