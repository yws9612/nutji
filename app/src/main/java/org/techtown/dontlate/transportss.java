package org.techtown.dontlate;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.odsay.odsayandroidsdk.API;
import com.odsay.odsayandroidsdk.ODsayData;
import com.odsay.odsayandroidsdk.ODsayService;
import com.odsay.odsayandroidsdk.OnResultCallbackListener;

import org.json.JSONException;

public class transportss extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.transports, container, false);
        PublicApi.OnSuccessListener onSuccessListener = new PublicApi.OnSuccessListener() {
            @Override
            public void onRequestSuccess(String result) {
                Log.d("test ", result);
            }
        };
        //BusStationInfo(getActivity(), onSuccessListener);
        //SearchBusLane(getActivity(), onSuccessListener);
        //BusLaneDetail(getActivity(), onSuccessListener);
        //SubStationInfo(getActivity(), onSuccessListener);
        //SubTimeTable(getActivity(), onSuccessListener);
        //LoadLane(getActivity(), onSuccessListener);
        //SearchStation(getActivity(), onSuccessListener);
        //BoundarySearch(getActivity(), onSuccessListener);
        //SearchPubTransPath(getActivity(), onSuccessListener);
        //SubwayTransitInfo(getActivity(), onSuccessListener);
        //SearchCID(getActivity(), onSuccessListener);

        return view;
    }

    public void BusStationInfo(Context context, PublicApi.OnSuccessListener onSuccessListener) {

        // 싱글톤 생성, Key 값을 활용하여 객체 생성
        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        // 서버 연결 제한 시간(단위(초), default : 5초)
        odsayService.setReadTimeout(5000);
        // 데이터 획득 제한 시간(단위(초), default : 5초)
        odsayService.setConnectionTimeout(5000);

        // 콜백 함수 구현
        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            // 호출 성공 시 실행
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {
                    // API Value 는 API 호출 메소드 명을 따라갑니다.
                    if (api == API.BUS_STATION_INFO) {
                        String stationName = odsayData.getJson().getJSONObject("result").getString("stationName");
                        onSuccessListener.onRequestSuccess(stationName);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            // 호출 실패 시 실행
            @Override
            public void onError(int i, String s, API api) {
                if (api == API.BUS_STATION_INFO) {
                }
            }
        };
        // API 호출
        odsayService.requestBusStationInfo("107475", onResultCallbackListener);
    }

    public void SearchBusLane(Context context, PublicApi.OnSuccessListener onSuccessListener) {

        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        odsayService.setReadTimeout(5000);
        odsayService.setConnectionTimeout(5000);

        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {
                    if (api == API.SEARCH_BUS_LANE) {
                        String city = odsayData.getJson().getJSONObject("result").getJSONObject("totalCityList").getJSONArray("includeCity").getString(0);
                        String lane = odsayData.getJson().getJSONObject("result").getJSONArray("lane").getJSONObject(0).getString("busNo");
                        onSuccessListener.onRequestSuccess(city);
                        onSuccessListener.onRequestSuccess(lane);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int i, String s, API api) {
                if (api == API.BUS_STATION_INFO) {
                }
            }
        };
        odsayService.requestSearchBusLane("10", "", "", "", "", onResultCallbackListener);
    }

    public void BusLaneDetail(Context context, PublicApi.OnSuccessListener onSuccessListener) {

        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        odsayService.setReadTimeout(5000);
        odsayService.setConnectionTimeout(5000);

        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {
                    if (api == API.BUS_LANE_DETAIL) {
                        String busCityName = odsayData.getJson().getJSONObject("result").getString("busCityName");
                        String station = odsayData.getJson().getJSONObject("result").getString("station");
                        onSuccessListener.onRequestSuccess(busCityName);
                        onSuccessListener.onRequestSuccess(station);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int i, String s, API api) {
                if (api == API.BUS_LANE_DETAIL) {
                }
            }
        };
        odsayService.requestBusLaneDetail("12018", onResultCallbackListener);
    }

    public void SubStationInfo(Context context, PublicApi.OnSuccessListener onSuccessListener) {

        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        odsayService.setReadTimeout(5000);
        odsayService.setConnectionTimeout(5000);

        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {
                    if (api == API.SUBWAY_STATION_INFO) {
                        String stationName = odsayData.getJson().getJSONObject("result").getString("stationName");
                        String prevOBJ = odsayData.getJson().getJSONObject("result").getJSONObject("prevOBJ").getJSONArray("station").getString(0);
                        String nextOBJ = odsayData.getJson().getJSONObject("result").getJSONObject("nextOBJ").getJSONArray("station").getString(0);
                        onSuccessListener.onRequestSuccess(stationName);
                        onSuccessListener.onRequestSuccess(prevOBJ);
                        onSuccessListener.onRequestSuccess(nextOBJ);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int i, String s, API api) {
                if (api == API.SUBWAY_STATION_INFO) {
                }
            }
        };
        odsayService.requestSubwayStationInfo("130", onResultCallbackListener);
    }

    public void SubTimeTable(Context context, PublicApi.OnSuccessListener onSuccessListener) {

        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        odsayService.setReadTimeout(5000);
        odsayService.setConnectionTimeout(5000);

        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {
                    if (api == API.SUBWAY_TIME_TABLE) {
                        String laneName = odsayData.getJson().getJSONObject("result").getString("laneName");
                        String OrdList = odsayData.getJson().getJSONObject("result").getJSONObject("OrdList").getJSONObject("up").getJSONArray("time").getString(0);
                        onSuccessListener.onRequestSuccess(laneName);
                        onSuccessListener.onRequestSuccess(OrdList);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int i, String s, API api) {
                if (api == API.SUBWAY_TIME_TABLE) {
                }
            }
        };
        odsayService.requestSubwayTimeTable("130", "1", onResultCallbackListener);
    }

    public void LoadLane(Context context, PublicApi.OnSuccessListener onSuccessListener) {

        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        odsayService.setReadTimeout(5000);
        odsayService.setConnectionTimeout(5000);

        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {
                    if (api == API.LOAD_LANE) {
                        String lane = odsayData.getJson().getJSONObject("result").getJSONArray("lane").getString(0);
                        onSuccessListener.onRequestSuccess(lane);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int i, String s, API api) {
                if (api == API.LOAD_LANE) {
                }
            }
        };
        odsayService.requestLoadLane("0:0@12018:1:-1:-1", onResultCallbackListener);
    }

    public void SearchStation(Context context, PublicApi.OnSuccessListener onSuccessListener) {

        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        odsayService.setReadTimeout(5000);
        odsayService.setConnectionTimeout(5000);

        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {
                    if (api == API.SEARCH_STATION) {
                        String station = odsayData.getJson().getJSONObject("result").getJSONArray("station").getString(0);
                        onSuccessListener.onRequestSuccess(station);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int i, String s, API api) {
                if (api == API.SEARCH_STATION) {
                }
            }
        };
        odsayService.requestSearchStation("14", "", "1:2", "", "", "", onResultCallbackListener);
    }

    public void BoundarySearch(Context context, PublicApi.OnSuccessListener onSuccessListener) {

        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        odsayService.setReadTimeout(5000);
        odsayService.setConnectionTimeout(5000);

        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {
                    if (api == API.BOUNDARY_SEARCH) {
                        String station = odsayData.getJson().getJSONObject("result").getJSONArray("station").getString(0);
                        onSuccessListener.onRequestSuccess(station);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int i, String s, API api) {
                if (api == API.BOUNDARY_SEARCH) {
                }
            }
        };
        odsayService.requestBoundarySearch("127.045478316811:37.68882830829:127.055063420699:37.6370465749586", "", "1:2", onResultCallbackListener);
    }

    public void SubwayPath(Context context, PublicApi.OnSuccessListener onSuccessListener) {

        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        odsayService.setReadTimeout(5000);
        odsayService.setConnectionTimeout(5000);

        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {
                    if (api == API.SUBWAY_PATH) {
                        String time = odsayData.getJson().getJSONObject("result").getString("globalTravelTime");
                        String drive = odsayData.getJson().getJSONObject("result").getJSONObject("driveInfoSet").getJSONArray("driveInfo").getString(0);
                        String stations = odsayData.getJson().getJSONObject("result").getJSONObject("stationSet").getJSONArray("stations").getString(0);
                        onSuccessListener.onRequestSuccess(time);
                        onSuccessListener.onRequestSuccess(drive);
                        onSuccessListener.onRequestSuccess(stations);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int i, String s, API api) {
                if (api == API.SUBWAY_PATH) {
                }
            }
        };
        odsayService.requestSubwayPath("1000", "201", "222", "1", onResultCallbackListener);
    }

    public void SearchPubTransPath(Context context, PublicApi.OnSuccessListener onSuccessListener) {

        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        odsayService.setReadTimeout(5000);
        odsayService.setConnectionTimeout(5000);

        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {
                    if (api == API.SEARCH_PUB_TRANS_PATH) {
                        String path = odsayData.getJson().getJSONObject("result").getJSONArray("path").getString(0);
                        onSuccessListener.onRequestSuccess(path);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int i, String s, API api) {
                if (api == API.SEARCH_PUB_TRANS_PATH) {
                }
            }
        };
        odsayService.requestSearchPubTransPath("126.926493082645", "37.6134436427887", "127.126936754911", "37.5004198786564", "0", "", "", onResultCallbackListener);
    }

    public void SubwayTransitInfo(Context context, PublicApi.OnSuccessListener onSuccessListener) {

        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        odsayService.setReadTimeout(5000);
        odsayService.setConnectionTimeout(5000);

        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {
                    if (api == API.SUBWAY_TRANSIT_INFO) {
                        String transit = odsayData.getJson().getJSONObject("result").getJSONArray("transitTotalInfo").getString(0);
                        onSuccessListener.onRequestSuccess(transit);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int i, String s, API api) {
                if (api == API.SUBWAY_TRANSIT_INFO) {
                }
            }
        };
        odsayService.requestSubwayTransitInfo("133",  onResultCallbackListener);
    }

    public void SearchCID(Context context, PublicApi.OnSuccessListener onSuccessListener) {

        ODsayService odsayService = ODsayService.init(context, "aA9ke5zmlxhLEwa6zdtrHc1gR4YctbDBTch+0TVOm1g");
        odsayService.setReadTimeout(5000);
        odsayService.setConnectionTimeout(5000);

        OnResultCallbackListener onResultCallbackListener = new OnResultCallbackListener() {
            @Override
            public void onSuccess(ODsayData odsayData, API api) {
                try {
                    if (api == API.SEARCH_CID) {
                        String CID = odsayData.getJson().getJSONObject("result").getJSONArray("CID").getString(0);
                        onSuccessListener.onRequestSuccess(CID);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int i, String s, API api) {
                if (api == API.SEARCH_CID) {
                }
            }
        };
        odsayService.requestSearchCID("서울",  onResultCallbackListener);
    }
}
