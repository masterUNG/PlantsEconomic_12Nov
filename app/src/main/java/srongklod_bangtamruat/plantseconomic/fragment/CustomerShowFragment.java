package srongklod_bangtamruat.plantseconomic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import srongklod_bangtamruat.plantseconomic.R;
import srongklod_bangtamruat.plantseconomic.ServiceActivity;

/**
 * Created by Administrator on 30/12/2560.
 */

public class CustomerShowFragment extends Fragment{

    //    Explicit
    private String[] customerStrings;

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
        customerStrings = getArguments().getStringArray("Customer");




    }//Main Method




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_show, container, false);
        return view;
    }
}//Main Class
