package com.example.android.homedesignar;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import android.text.Editable;
import android.text.InputType;
import android.text.InputFilter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import androidx.fragment.app.FragmentManager;


public class ResolveDialogFragment extends DialogFragment {


    interface OkListener {
        void onOkPressed(String dialogValue);
    }

    private OkListener okListener;
    private EditText shortCodeField;


    void setOkListener(OkListener okListener) {
        this.okListener = okListener;
    }


    private LinearLayout getDialogLayout() {
        Context context = getContext();
        LinearLayout layout = new LinearLayout(context);
        shortCodeField = new EditText(context);
        shortCodeField.setInputType(InputType.TYPE_CLASS_NUMBER);
        shortCodeField.setLayoutParams(
                new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        shortCodeField.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        layout.addView(shortCodeField);
        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        return layout;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder
                .setView(getDialogLayout())
                .setTitle("Resolve Anchor")
                .setPositiveButton(
                        "OK",
                        (dialog, which) -> {
                            Editable shortCodeText = shortCodeField.getText();
                            if (okListener != null && shortCodeText != null && shortCodeText.length() > 0) {
                                okListener.onOkPressed(shortCodeText.toString());
                            }
                        })
                .setNegativeButton("Cancel", (dialog, which) -> {});
        return builder.create();
    }
}