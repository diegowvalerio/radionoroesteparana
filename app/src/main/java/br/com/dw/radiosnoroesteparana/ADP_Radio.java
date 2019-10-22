package br.com.dw.radiosnoroesteparana;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

            Radio radio = radios.get(position);
            nome.setText(radio.getNome());

            return viewLinha;
        }
    }
