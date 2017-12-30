package srongklod_bangtamruat.plantseconomic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ServiceActivity extends AppCompatActivity {

    //    Explicit
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private String tag = "30DecV1";
    private String userUidString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

//        Find User Uid
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        userUidString = firebaseUser.getUid();
        String displatname = firebaseUser.getDisplayName();
        Log.d(tag, "At Service userUid ==>" + userUidString);
        Log.d(tag, "disPlayName ==>" + displatname);



    }//Main Method
}//Main Class
