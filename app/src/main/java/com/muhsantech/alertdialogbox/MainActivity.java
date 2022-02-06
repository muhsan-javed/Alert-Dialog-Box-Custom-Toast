package com.muhsantech.alertdialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        order = findViewById(R.id.button);

        // Single Button Dialog Box
        /*AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Terms & Conditions");
        alertDialog.setIcon(R.drawable.ic_baseline_info_24);
        alertDialog.setMessage("Here you read all the T & C");
        alertDialog.setButton("Yes, I've Read", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Yes, You can proceed now..", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.show();*/

        // Two Button
        AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);
        delDialog.setTitle("Delete");
        delDialog.setIcon(R.drawable.ic_baseline_delete_24);
        delDialog.setMessage("Are you sure..");

        delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Item Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        delDialog.show();


        // Create Custom Dialog
        order.setOnClickListener(view -> {
            Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.custom_dialog_layout);
            dialog.setCancelable(false); // NOT CLOSE

            Button btnOkay = dialog.findViewById(R.id.btnOkay);
            btnOkay.setOnClickListener(view1 -> {
                Toast.makeText(this, "Closed", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
            dialog.show();

        });

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);
        exitDialog.setTitle("Exit");
        exitDialog.setMessage("Are you want to exit");
        exitDialog.setIcon(R.drawable.ic_baseline_exit_to_app_24);
        exitDialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Welcome back !", Toast.LENGTH_SHORT).show();
            }
        });
        exitDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });

        exitDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        exitDialog.show();

    }
}