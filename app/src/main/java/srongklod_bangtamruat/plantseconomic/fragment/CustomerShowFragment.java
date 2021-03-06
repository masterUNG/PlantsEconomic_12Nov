package srongklod_bangtamruat.plantseconomic.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Random;

import srongklod_bangtamruat.plantseconomic.R;
import srongklod_bangtamruat.plantseconomic.ServiceActivity;
import srongklod_bangtamruat.plantseconomic.utility.MyAlert;

/**
 * Created by Administrator on 30/12/2560.
 */

public class CustomerShowFragment extends Fragment {

    //    Explicit
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    private ImageView imageView;
    private Uri uri;
    private String[] customerStrings;
    private de.hdodenhof.circleimageview.CircleImageView circleImageView;
    private boolean statusABoolean = false;

    public static CustomerShowFragment customerShowInstance(String[] customerStrings) {

        CustomerShowFragment customerShowFragment = new CustomerShowFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Customer", customerStrings);
        customerShowFragment.setArguments(bundle);
        return customerShowFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Value From Activity
        getValueFromArgument();

//        Show Text
        showText();

//        Show Image
        showImage();

//        Image Controller
        imageController();

//        UpLoad Controller
        upLoadController();

    }//Main Method

    private void showImage() {

        final String tag = "3JanV2";

        try {

            FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
            StorageReference storageReference = firebaseStorage.getReference();
            storageReference.child("Avata/9ecx9FHQ88fETh8NnEbxkyANflH2_38.jpg").getDownloadUrl()
                    .addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            Log.d(tag, "uri ==> " + uri.toString());

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Log.d(tag, "e onFailure ==>" + e.toString());

                }
            });

            String urlImage = "https://firebasestorage.googleapis.com/v0/b/plantseconomic.appspot.com/o/Avatar%2F9ecx9FHQ88fETh8NnEbxkyANflH2_92?alt=media&token=f22e3591-3339-49f6-9fa5-79801b74ee7d";

            circleImageView = getView().findViewById(R.id.imvAvatar);
            Picasso.with(getActivity()).load(urlImage).into(circleImageView);

        } catch (Exception e) {
            Log.d(tag, "e ==> " + e.toString());
        }


    }

    private void upLoadController() {

        ImageView imageView = getView().findViewById(R.id.imvUpload);
        final String tag = "3JanV1";

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (statusABoolean) {

                    try {

                        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
                        progressDialog.setTitle("Upload Image");
                        progressDialog.setMessage("Please Wail few Minus...");
                        progressDialog.show();

                        firebaseStorage = FirebaseStorage.getInstance();
                        storageReference = firebaseStorage.getReference();

                        Random random = new Random();
                        int indexAInt = random.nextInt(100);
                        String nameImageString = customerStrings[3] + "_" + Integer.toString(indexAInt);

                        StorageReference reference = storageReference.child("Avatar/" + nameImageString);
                        reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                progressDialog.dismiss();
                                Toast.makeText(getActivity(), getString(R.string.message_success),Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                                progressDialog.dismiss();
                                MyAlert myAlert = new MyAlert(getActivity());
                                myAlert.nomalDialog("Cannot Upload Image",
                                        e.getMessage());

                            }
                        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                                double processADouble = 100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount();
                                int processAInt = (int) processADouble;

                                progressDialog.setMessage("Upload ==> "+Integer.toString(processAInt)+"%");

                            }
                        });

                    } catch (Exception e) {
                        Log.d(tag, "e ==>" + toString());

                    }

                } else {
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.nomalDialog("Cannot Choose Image",
                            getString(R.string.message_choose_image));

                }

            }
        });

    }//UploadController

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getActivity().RESULT_OK) {

            statusABoolean = true;

            //Show Image
            try {
                uri = data.getData();
                Bitmap bitmap = BitmapFactory
                        .decodeStream(getActivity().getContentResolver().openInputStream(uri));
                circleImageView.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            MyAlert myAlert = new MyAlert(getActivity());
            myAlert.nomalDialog("Non Complete Choose Image", getString(R.string.message_choose_image));
        }

    }

    private void imageController() {


        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent,getString(R.string.message_choose_image)),
                        1);
            }
        });

    }

    private void showText() {

        TextView nameTextView = getView().findViewById(R.id.txtName);
        TextView lastnameTextView = getView().findViewById(R.id.txtLastName);
        TextView phoneTextView = getView().findViewById(R.id.txtPhone);

        nameTextView.setText(customerStrings[1]);
        lastnameTextView.setText(customerStrings[0]);
        phoneTextView.setText(customerStrings[2]);

    }

    private void getValueFromArgument() {
        customerStrings = getArguments().getStringArray("Customer");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_show, container, false);
        return view;
    }
}//Main Class
