package org.techtown.dontlate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    private ArrayList<ScheduleListItem> schedules;
    private Context context;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    public ScheduleAdapter(ArrayList<ScheduleListItem> schedules, Context context) {
        this.schedules = schedules;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView startTime;
        TextView endTime;
        TextView scheduleName;
        TextView scheduleMemo;

        ViewHolder(View v) {
            super(v);
            this.startTime = v.findViewById(R.id.starttext);
            this.endTime = v.findViewById(R.id.endtext);
            this.scheduleName = v.findViewById(R.id.scheduleText);
            this.scheduleMemo = v.findViewById(R.id.memotext);

            database = FirebaseDatabase.getInstance();
            databaseReference = database.getReference();

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("선택한 항목을 삭제하시겠습니까?")
                            .setTitle("항목 삭제")
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    schedules.remove(getAdapterPosition());
                                    notifyItemRemoved(getAdapterPosition());
                                    deleteSchedule(getAdapterPosition());

                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            }).show();
                }
            });
        }
    }

    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context mcontext = parent.getContext();
        context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.scheduleitem, parent, false);
        ScheduleAdapter.ViewHolder vh = new ScheduleAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(ScheduleAdapter.ViewHolder holder, int pos) {

        ScheduleListItem item = schedules.get(pos);

        holder.startTime.setText(item.getStartTime());
        holder.endTime.setText(item.getEndTime());
        holder.scheduleName.setText(item.getScheduleName());
        holder.scheduleMemo.setText(item.getScheduleMemo());
    }

    @Override
    public int getItemCount() { return (schedules != null ? schedules.size() : 0); }

    public void addItem(ScheduleListItem item) { schedules.add(item); }

    public void setItems(ArrayList<ScheduleListItem> items) { this.schedules = items; }

    public ScheduleListItem getItem(int i) { return schedules.get(i); }

    private void deleteSchedule(final int position) {
        databaseReference.child("Nutji").child("Schedule").child(schedules.get(position).ScheduleName).removeValue();
        //삭제 안 됨 오류
    }

}
