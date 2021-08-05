//package org.techtown.dontlate;
//
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import com.skt.Tmap.TMapMarkerItem;
//import com.skt.Tmap.TMapPoint;
//import com.skt.Tmap.TMapView;
//
//public class TestApi extends Fragment {
//
//    private View view;
//
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        View v = inflater.inflate(R.layout.navigations, container, false);
//
//        TMapView tmapview = new TMapView(getActivity());
//        tmapview.setSKTMapApiKey("l7xx3dc0b9112d6b4d839182426e310df3a9");
//
//        TMapMarkerItem markerItem1 = new TMapMarkerItem();
//
//        TMapPoint tMapPoint1 = new TMapPoint(37.570841, 126.985302); // SKT타워
//
//        // 마커 아이콘
//        /*Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.pin_r_m_a);
//
//        markerItem1.setIcon(bitmap); // 마커 아이콘 지정
//        markerItem1.setPosition(0.5f, 1.0f); // 마커의 중심점을 중앙, 하단으로 설정
//        markerItem1.setTMapPoint( tMapPoint1 ); // 마커의 좌표 지정
//        markerItem1.setName("SKT타워"); // 마커의 타이틀 지정
//        tmapview.addMarkerItem("markerItem1", markerItem1); // 지도에 마커 추가
//
//        tmapview.setCenterPoint( 126.985302, 37.570841 );*/
//
//        return v;
//
//    }
//}
