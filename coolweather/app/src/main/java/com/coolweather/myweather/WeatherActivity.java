package com.coolweather.myweather;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;



import android.content.Intent;

import android.content.SharedPreferences;

import android.graphics.Color;

import android.os.Build;

import android.os.Bundle;

import android.preference.PreferenceManager;

import android.view.LayoutInflater;

import android.view.View;

import android.widget.AdapterView;

import android.widget.ArrayAdapter;

import android.widget.Button;

import android.widget.ImageView;

import android.widget.LinearLayout;

import android.widget.ScrollView;

import android.widget.Spinner;

import android.widget.TextView;

import android.widget.Toast;



import com.bumptech.glide.Glide;

import com.coolweather.myweather.gson.Forecast;

import com.coolweather.myweather.gson.Weather;

import com.coolweather.myweather.util.HttpUtil;

import com.coolweather.myweather.util.Utility;



import org.jetbrains.annotations.NotNull;


import java.io.IOException;


import okhttp3.Call;

import okhttp3.Callback;

import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;

    private Button navButton;

    public SwipeRefreshLayout swipeRefresh;

    private ScrollView weatherLayout;

    private TextView titleCity;

    private TextView titleUpdateTime;

    private TextView degreeText;

    private TextView weatherInfoText;

    private LinearLayout forecastLayout;

    private TextView aqiText;

    private TextView pm25Text;

    private TextView comfortText;

    private TextView carWashText;

    private TextView sportText;

    private ImageView bingPicImg;

    private Spinner spinner;

    private Button addw;

    private Button exchange;

    String weatherString;   //字符串天气

    boolean flag = false;

    String n;



    /**

     * 先是去获取一些控件的实例，然后会尝试从本地缓存中读取数据。

     * 那么第一次肯定是没有缓存的，因此就会从Intent中取出天气id，

     * 并调用requestWeather()方法来从服务器请求天气数据

     * 注意，请求数据的时候先将ScrollView进行隐藏，不然空数据的界面看上去会很奇怪

     * @param savedInstanceState

     */



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT >= 21){

            View decorView = getWindow().getDecorView();;

            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |

                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }
       //将天气的布局加载到屏幕上
        setContentView(R.layout.activity_weather);

        //初始化各控件
        weatherLayout = (ScrollView)findViewById(R.id.weather_layout);

        titleCity = (TextView)findViewById(R.id.title_city);

        titleUpdateTime=(TextView)findViewById(R.id.title_update_time);

        degreeText = (TextView)findViewById(R.id.degree_text);

        weatherInfoText = (TextView)findViewById(R.id.weather_info_text);

        forecastLayout = (LinearLayout)findViewById(R.id.forecast_layout);

        aqiText = (TextView)findViewById(R.id.aqi_text);

        pm25Text = (TextView)findViewById(R.id.pm25_text);

        comfortText = (TextView)findViewById(R.id.comfort_text);

        carWashText = (TextView)findViewById(R.id.car_wash_text);

        sportText = (TextView)findViewById(R.id.sport_text);

        bingPicImg = (ImageView)findViewById(R.id.bing_pic_img);

        swipeRefresh = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh);



        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        //主页按钮
        navButton=(Button)findViewById(R.id.nav_button);

        spinner = (Spinner)findViewById(R.id.spinner);

        addw = (Button)findViewById(R.id.addw);

        exchange=(Button)findViewById(R.id.exchange);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        weatherString = prefs.getString("weather",null);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        String s = prefs.getString("countyName","北京,");

        String sw = prefs.getString("weatherId","CN101010100.");

        String[] str = new String[0];

        String[] swr = new String[0];

        if(s !=null){

            str=s.split("\\,");

            swr=s.split("\\.");

        }

        adapter1.addAll(str);

        spinner.setAdapter(adapter1);



        final String[] weatherId = new String[1];

        String countyName = "";

        if(weatherString != null){

            //有缓存时直接解析天气数据

            Weather weather = Utility.handleWeatherResponse(weatherString);

            weatherId[0] =weather.basic.weatherId;

            countyName = weather.basic.cityName;

            showWeatherInfo(weather);

        }else {

            //无缓存时去服务器查询天气

            weatherId[0] = getIntent().getStringExtra("weather_id");

            weatherLayout.setVisibility(View.VISIBLE);

            requestWeather(weatherId[0]);

        }

        String finalWeatherId = weatherId[0];

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override

            public void onRefresh() {

                flag = false;

                requestWeather(finalWeatherId);

            }

        });



        String bingPic =prefs.getString("bing_pic",null);

        if(bingPic != null){

            Glide.with(this).load(bingPic).into(bingPicImg);

        }else {

            loadBingPic();

        }



        navButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                flag = false;

                drawerLayout.openDrawer(GravityCompat.START);

            }

        });

        String finalcountyName = countyName;

        addw.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

