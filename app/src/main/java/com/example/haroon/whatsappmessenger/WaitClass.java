package com.example.haroon.whatsappmessenger;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by Haroon on 10/1/2017.
 */
public class WaitClass extends AsyncTask<String,Void,Void>
{
        ProgressDialog dialog;
    Handler h = new Handler();
    String number;

    Context c;

    WaitClass(Context c)
    {
        this.c=c;
    }

    @Override
    protected Void doInBackground(String... voids) {

            number = voids[0];
            try
            {
                Thread.sleep(2500);

            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(c);
        dialog.setMessage("Connecting");
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        dialog.dismiss();
        h.post(new Runnable() {
            @Override
            public void run() {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(c);
                alertDialog.setMessage("We will be verifying the phone number:\n" + number + "\n\n" + "Is this OK, or would you like to edit the number?");
                alertDialog.setPositiveButton("EDIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.create().dismiss();
                    }
                });

                alertDialog.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       Intent myintent = new Intent(c,VerifyCodeActivity.class);
                        myintent.putExtra("number",number);
                        c.startActivity(myintent);

                    }
                });
                alertDialog.show();



            }
        });

    }
}
