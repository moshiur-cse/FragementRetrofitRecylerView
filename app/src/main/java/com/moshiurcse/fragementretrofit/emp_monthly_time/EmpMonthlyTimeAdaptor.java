package com.moshiurcse.fragementretrofit.emp_monthly_time;

import android.content.Context;
import android.net.ParseException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moshiurcse.fragementretrofit.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmpMonthlyTimeAdaptor extends RecyclerView.Adapter<EmpMonthlyTimeAdaptor.EmpMonthlyTimeViewHolder> {
    private Context context;
    private List<EmpMonthlyTime> empTimeList;

    public EmpMonthlyTimeAdaptor(Context context, List<EmpMonthlyTime> empTimeList) {
        this.context = context;
        this.empTimeList = empTimeList;
    }

    @NonNull
    @Override
    public EmpMonthlyTimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View itemView= LayoutInflater.from(context).inflate(R.layout.emp_monthly_time_row,parent,false);
        return new EmpMonthlyTimeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpMonthlyTimeViewHolder holder, int position) {


        String date =getTimeString(empTimeList.get(position).getEMPDATE());

        holder.emp_dateTV.setText(date);
        holder.emp_initialTV.setText(""+empTimeList.get(position).getEMPCODE());
        holder.inTimeTV.setText(""+empTimeList.get(position).getTimeIn());
        holder.outTimeTV.setText(""+empTimeList.get(position).getTimeOut());

    }

    @Override
    public int getItemCount() {
        return empTimeList.size();
    }

    class EmpMonthlyTimeViewHolder extends RecyclerView.ViewHolder{
        TextView emp_dateTV,emp_initialTV,inTimeTV,outTimeTV;

        public EmpMonthlyTimeViewHolder(@NonNull View itemView) {
            super(itemView);
            emp_initialTV=itemView.findViewById(R.id.row_emp_initial_id);
            emp_dateTV=itemView.findViewById(R.id.row_emp_date_id);
            inTimeTV=itemView.findViewById(R.id.row_emp_TimeIn_id);
            outTimeTV=itemView.findViewById(R.id.row_emp_TimeOut_id);

        }
    }

    private String getTimeString(String date){
        String date1=date.substring(0, 10);
        String[] date2=date1.split("-");
        String dateFormat=date2[2]+"-"+date2[1]+"-"+date2[0];
        return  dateFormat;
    }


}
