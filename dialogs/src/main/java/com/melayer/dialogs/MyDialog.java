package com.melayer.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by aniruddha on 7/9/17.
 */

public class MyDialog extends DialogFragment {

    public static final String TAG_ALERT = "alert";
    public static final String TAG_DATE = "date";
    public static final String TAG_TIME = "time";
    public static final String TAG_PROGRESS = "progress";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = null;
        if (getTag().equals(TAG_ALERT)) dialog = yesNo();
        if (getTag().equals(TAG_DATE)) dialog = date();
        if(getTag().equals(TAG_TIME)) dialog = time();
        if(getTag().equals(TAG_PROGRESS)) dialog = progress();

        return dialog;
    }

    private AlertDialog yesNo() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "Yes Clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity(), "No Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }

    private DatePickerDialog date() {
        DatePickerDialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(getActivity(), "" + i + " - " + i1 + " - " + i2, Toast.LENGTH_SHORT).show();
            }
        }, 2017, 8, 7);

        return dialog;
    }

    private TimePickerDialog time() {
        return new TimePickerDialog(
                getActivity(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {

                        Toast.makeText(getActivity(), "" + i + " : " + i1, Toast.LENGTH_SHORT).show();
                    }
                },
                11,
                32,
                true
        );
    }

    private Dialog progress() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog dialog = builder.create();

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View view = inflater.inflate(R.layout.custom_dialog, null, false);
        dialog.setView(view);

        return dialog;
    }
}
