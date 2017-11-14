package srongklod_bangtamruat.plantseconomic.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import srongklod_bangtamruat.plantseconomic.R;
import srongklod_bangtamruat.plantseconomic.utility.MyAlert;

/**
 * Created by Administrator on 12/11/2560.
 */

public class CustomerRegisterFragment extends Fragment {
    //    Explicit
    private String nameString, surNameString, emailString, passwordString, phoneString;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Save Controller
        saveController();


    }//Main Method

    private void saveController() {
        Button button = getView().findViewById(R.id.btnSaveCustomer);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Initial EditText
                EditText nameEditText = getView().findViewById(R.id.edtName);
                EditText surNameEditText = getView().findViewById(R.id.edtSurname);
                EditText emailEditText = getView().findViewById(R.id.edtEmail);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);
                EditText phoneEditText = getView().findViewById(R.id.edtPhone);

//                Get Value from EditText
                nameString = nameEditText.getText().toString().trim();
                surNameString = surNameEditText.getText().toString().trim();
                emailString = emailEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                phoneString = phoneEditText.getText().toString().trim();

//                Check Space
                if (checkSpace()) {
//                    HaveSpec
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.nomalDialog(getResources().getString(R.string.title_have_space),
                            getResources().getString(R.string.massage_have_space));
                } else {
//                    NO Space
                    confirmValue();
                }



            }//On Click
        });

    }

    private void confirmValue() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.ic_action_upload);
        builder.setCancelable(false);
        builder.setTitle("please Confirm Value");
        builder.setMessage("Name = " + nameString + "\n" +
                "Surname = " + surNameString + "\n" +
                "Email = " + emailString + "\n" +
                "Password = " + passwordString + "\n" +
                "Phone = " + phoneString);
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                uploadValueFirebase();
                dialogInterface.dismiss();
            }
        });
        builder.show();

    }//ConfirmValue

    private void uploadValueFirebase() {

    }

    private boolean checkSpace() {
        return nameString.equals("")
                ||surNameString.equals("")
                ||emailString.equals("")
                ||passwordString.equals("")
                ||phoneString.equals("");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_register, container, false);
        return view;

    }
}//Main Class
