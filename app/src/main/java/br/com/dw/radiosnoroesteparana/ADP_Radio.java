package br.com.dw.radiosnoroesteparana;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ADP_Radio extends BaseAdapter {

        Context contexto;
        List<Radio> radios;

        public ADP_Radio(Context contexto,List<Radio> radios) {
            this.contexto = contexto;
            this.radios = radios;
        }

        @Override
        public int getCount() {
            return radios.size();
        }

        @Override
        public Object getItem(int position) {
            return radios.get(position);
        }

        @Override
        public long getItemId(int position) {
            return radios.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View viewLinha = LayoutInflater.from(contexto).inflate(R.layout.linha_list,parent,false);

            TextView nome = (TextView) viewLinha.findViewById(R.id.nome);
            TextView cidadeuf = viewLinha.findViewById(R.id.cidade);
            ImageView imagem = viewLinha.findViewById(R.id.imagem);

            Radio radio = radios.get(position);
            nome.setText(radio.getNome());
            cidadeuf.setText(radio.getCidadeuf());
            imagem.setImageBitmap(radio.getImagem());


            return viewLinha;
        }
}
