package org.techtown.dontlate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//import net.daum.android.map.MapView;
import net.daum.android.map.MapViewEventListener;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;



import java.util.Map;

public class navigationss extends Fragment {



    private View view;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.navigations, container, false);

        MapView mapView = new MapView(this.getActivity());

        mapView.setDaumMapApiKey("8ae57c6ab583cbe890979e12b4c0315a");

        ViewGroup mapViewContainer = (ViewGroup) v.findViewById(R.id.map_view);

        mapViewContainer.addView(mapView);



        mapView.setMapViewEventListener((MapViewEventListener) this.getActivity());
        mapView.setPOIItemEventListener((MapView.POIItemEventListener) this.getActivity());

        // 중심점 변경 - 예제 좌표는 서울 남산
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.54892296550104, 126.99089033876304), true);

        // 줌 레벨 변경
        mapView.setZoomLevel(4, true);

        //마커 찍기
        MapPoint MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.54892296550104, 126.99089033876304);
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("Default Marker");
        marker.setTag(0);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.


        mapView.addPOIItem(marker);


        return v;
    }
}
