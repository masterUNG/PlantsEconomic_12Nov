package srongklod_bangtamruat.plantseconomic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import srongklod_bangtamruat.plantseconomic.fragment.CustomerShowFragment;
import srongklod_bangtamruat.plantseconomic.utility.CustomerModel;
import srongklod_bangtamruat.plantseconomic.utility.Myconstan;

public class ServiceActivity extends AppCompatActivity {

    //    Explicit
//    About Firebase
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;


//    General
    private String tag = "30DecV1";
    private String userUidString;
    private boolean statusABoolean = true;//true >Don'Find userUid?


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

//        Find User Uid
        findUserUid();

//        Find user in Customer
        findUserUidinCustomer();


    }//Main Method

    private void findUserUidinCustomer() {
        if (statusABoolean) {

           // FirebaseDatabase.getInstance().setPersistenceEnabled(true);

            Myconstan myconstan = new Myconstan();
            String[] fieldStrings = myconstan.getFieldCustomerStrings();
            final String[] customerStrings = new String[fieldStrings.length];

            DatabaseReference databaseReference = FirebaseDatabase.getInstance()
                    .getReference().child("Customer");

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    List list = new ArrayList();
                    int timesAInt = 0;

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                        CustomerModel customerModel = dataSnapshot1.getValue(CustomerModel.class);
                        list.add(customerModel);



                        CustomerModel customerModel1 = (CustomerModel) list.get(timesAInt);
                        Log.d(tag,"Name ["+timesAInt+"]==>"+customerModel1.getNameString());
                        timesAInt = timesAInt + 1;

                        if (userUidString.equals(customerModel1.getUidUserString())) {
                            statusABoolean = false;

                            customerStrings[0] = customerModel1.getLastNameString();
                            customerStrings[1] = customerModel1.getNameString();
                            customerStrings[2] = customerModel1.getPhoneString();
                            customerStrings[3] = customerModel1.getUidUserString();

                            for (int i=0;i<customerStrings.length;i+=1) {
                                Log.d(tag, "customer[" + i + "]==>" + customerStrings[i]);


                            }

                            getSupportFragmentManager().beginTransaction()
                                    .add(R.id.contentServiceFragment,
                                            CustomerShowFragment.
                                                    customerShowInstance(customerStrings)).commit();

                        }//if


                    }//for

                    Log.d(tag, "Status ==>" + statusABoolean);

                }//onDataChange

                @Override
                public void onCancelled(DatabaseError databaseError) {



                }
            });

        }//if

    }

    private void findUserUid() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        userUidString = firebaseUser.getUid();
        String displayName = firebaseUser.getDisplayName();
        Log.d(tag, "At Service userUid ==>" + userUidString);
        Log.d(tag, "disPlayName ==>" + displayName);
    }
}//Main Class
