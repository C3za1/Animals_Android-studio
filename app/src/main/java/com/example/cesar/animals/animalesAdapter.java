package com.example.cesar.animals;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by cesar on 17/04/2017.
 */
//extiende del mismo  va a ser te tipo animales
public class animalesAdapter extends ArrayAdapter<animales>
{
    //definimos el contexto
    Context mycontexto;
    //Mi ID de recursos de presentación
    int mylayoutResourceID;
    //creamos un array  donde almacenara
    animales mydatos[]=null;

    //definir el constructor y la vista
    //recive un contexto, id, y lo que bamos a llenar
    public animalesAdapter(Context context, int layoutResourceID, animales[]datos)
    {
        super(context, layoutResourceID, datos);

        this.mycontexto=context;
        this.mylayoutResourceID=layoutResourceID;
        this.mydatos=datos;

    }
   //regresar una vista  ecibimos la posicion, vista y el grupo al que pertenece
    public View getView(int posicion, View convertView, ViewGroup parent)
    {
        //lee y toma la lista que tomamos
        View row=convertView;
        //tenemos definido nuestro holder
        animalesHolder Holder = null;

        //row es fila
        if (row==null)
        {
            //para ir colocando las cosas de lo que queremos llenar
            LayoutInflater Inflater =((Activity)mycontexto).getLayoutInflater();
            row=Inflater.inflate(mylayoutResourceID, parent,false);

            Holder = new animalesHolder();
            //tiene definido la imagen y el texto
            Holder.imagen = (ImageView)row.findViewById(R.id.image);
            Holder.textView=(TextView)row.findViewById(R.id.text);
            //acer una etiqueta(tag)
            row.setTag(Holder);
        }

        else
        {
            Holder=(animalesHolder)row.getTag();
        }
        //son los elementos que estamos asignando de animales
        animales animales=mydatos[posicion];
        Holder.textView.setText(animales.titulo);
        Holder.imagen.setImageResource(animales.icono);

        //retorna nuestra fila
        return row;
    }
//conviene crear static class para mantener los datos para que no se pierdan
    static class animalesHolder
    {
        //elementos que tiene nuestros items para comunicarnos entre ellos
        ImageView imagen;
        TextView textView;
    }

}
