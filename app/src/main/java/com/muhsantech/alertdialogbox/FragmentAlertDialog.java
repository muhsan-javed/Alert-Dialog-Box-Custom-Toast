package com.muhsantech.alertdialogbox;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class FragmentAlertDialog extends DialogFragment {

    public static final String TAG = "TAG";
    private final String[] mColors={"Red", "Green","Blue","Yellow"};
    private String selectedValue = null;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder exitDialog = new AlertDialog.Builder(getActivity());
//        exitDialog.setTitle("Exit");
        exitDialog.setTitle("Pick Color");

        //exitDialog.setMessage("Are you want to exit");
//        exitDialog.setIcon(R.drawable.ic_baseline_exit_to_app_24);
//        exitDialog.setItems(mColors, new DialogInterface.OnClickListener() {
//        exitDialog.setSingleChoiceItems(mColors, 2, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Log.d(TAG,"onClick: "+mColors[i]);
//                selectedValue = mColors[i];
//            }
//        });

        exitDialog.setMultiChoiceItems(mColors, new boolean[]{true,false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if (b){
                    //add item to selected items list
                    Log.d(TAG, "OnClick: Added: "+mColors[i]);
                }else {
                    // if the item is in selected items list
                    // remove it from the list
                    Log.d(TAG, "OnClick: Removed: "+mColors[i]);
                }
            }
        });
        exitDialog.setPositiveButton("No", (dialogInterface, i) ->
                Toast.makeText(getActivity(), "Welcome back !", Toast.LENGTH_SHORT).show());
        exitDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Yes", Toast.LENGTH_SHORT).show();
            }
        });
        exitDialog.setNeutralButton("Cancel", (dialogInterface, i) -> {
                exitDialog.create().dismiss();
                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
        });
        //exitDialog.show();

        return exitDialog.create();
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Toast.makeText(getActivity(), "You can Select: "+selectedValue, Toast.LENGTH_SHORT).show();
    }
}
