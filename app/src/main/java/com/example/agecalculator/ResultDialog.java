package com.example.agecalculator;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class ResultDialog extends DialogFragment {
    String message;
    ResultDialog(String message) {
        super();
        this.message = message;
    }


    @Override
    public AlertDialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Your Age").setMessage(message);

        return builder.create();
    }

    public static String TAG="Dialog";
}