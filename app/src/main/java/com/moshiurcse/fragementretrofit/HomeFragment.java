package com.moshiurcse.fragementretrofit;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button goToBtn;

    private EditText initialET,monthET,yearET;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        goToBtn=view.findViewById(R.id.goToBtn);

        initialET=view.findViewById(R.id.enterInitial);
        monthET=view.findViewById(R.id.enterMonth);
        yearET=view.findViewById(R.id.enderYear);





        goToBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String initial=initialET.getText().toString();
                String month=monthET.getText().toString();
                String year=yearET.getText().toString();

                Bundle bundle=new Bundle();
                bundle.putString("initial",initial);
                bundle.putString("month",month);
                bundle.putString("year",year);

                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_dataViewFragment,bundle);

            }
        });

    }
}
