package org.techtown.dontlate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.skt.Tmap.TMapMarkerItem;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapView;

public class navigationss extends Fragment {


    private View view;



    private RetrofitClient retrofitClient;
    private RetrofitInterface retrofitInterface;

    private String App_Key = "l7xxddf8547d834c4053946c4a168738d92f";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.navigations, container, false);

        Context mFcontext = getActivity();


        LinearLayout linearLayoutTmap = (LinearLayout) v.findViewById(R.id.linearLayoutTmap);
        TMapView tMapView = new TMapView(getActivity());

        tMapView.setSKTMapApiKey(App_Key);
        linearLayoutTmap.addView(tMapView);

//        TMapMarkerItem markerItem1 = new TMapMarkerItem();
//
//        TMapPoint tMapPoint1 = new TMapPoint(37.570841, 126.985302); // SKT타워
//
// //마커 아이콘
//        Bitmap bitmap = BitmapFactory.decodeResource(mFcontext.getResources(), R.drawable.pin_r_m_a);
//
//        markerItem1.setIcon(bitmap); // 마커 아이콘 지정
//        markerItem1.setPosition(0.5f, 1.0f); // 마커의 중심점을 중앙, 하단으로 설정
//        markerItem1.setTMapPoint( tMapPoint1 ); // 마커의 좌표 지정
//        markerItem1.setName("SKT타워"); // 마커의 타이틀 지정
//        tMapView.addMarkerItem("markerItem1", markerItem1); // 지도에 마커 추가
//
//        tMapView.setCenterPoint( 126.985302, 37.570841 ); //정상 작동 확인 완료







        return v;
    }

}
