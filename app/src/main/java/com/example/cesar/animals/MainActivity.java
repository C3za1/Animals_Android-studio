package com.example.cesar.animals;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
    //WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //webView = (WebView) findViewById(R.id.)

        animales animales_datos[]=new animales[]
                {
                        new animales(R.drawable.aguila,"AGUILA Es el nombre dado a las mayores aves depredadoras. Las diversas especies y subespecies de águilas pueden encontrarse en casi cualquier parte del mundo excepto en la Antártida."),
                        new animales(R.drawable.buho,"BUHO es el nombre común de aves de la familia Strigidae, del orden de los estrigiformes o aves rapaces nocturnas"),
                        new animales(R.drawable.cocodrilo,"COCODRILO Son una familia de saurópsidos arcosaurios comúnmente conocidos como cocodrilos"),
                        new animales(R.drawable.tiburon,"TIBURON Son un superorden de condrictios (peces cartilaginosos) conocidos comúnmente con el nombre de tiburones, también llamados escualos."),
                        new animales(R.drawable.oso,"OSO POLAR Es una especie de mamífero carnívoro de la familia de los osos.")
                };

               animalesAdapter adapter=new animalesAdapter(this,R.layout.listview_item_row,animales_datos);


        listView = (ListView) findViewById(R.id.listview);


       listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0 :
                        Intent primero = new Intent(Intent.ACTION_VIEW, Uri.parse("http://proandroid.16mb.com/ImgAndroid/Aguila.html"));
                        startActivity(primero);
                        break;
                    case 1 :
                        Intent seg = new Intent(Intent.ACTION_VIEW, Uri.parse("http://proandroid.16mb.com/ImgAndroid/Buo.html"));
                        startActivity(seg);
                        break;
                    case 2 :
                        Intent tercer = new Intent(Intent.ACTION_VIEW, Uri.parse("http://proandroid.16mb.com/ImgAndroid/cocodrilos.html"));
                        startActivity(tercer);
                        break;
                    case 3 :
                        Intent cuart = new Intent(Intent.ACTION_VIEW, Uri.parse("http://proandroid.16mb.com/ImgAndroid/tiburones.html"));
                        startActivity(cuart);
                        break;
                    case 4 :
                        Intent quinto = new Intent(Intent.ACTION_VIEW, Uri.parse("http://proandroid.16mb.com/ImgAndroid/OsoPolar.html"));
                        startActivity(quinto);

                }
            }
        });
    }
}
