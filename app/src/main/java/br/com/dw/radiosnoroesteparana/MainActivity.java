package br.com.dw.radiosnoroesteparana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
        private WebView webView;
        private ListView listView;
        private ADP_Radio adp_radio;

        List<Radio> radios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        listView.setOnItemClickListener(this);

        webView = findViewById(R.id.web1);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        preenchelista();
    }

    private void preenchelista() {
        if (radios.isEmpty()){

            Radio radio = new Radio();
            radio.setId(1);
            radio.setNome("Cidade FM - 93.1");
            radio.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://radio.maxicast.com.br:8179/;\">\n" +
                    "<source src=\"http://radio.maxicast.com.br:8179/;\">\n" +
                    "<source src=\"http://radio.maxicast.com.br:8179/;.m3u\">\n" +
                    "<source src=\"http://radio.maxicast.com.br:8179/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");

            Radio radio2 = new Radio();
            radio2.setId(1);
            radio2.setNome("Ivaí FM - 101.5");
            radio2.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8377/;\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8377/;\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8377/;.m3u\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8377/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");

            radios.add(radio);
            radios.add(radio2);

            adp_radio = new ADP_Radio(this,radios);
            listView.setAdapter(adp_radio);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Radio radio = (Radio) adapterView.getItemAtPosition(i);
        Toast.makeText(this, "Rádio: "+radio.getNome(), Toast.LENGTH_SHORT).show();

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //String imagem = "<img src=\"/https://tudoradio.com//img/imagecache/90x90_ivai.jpg\" alt=\"Ivaí FM\" title=\"Ivaí FM\" align=\"left\" style=\"border:none\">";
        /*String caminho = "<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                "<source src=\"http://controleflash.omegasistemas.net:8377/;\">\n" +
                "<source src=\"http://controleflash.omegasistemas.net:8377/;\">\n" +
                "<source src=\"http://controleflash.omegasistemas.net:8377/;.m3u\">\n" +
                "<source src=\"http://controleflash.omegasistemas.net:8377/;\">\n" +
                "Seu navegador não suporta o elemento audio\n" +
                "</audio>";
*/
        String caminho = radio.getEndereco();
        webView.loadData(caminho,"text/html",null);

    }
}