//               SharedPreferences.Editor editor=PreferenceManager.
//
//                        getDefaultSharedPreferences(WeatherActivity.this).edit();
//
//                editor.putString("weatherId","CN101010100.");
//
//                editor.putString("countyName","北京,");
//
//                editor.apply();

                         String s1 = s + (finalcountyName + ",");

               String s2 = sw + (finalWeatherId+".");

               SharedPreferences.Editor editor = PreferenceManager.
                       getDefaultSharedPreferences(WeatherActivity.this).edit();

               editor.putString("countyName",s1);

               editor.putString("weatherId",s2);

              editor.apply();

              adapter1.add(finalcountyName);



            }

        });



        String[] finalSwr = swr;

        final int[] i = {0};

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                i[0] =position;

            }



            @Override

            public void onNothingSelected(AdapterView<?> parent) {



            }

        });



        String[] finalStr = str;

        exchange.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                n = finalStr[i[0]];

                flag=true;

                requestWeather(weatherId[0]);

            }

        });



    }



    /**

     * 根据天气id请求城市天气信息

     *

     * 先是使用参数中传入的天气id和我们之前申请好的API Key拼装出一个接口地址，

     * 接着调用HttpUtil.sendOkHttpRequest()来向该地址发出请求，服务器会将相应城市的天气信息以JSO格式返回。

     * 然后我们在onResponse()回调中先调用Utility.handleWeatherResopnse()方法将返回的JSON数据转换成Weather对象，

     * 再将当前线程切换到主线程。然后进行判断，如果服务器返回的status状态是ok，就说明请求天气成功了，

     * 此时将返回的数据缓存到SharedPreferences当中，并调用showWeatherInfo()方法来进行内容显示。

     * @param weatherId

     */



    public void requestWeather(final String weatherId) {

        String weatherUrl="http://guolin.tech/api/weather?cityid="+

                weatherId+"&key=a3a928f078314931b6d212e75f4a1dfb";

        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {

            @Override

            public void onFailure(@NotNull Call call, @NotNull IOException e) {

                e.printStackTrace();

                runOnUiThread(new Runnable() {

                    @Override

                    public void run() {

                        Toast.makeText(WeatherActivity.this,"获取天气信息失败",

                                Toast.LENGTH_SHORT).show();

                        swipeRefresh.setRefreshing(false);

                    }

                });

            }



            @Override

            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                final String responseText = response.body().string();

                final Weather weather = Utility.handleWeatherResponse(responseText);

                runOnUiThread(new Runnable() {

                    @Override

                    public void run() {

                        if (weather != null && "ok".equals(weather.status)){

                            SharedPreferences.Editor editor=PreferenceManager.

                                    getDefaultSharedPreferences(WeatherActivity.this).edit();

                            editor.putString("weather",responseText);

                            editor.apply();

                            showWeatherInfo(weather);

                        }else {

                            Toast.makeText(WeatherActivity.this,"获取天气信息失败",

                                    Toast.LENGTH_SHORT).show();

                        }

                        swipeRefresh.setRefreshing(false);

                    }

                });

            }

        });

        loadBingPic();

    }



    /**

     * 加载必应每日一图

     */

    private void loadBingPic(){

        String requestBingPic = "http://guolin.tech/api/bing_pic";

        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {

            @Override

            public void onFailure(@NotNull Call call, @NotNull IOException e) {

                e.printStackTrace();

            }



            @Override

            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

                final String bingPic = response.body().string();

                SharedPreferences.Editor editor = PreferenceManager.

                        getDefaultSharedPreferences(WeatherActivity.this).edit();

                editor.putString("bing_pic",bingPic);

                editor.apply();

                runOnUiThread(new Runnable() {

                    @Override

                    public void run() {

                        Glide.with(WeatherActivity.this).load(bingPic).into(bingPicImg);

                    }

                });

            }

        });

    }



    /**

     * 处理并展示Weather实体类中的数据

     *

     * 从Weather对象中获取数据，然后显示到相应的控件上。

     * 在未来几天天气预报的布局使用了for循环来处理每天的天气信息，在循环中动态加载forecast_item.xml布局并设置相应数据

     * 然后添加到父布局当中。设置完所有数据之后，记得要将ScrollView重新变成可见。

     * @param weather

     */

    private void showWeatherInfo(Weather weather) {

        String cityName=weather.basic.cityName;

        if(flag==true){

            cityName=n;

        }

        String updateTime=weather.basic.update.updateTime.split(" ")[1];

        String degree = weather.now.temperature+"°C";

        String weatherInfo =weather.now.more.info;

        titleCity.setText(cityName);

        titleUpdateTime.setText(updateTime);

        degreeText.setText(degree);

        weatherInfoText.setText(weatherInfo);

        forecastLayout.removeAllViews();

        for(Forecast forecast:weather.forecastList){

            View view = LayoutInflater.from(this).inflate(R.layout.forecast_item,forecastLayout,

                    false);

            TextView dateText = (TextView)view.findViewById(R.id.date_text);

            TextView infoText = (TextView)view.findViewById(R.id.info_text);

            TextView maxText = (TextView)view.findViewById(R.id.max_text);

            TextView minText = (TextView)view.findViewById(R.id.min_text);

            dateText.setText(forecast.date);

            infoText.setText(forecast.more.info);

            maxText.setText(forecast.temperature.max);

            minText.setText(forecast.temperature.min);

            forecastLayout.addView(view);

        }



        if (weather.aqi != null){

            aqiText.setText(weather.aqi.city.aqi);

            pm25Text.setText(weather.aqi.city.pm25);

        }

        String comfort = "舒适度："+weather.suggestion.comfort.info;

        String carWash = "洗车指数："+weather.suggestion.carWash.info;

        String sport = "运动建议："+weather.suggestion.sport.info;

        comfortText.setText(comfort);

        carWashText.setText(carWash);

        sportText.setText(sport);

        weatherLayout.setVisibility(View.VISIBLE);

        Intent intent = new Intent(this,AutoUpdateService.class);

        startService(intent);

    }

}

