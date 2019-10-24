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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private AdView adView;
    private InterstitialAd interstitialAd;

    private WebView webView;
    private ListView listView;
    private ADP_Radio adp_radio;

    List<Radio> radios = new ArrayList<>();

    private static final String idanuncio = "ca-app-pub-3940256099942544/1033173712";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //anuncio1
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });

        adView = findViewById(R.id.ad_view);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);

        //anuncio tela cheia
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(idanuncio);
        //fim anuncio tela cheia
        //fim anuncio

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

        String caminho = radio.getEndereco();
        webView.loadData(caminho,"text/html",null);
        if(count == 5) {
            showInterstitial();
        }else{
            count++;
        }

    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (!interstitialAd.isLoading() && !interstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();

            //AdRequest adRequest = new AdRequest.Builder().build();
            interstitialAd.loadAd(adRequest);
        }
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
            count = 0;
        }
    }
}
