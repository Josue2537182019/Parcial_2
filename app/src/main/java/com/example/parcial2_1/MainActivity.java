package com.example.parcial2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    List<Empleado> empleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista= findViewById(R.id.lsvEmpleados);

        empleados= new ArrayList<>();
        empleados.add(new Empleado("Alexander Pierrot", "CEO", "Insures S.O.", R.drawable.lead_photo_1));
        empleados.add(new Empleado("Carlos Lopez", "Asistente", "Hospital Blue", R.drawable.lead_photo_2));
        empleados.add(new Empleado("Sara Bonz", "Directora de marketing", "Electrical Parts ltd", R.drawable.lead_photo_3));
        empleados.add(new Empleado("Liliana Clarence", "Diseñadora de productos", "Creativa App", R.drawable.lead_photo_4));
        empleados.add(new Empleado("Benito Peralta", "Supervisor de ventas", "Neumaticos Press", R.drawable.lead_photo_5));
        empleados.add(new Empleado("Juan Jaramillo", "CEO", "Banco Nacional", R.drawable.lead_photo_6));
        empleados.add(new Empleado("Christian Steps", "CTO", "Cooperativas verde", R.drawable.lead_photo_7));
        empleados.add(new Empleado("Alexa Giraldo", "Lead programmer", "Frutisofy", R.drawable.lead_photo_8));
        empleados.add(new Empleado("linda Murillo", "Directora de marketing", "Seguros Boliver", R.drawable.lead_photo_9));
        empleados.add(new Empleado("Liseth Astrada", "CEO", "Concesionario Motolox", R.drawable.lead_photo_10));
        empleados.add(new Empleado("Josue Flores", "Estudiante", "UTEC", R.drawable.yo));

        EmpleadosAdapter adaptador1 = new EmpleadosAdapter(this, empleados);

        lista.setAdapter(adaptador1);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Detalles.class);
                intent.putExtra("nombre", empleados.get(position).getNombre());
                intent.putExtra("cargo", empleados.get(position).getCargo());
                intent.putExtra("compañia", empleados.get(position).getCompañia());
                intent.putExtra("foto", empleados.get(position).getFoto());
                startActivity(intent);
            }
        });
    }
}
