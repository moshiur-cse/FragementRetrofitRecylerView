package com.moshiurcse.fragementretrofit;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moshiurcse.fragementretrofit.emp_monthly_time.EmpMonthlyTime;
import com.moshiurcse.fragementretrofit.emp_monthly_time.EmpMonthlyTimeAdaptor;
import com.moshiurcse.fragementretrofit.emp_monthly_time.EmpMonthlyTimeServiceApi;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataViewFragment extends Fragment {
    private final String BASE_URL="http://130.180.3.155:8081/cegis/api/";
    private RecyclerView recyclerView;


    public DataViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.timeShowRV);


        String endUrl="timesheet/find.php?initial=ARH&year=2019&month=12";

        String month=getArguments().getString("month");
        String year=getArguments().getString("year");
        String initial=getArguments().getString("initial");

         /*month="1";
         year="2020";
         initial="RMO";*/

        Toast.makeText(getContext(), ""+initial +":"+year+":"+month, Toast.LENGTH_SHORT).show();

/*        endUrl = String.format("forecast/daily?lat=%f&lon=%f&cnt=16&units=%s&appid=%s",
                location.getLatitude(), location.getLongitude(), units, apiKey);*/

        endUrl=String.format("timesheet/find.php?initial=%s&year=%s&month=%s",initial,year,month);

        final Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        final EmpMonthlyTimeServiceApi serviceApi=retrofit.create(EmpMonthlyTimeServiceApi.class);


        serviceApi.getAllTime(endUrl).enqueue(new Callback<List<EmpMonthlyTime>>() {
            @Override
            public void onResponse(Call<List<EmpMonthlyTime>> call, Response<List<EmpMonthlyTime>> response) {

                if(response.isSuccessful()){
                    List<EmpMonthlyTime> timeList=response.body();

                    //Log.e("flower","Respone"+flowerList.size());

                    EmpMonthlyTimeAdaptor adapter=new EmpMonthlyTimeAdaptor(getActivity(),timeList);

                    LinearLayoutManager llm=new LinearLayoutManager(getActivity());

                    //GridLayoutManager glm=new GridLayoutManager(MainActivity.this,2);
                    recyclerView.setLayoutManager(llm);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<EmpMonthlyTime>> call, Throwable t) {
                Log.e("timeList","Failer: "+t.getLocalizedMessage());

            }
        });



    }


}
