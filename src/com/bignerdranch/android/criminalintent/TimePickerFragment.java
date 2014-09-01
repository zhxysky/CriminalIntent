package com.bignerdranch.android.criminalintent;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class TimePickerFragment extends DialogFragment {

	public static final String EXTRA_DATE = "com.bignerdranch.android.criminalintent.date";

	// private Date mDate;
	private Calendar mCalendar;

	public static TimePickerFragment newInstance(Calendar calendar) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_DATE, calendar);

		TimePickerFragment fragment = new TimePickerFragment();
		fragment.setArguments(args);

		return fragment;
	}

	private void sendResult(int resultCode) {
		if (getTargetFragment() == null)
			return;
		Intent i = new Intent();
		i.putExtra(EXTRA_DATE, mCalendar);

		getTargetFragment().onActivityResult(getTargetRequestCode(),
				resultCode, i);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		mCalendar = (Calendar) getArguments().getSerializable(EXTRA_DATE);

		// Calendar calendar = Calendar.getInstance();
		// calendar.setTime(mDate);
		int hour = mCalendar.get(Calendar.HOUR);
		int minute = mCalendar.get(Calendar.MINUTE);

		// 获取日期对话框
		View v = getActivity().getLayoutInflater().inflate(
				R.layout.dialog_time, null);

		TimePicker timePicker = (TimePicker) v
				.findViewById(R.id.dialog_time_timePicker);
		timePicker.setCurrentHour(hour);
		timePicker.setCurrentMinute(minute);

		timePicker.setOnTimeChangedListener(new OnTimeChangedListener() {

			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				mCalendar = new GregorianCalendar(mCalendar.get(Calendar.YEAR),
						mCalendar.get(Calendar.MONTH), mCalendar
								.get(Calendar.DAY_OF_MONTH), hourOfDay, minute);

				getArguments().putSerializable(EXTRA_DATE, mCalendar);

			}
		});

		return new AlertDialog.Builder(getActivity())
				.setView(v)
				.setTitle(R.string.time_picker_title)
				// .setPositiveButton(android.R.string.ok, null).create();
				.setPositiveButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								sendResult(Activity.RESULT_OK);

							}
						}).create();
	}
}
