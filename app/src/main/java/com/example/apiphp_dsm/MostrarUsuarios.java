package com.example.apiphp_dsm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class MostrarUsuarios extends AppCompatActivity {
    ListView listView;
    ArrayList<Users> arrayList = new ArrayList<>();
    ArrayAdapter<Users> arrayAdapter;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_usuarios);

        listView = (ListView) findViewById(R.id.lvUsuarios);
        setTitle("Usuarios ingresados a la BD con PHP");

        mostrarUsuarios("http://192.168.0.14:8080/APIRESTPHP/displayAll.php");

        arrayAdapter = new ArrayAdapter<Users>(MostrarUsuarios.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);





    }

    private void mostrarUsuarios(String URL){

        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                arrayList.clear();
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    String sucess = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("details");

                    if(sucess.equals("1")){
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("id");
                            String nombre = object.getString("name");
                            String edad = object.getString("age");
                            String telefono = object.getString("mobile");
                            String email = object.getString("email");
                            Users usuarios = new Users(id,nombre,edad,telefono,email);
                            arrayList.add(usuarios);
                            //arrayAdapter.notifyDataSetChanged();
                        }
                    }
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MostrarUsuarios.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
                }
            }

      /*  JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        String ID = jsonObject.getString("id");
                        String nombre = jsonObject.getString("name");
                        String edad = jsonObject.getString("age");
                        String telefono = jsonObject.getString("mobile");
                        String email = jsonObject.getString("email");
                        arrayList.add(ID + "---" + nombre + "---" + edad + "---" + telefono + "---" + email);

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    arrayAdapter = new ArrayAdapter<>(MostrarUsuarios.this, android.R.layout.simple_list_item_1, arrayList);
                    listView.setAdapter(arrayAdapter);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(),Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);*/
