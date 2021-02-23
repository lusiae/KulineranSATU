package com.example.kulineran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class Info_makanan extends AppCompatActivity {
    private TextView txtnama, txtdeskripsi;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_makanan);

        String url = "https://kulineranmadiun.000webhostapp.com/API/pecel.php";

        txtnama = (TextView)findViewById(R.id.txtnama);
        txtdeskripsi = (TextView)findViewById(R.id.txtdeskripsi);

        requestQueue = Volley.newRequestQueue(Info_makanan.this);

        list_data = new ArrayList<HashMap<String, String>>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String s = response;
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray a = jsonObject.getJSONArray("pecel");
                    for (int i = 0; i < a.length(); i ++){
                        JSONObject c = a.getJSONObject(i);
//                        HashMap<String, String> map  = new HashMap<String, String>();
//                        map.put("nama", json.getString("nama"));
//                        map.put("deskripsi", json.getString("deskripsi"));

                        String nama = c.getString("nama");
                        String deskripsi = c.getString("deskripsi");

                        txtnama.setText(nama);
                        txtdeskripsi.setText(deskripsi);
                        Toast.makeText(Info_makanan.this, nama,
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Info_makanan.this, error.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);
    }
}