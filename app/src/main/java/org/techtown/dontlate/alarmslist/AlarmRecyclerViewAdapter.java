package org.techtown.dontlate.alarmslist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import org.techtown.dontlate.R;
import org.techtown.dontlate.data.Alarm;
import org.techtown.dontlate.data.AlarmDao;
import org.techtown.dontlate.data.AlarmDatabase;
import org.techtown.dontlate.data.AlarmRepository;

import java.util.ArrayList;
import java.util.List;


public class AlarmRecyclerViewAdapter extends RecyclerView.Adapter<AlarmViewHolder>  {

    private List<Alarm> alarms = new ArrayList<>();
    private OnToggleAlarmListener listener;
    private int position = 0;
//    private AlarmDatabase adb;
    private long created;
    AlarmRepository arepo;

    public AlarmRecyclerViewAdapter(OnToggleAlarmListener listener) {
        this.alarms = new ArrayList<Alarm>();
        this.listener = listener;
            }

    @NonNull
    @Override
    public AlarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alarm, parent, false);
//        AlarmRecyclerViewAdapter.ViewHolder vholder = new ViewHolder(itemView);
        return new AlarmViewHolder(itemView, listener);
    }


    //RecyclerView 아이템 LongClick시 확인창 띄우고 삭제
    @Override
    public void onBindViewHolder(@NonNull AlarmViewHolder holder, int pos) {
        Alarm alarm = alarms.get(pos);
        holder.bind(alarm);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.setBackgroundColor(Color.parseColor("#E2E2E2"));
                AlertDialog.Builder alert = new AlertDialog.Builder(holder.itemView.getContext())
                        .setTitle("알람 삭제")
                        .setMessage("선택하신 알람을 삭제하시겠습니까?")
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //데이터베이스에 저장되어있는 선택된 알람 데이터 삭제(DB데이터 삭제)
                        AlarmDatabase adb = Room.databaseBuilder(holder.itemView.getContext(),AlarmDatabase.class,"alarm_database").allowMainThreadQueries().build();
                        AlarmDao adao = adb.alarmDao();
                        position = holder.getAdapterPosition();
                        System.out.println(position);
                        Alarm alarm = alarms.get(position);
                        adao.delete(alarm);
                        //RecyclerView에서 선택된 아이템 삭제(View에서 삭제)
                        removeItem(position);
                        notifyItemRemoved(position);
                        notifyItemChanged(position,alarms.size());
                        v.setBackgroundColor(Color.parseColor("#ffffff"));

                    }
                })
                    .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.itemView.getContext(),"취소하셨습니다.",Toast.LENGTH_SHORT).show();
                        v.setBackgroundColor(Color.parseColor("#ffffff"));
                    }
                });

                AlertDialog msgDlg = alert.create();
                msgDlg.show();

                return true;
            }
        });

    }

    
    //설정된 알람 리스트들의 크기 계산 후 반환
    @Override
    public int getItemCount() {
        return alarms.size();
    }

    //알람 설정시 리스트 추가 후 반환
    public void setAlarms(List<Alarm> alarms) {
        this.alarms = alarms;
        notifyDataSetChanged();
    }
    
    
    @Override
    public void onViewRecycled(@NonNull AlarmViewHolder holder) {
        super.onViewRecycled(holder);
        holder.alarmStarted.setOnCheckedChangeListener(null);
    }

    //View에서 아이템을 지우는 메서드
    public void removeItem(int position){
        alarms.remove(position);
        notifyItemRemoved(position);
        //갱신처리 반드시 해야함
        notifyDataSetChanged();
    }



//    //item과 view를 묶어줌
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        LinearLayout cardView;
//        TextView alarmTime;
//        TextView alarmRecurringDays;
//        TextView alarmTitle;
//        TextView alarmMemo;
//
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            cardView = itemView.findViewById(R.id.cardview);
//            alarmTime = itemView.findViewById(R.id.item_alarm_time);
//            alarmRecurringDays = itemView.findViewById(R.id.item_alarm_recurringDays);
//            alarmTitle = itemView.findViewById(R.id.item_alarm_title);
//            alarmMemo = itemView.findViewById(R.id.item_alarm_memo);
//
//        }
//
//    }

}

