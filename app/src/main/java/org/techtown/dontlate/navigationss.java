package org.techtown.dontlate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.daum.android.map.MapView;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;

public class navigationss extends Fragment {


    public interface OnPOIItemSelected{
        static void addPOIITEM(MapPOIItem marker) {
        }

        void onPOIItemSelected(MapView mapView, MapPOIItem mapPOIItem);
    }

    public interface OnMapViewInitialized {
        static void setMapCenterPoint(MapPoint mapPointWithGeoCoord, boolean b) {
        }

        static void setZoomLevel(int i, boolean b) {
        }

        void onMapViewInitialized (MapView mapView);
    }



    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.navigations, container, false);



        MapView mapView = new MapView(getActivity());
        ViewGroup mapViewContainer = (ViewGroup) view.findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        // 중심점 변경 - 예제 좌표는 서울 남산
        OnMapViewInitialized.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.54892296550104, 126.99089033876304), true);

        // 줌 레벨 변경
        OnMapViewInitialized.setZoomLevel(4, true);

        //마커 찍기
        MapPoint MARKER_POINT = MapPoint.mapPointWithGeoCoord(37.54892296550104, 126.99089033876304);
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("Default Marker");
        marker.setTag(0);
        marker.setMapPoint(MARKER_POINT);
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.

        OnPOIItemSelected.addPOIITEM(marker);

        return view;
    }
}
