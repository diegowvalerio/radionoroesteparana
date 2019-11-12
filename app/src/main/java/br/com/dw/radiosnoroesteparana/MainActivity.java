package br.com.dw.radiosnoroesteparana;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Handler handler = new Handler();
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

            final Radio radio = new Radio();
            radio.setId(1);
            radio.setNome("Cidade FM - 93.1");
            radio.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://radio.maxicast.com.br:8179/;\">\n" +
                    "<source src=\"http://radio.maxicast.com.br:8179/;\">\n" +
                    "<source src=\"http://radio.maxicast.com.br:8179/;.m3u\">\n" +
                    "<source src=\"http://radio.maxicast.com.br:8179/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio.setCidadeuf("Loanda - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("http://www.cidadefmloanda.com.br/logo2017.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();

            final Radio radio3 = new Radio();
            radio3.setId(3);
            radio3.setNome("Guadalupe FM - 102.1");
            radio3.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8359/;\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8359/;\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8359/;.m3u\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8359/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio3.setCidadeuf("Loanda - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://tudoradio.com/img/imagecache/90x90_radio_guadalupefm1021.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio3.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();

            final Radio radio2 = new Radio();
            radio2.setId(2);
            radio2.setNome("Ivaí FM - 101.5");
            radio2.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8377/;\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8377/;\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8377/;.m3u\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8377/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio2.setCidadeuf("Santa Isabel do Ivaí - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://3.bp.blogspot.com/-bUS8FlJ38wg/VYGhB3utPFI/AAAAAAAAcOk/fxTND8meRCs/s1600/RADIO_IVAI_FM_SANTA_ISABEL_DO_IVAI_PR.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio2.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();

            final Radio radio4 = new Radio();
            radio4.setId(4);
            radio4.setNome("Castelo FM - 104.9");
            radio4.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"https://server3.webradios.com.br:19352/9352\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio4.setCidadeuf("Santa Cruz de Monte Castelo - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio11371_1439401388.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio4.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();

            //
            final Radio radio5 = new Radio();
            radio5.setId(5);
            radio5.setNome("Rádio Pontal FM - 101.1");
            radio5.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://216.245.194.246:8322/live\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio5.setCidadeuf("Nova Londrina - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio27202_1539172397.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio5.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio6 = new Radio();
            radio6.setId(6);
            radio6.setNome("Rádio Gospel Baluarte");
            radio6.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"https://servidor40-2.brlogic.com:8188/live\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio6.setCidadeuf("Nova Londrina - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/md/radio111996_1561122688.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio6.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio7 = new Radio();
            radio7.setId(7);
            radio7.setNome("Rádio Caiuá FM - 103.5");
            radio7.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"https://player.livemus.com.br/ssl.php?p=27638&s=live8\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio7.setCidadeuf("Paranavaí - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://tudoradio.com/img/imagecache/90x90_5c4b5c0f3bff3.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio7.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio8 = new Radio();
            radio8.setId(8);
            radio8.setNome("Rádio Cultura FM - 93.7");
            radio8.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8563/;stream.mp3\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio8.setCidadeuf("Paranavaí - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio12456_1514048422.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio8.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio9 = new Radio();
            radio9.setId(9);
            radio9.setNome("Rádio Mais Hits FM - 100.7");
            radio9.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://cast62.sitehosting.com.br:8171/live\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio9.setCidadeuf("Paranavaí - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio19801_1532005950.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio9.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio10 = new Radio();
            radio10.setId(10);
            radio10.setNome("Rádio Nova FM - 87.9");
            radio10.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://rvn01.estudioproarte.com.br:9998/stream\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio10.setCidadeuf("Paranavaí - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio55411_1521457629.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio10.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio11 = new Radio();
            radio11.setId(11);
            radio11.setNome("Rádio RDR FM - 101.9");
            radio11.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://ice2.fabricahost.com.br:8028/live\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio11.setCidadeuf("Paranavaí - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio13188_1483962307.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio11.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio12 = new Radio();
            radio12.setId(12);
            radio12.setNome("Rádio Skala FM - 87.9");
            radio12.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://node-04.zeno.fm/yzwyz20a8zquv?rj-ttl=5&rj-tok=AAABbl0xvYoAGAiZD2V50__0Jw\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio12.setCidadeuf("Paranavaí - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio17293_1504957443.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio12.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio13 = new Radio();
            radio13.setId(13);
            radio13.setNome("Rádio Arena Sertaneja");
            radio13.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://radiocentova.conectastm.com:8357//;stream.mp3\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio13.setCidadeuf("Paranavaí - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio37605_1466706057.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio13.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio14 = new Radio();
            radio14.setId(14);
            radio14.setNome("Rádio Baú do TS");
            radio14.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://server01.ouvir.radio.br:8050/stream\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio14.setCidadeuf("Paranavaí - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio38654_1474036985.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio14.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio15 = new Radio();
            radio15.setId(15);
            radio15.setNome("Rádio Estação Saudade");
            radio15.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px; background: #f1f3f4\">\n" +
                    "<source src=\"http://radiocentova.conectastm.com:8137/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio15.setCidadeuf("Paranavaí - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio73737_1557420302.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio15.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            radios.add(radio);
            radios.add(radio3);
            radios.add(radio2);
            radios.add(radio4);
            radios.add(radio5);
            radios.add(radio6);
            radios.add(radio7);
            radios.add(radio8);
            radios.add(radio9);
            radios.add(radio10);
            radios.add(radio11);
            radios.add(radio12);
            radios.add(radio13);
            radios.add(radio14);
            radios.add(radio15);

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
