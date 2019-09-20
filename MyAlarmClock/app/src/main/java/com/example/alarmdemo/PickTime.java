package com.example.alarmdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * A simple [Fragment] subclass.
 */
public class PickTime extends DialogFragment implements View.OnClickListener {
    public PickTime(PickerListener pickerListener) {
        this.pickerListener = pickerListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_done_picker:
                pickerListener.onSelectTime(timePicker.getHour(), timePicker.getMinute());
                dismiss();
        }
    }

    TimePicker timePicker;
    Button btnDone;
    PickerListener pickerListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_picker, container, false);
        btnDone = view.findViewById(R.id.btn_done_picker);
        timePicker = view.findViewById(R.id.time_picker);
        timePicker.setIs24HourView(true);
        btnDone.setOnClickListener(this);
        getDialog().getWindow().setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        return view;
    }

    interface PickerListener {
        void onSelectTime(int hour, int minute);
    }
}



