package com.muhsantech.alertdialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;


import com.codezal.sweetalert.SweetAlertDialog;
import com.google.android.material.textview.MaterialTextView;
import com.muhsantech.alertdialogbox.databinding.ActivityMainBinding;
import com.shashank.sony.fancytoastlib.FancyToast;




public class MainActivity extends AppCompatActivity {

    //Button order, btnExit;
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

//        order = findViewById(R.id.button);
//        btnExit = findViewById(R.id.btnExit);

        // Custom Toast Code
        mainBinding.btnToast.setOnClickListener(view -> {
            // This is Android Build Toast
            // Toast.makeText(getApplicationContext(), "This is My First Toast", Toast.LENGTH_LONG).show();

            // Custom Toast
            Toast toast = new Toast(this); // Creating TOAST
            // ADD your TOAST Layout or layout find ID
            View viewT = getLayoutInflater().inflate(R.layout.custom_toast_layout, findViewById(R.id.viewContainer));
            toast.setView(viewT); // set View
            //toast.setText(""); // Not Used this Method
            MaterialTextView txtMsg = viewT.findViewById(R.id.txtMsg); // Find ID
            txtMsg.setText(R.string.showMessage); // Set Your Message
            toast.setDuration(Toast.LENGTH_LONG); // Set Toast Duration
            toast.setGravity(Gravity.CENTER, 0,0); // Set Toast Gravity
            toast.show(); // this very Import method you cannot write this method, Not show TOAST.......
        });

        // Exit Alert Dialog Box
        mainBinding.btnExit.setOnClickListener(v -> new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.ic_baseline_exit_to_app_24)
                .setTitle("Exit")
                .setMessage("are you sure you want to exit this app")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNeutralButton("help",
                        (dialog, which) -> Toast.makeText(MainActivity.this, "Pres Yes to exit this app", Toast.LENGTH_SHORT).show())
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show());

        // Single Button Dialog Box
       /**
       AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Terms & Conditions");
        alertDialog.setIcon(R.drawable.ic_baseline_info_24);
        alertDialog.setMessage("Here you read all the T & C");
        alertDialog.setButton("Yes, I've Read", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Yes, You can proceed now..", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();**/


        // Two Button AlertDialog
        AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);
        delDialog.setTitle("Delete");
        delDialog.setIcon(R.drawable.ic_baseline_delete_24);
        delDialog.setMessage("Are you sure..");
        delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("No", (dialogInterface, i) -> Toast.makeText(MainActivity.this, "Item Not Deleted", Toast.LENGTH_SHORT).show());
        //delDialog.show();


        // Create Custom Dialog
        mainBinding.order.setOnClickListener(view -> {
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.custom_dialog_layout);
            dialog.setCancelable(false); // NOT CLOSE

            CardView OkCardView = dialog.findViewById(R.id.OkCardView);
            OkCardView.setOnClickListener(view1 -> {
                Toast.makeText(this, "Closed", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
            dialog.show();

        });

        mainBinding.btnFragment.setOnClickListener(view -> {
            FragmentAlertDialog alertDialog = new FragmentAlertDialog();
//            alertDialog.setCancelable(false);
            alertDialog.show(getSupportFragmentManager(), "FragmentDialog");
        });

        mainBinding.btnFancyToast.setOnClickListener(v -> {
            FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
            FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show();
            FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_SHORT,FancyToast.INFO,true).show();
            FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_SHORT,FancyToast.DEFAULT,true).show();
            FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
        });

        // Sweet Alert Code
        mainBinding.sweetAlert.setOnClickListener(v -> {
            SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog.setTitleText("Loading");
            pDialog.setCancelable(false);
            pDialog.show();
        });
        mainBinding.sweetAlertError.setOnClickListener(v -> {
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Oops...")
                    .setContentText("Something went wrong!")
                    .show();
        });
        mainBinding.WARNINGTYPE.setOnClickListener(v -> {
            new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Are you sure?")
                    .setContentText("Won't be able to recover this file!")
                    .setCancelText("No,cancel plx!")
                    .setConfirmText("Yes,delete it!")
                    .showCancelButton(true)
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.cancel();
                        }
                    })
                    .show();
        });

        mainBinding.CUSTOMIMAGETYPE.setOnClickListener(v -> {
            new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setTitleText("Sweet!")
                    .setContentText("Here's a custom image.")
                    .setCustomImage(R.drawable.pic_save)
                    .show();
        });
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);
        exitDialog.setTitle("Exit");
        exitDialog.setMessage("Are you want to exit");
        exitDialog.setIcon(R.drawable.ic_baseline_exit_to_app_24);
        exitDialog.setPositiveButton("No", (dialogInterface, i) ->
                Toast.makeText(MainActivity.this, "Welcome back !", Toast.LENGTH_SHORT).show());
        exitDialog.setNegativeButton("Yes", (dialogInterface, i) ->
                MainActivity.super.onBackPressed());
        exitDialog.setNeutralButton("Cancel", (dialogInterface, i) ->
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show());
        exitDialog.show();

    }
}