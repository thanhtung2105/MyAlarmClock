package com.example.alarmdemo;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple [Fragment] subclass.
 */

public class AlarmFragment extends Fragment implements View.OnClickListener, PickTime.PickerListener {
    TextView tvTime;

    @Override
    public void onSelectTime(int hour, int minute) {
        AlarmTask.setAlarm(getContext(), alarmManager, hour, minute);
        String strHour = String.valueOf(hour);
        String strMinute = String.valueOf(minute);

        if (hour < 10)
            strHour = "0" + strHour;
        if (minute < 10)
            strMinute = "0" + strMinute;

        tvTime.setText(strHour + ":" + strMinute);
        tvTime.setVisibility(View.VISIBLE);
    }

    AlarmManager alarmManager;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_list:
                showPicker();
        }
    }

    ImageButton btnAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        btnAdd = view.findViewById(R.id.btn_add_list);
        tvTime = view.findViewById(R.id.tv_time_list);
        tvTime.setVisibility(View.GONE);
        btnAdd.setOnClickListener(this);
        alarmManager = (AlarmManager) (getContext().getSystemService(Context.ALARM_SERVICE));
        return view;
    }

    public void showPicker() {
        PickTime dialog = new PickTime(this);
        dialog.show(getFragmentManager(), "timepicker");
    }
}
