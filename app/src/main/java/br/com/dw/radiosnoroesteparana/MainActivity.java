package br.com.dw.radiosnoroesteparana;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
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
import com.google.android.gms.ads.AdSize;
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

    //Intersticial-1
    private static final String idanuncio = "ca-app-pub-3925364440483118/6149673869" ;//"ca-app-pub-3940256099942544/1033173712";
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
        //adView.setAdSize(AdSize.SMART_BANNER);
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
            radio.setCidadeuf("Loanda - PR");

            radio.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 100%; height: 37px\">\n" +
                    "<source src=\"http://radio.maxicast.com.br:8179/;\">\n" +
                    "<source src=\"http://radio.maxicast.com.br:8179/;\">\n" +
                    "<source src=\"http://radio.maxicast.com.br:8179/;.m3u\">\n" +
                    "<source src=\"http://radio.maxicast.com.br:8179/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            //radio.setEndereco("http://radio.maxicast.com.br:8179/;.m3u");
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
            radio3.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio2.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio4.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio5.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio6.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio7.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio8.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio9.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio10.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio11.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio12.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio13.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio14.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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
            radio15.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
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

            //
            final Radio radio16 = new Radio();
            radio16.setId(16);
            radio16.setNome("Rádio Cidade FM - 105.9");
            radio16.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://rvn01.estudioproarte.com.br:9116/stream\">\n" +
                    "<source src=\"http://rvn01.estudioproarte.com.br:9116/stream.m3u\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio16.setCidadeuf("Alto Paraná - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://tudoradio.com/img/imagecache/90x90_5ae38dbb278ba.jpeg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio16.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio17 = new Radio();
            radio17.setId(17);
            radio17.setNome("Rádio São Carlos FM - 105.9");
            radio17.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"https://servidor33-5.brlogic.com:8176/live\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio17.setCidadeuf("São Carlos do Ivaí - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio14535_1439401462.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio17.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio18 = new Radio();
            radio18.setId(18);
            radio18.setNome("Rádio Guairacá AM - 1270");
            radio18.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://hts03.kshost.com.br:8196/live\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio18.setCidadeuf("Mandaguari - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://tudoradio.com/img/imagecache/90x90_radio_guairaca.gif");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio18.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio19 = new Radio();
            radio19.setId(19);
            radio19.setNome("Rádio Inajá FM - 87.9");
            radio19.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://hd.matutos.com.br:9290/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio19.setCidadeuf("Inajá - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://scontent.fumu1-1.fna.fbcdn.net/v/t1.0-1/p50x50/71833560_2406137306172266_3264810155874713600_n.jpg?_nc_cat=103&_nc_ohc=PwYyeSxQ4zUAQmxgvQySrc4bGmVVGYUK49FPeeiLF9JQ2zameIrvBR7Cg&_nc_ht=scontent.fumu1-1.fna&oh=0672547b2c5d7d3161d65960f3b3c40d&oe=5E78A0BA");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio19.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio20 = new Radio();
            radio20.setId(20);
            radio20.setNome("Rádio Muleka FM - 88.7");
            radio20.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://whd1.webradios.com.br:8522/8522\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio20.setCidadeuf("Paraíso do Norte - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio32650_1565180116.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio20.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio21 = new Radio();
            radio21.setId(21);
            radio21.setNome("Rádio City FM - 104.9");
            radio21.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://streaming19.hstbr.net:8218/live\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio21.setCidadeuf("Paranacity - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio35191_1550500291.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio21.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio22 = new Radio();
            radio22.setId(22);
            radio22.setNome("Rádio Chrystian FM - 97.3");
            radio22.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://sv11.hdradios.net:7190/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio22.setCidadeuf("Alto Piquiri - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://tudoradio.com/img/imagecache/90x90_radio_chrystianfm973.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio22.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio23 = new Radio();
            radio23.setId(23);
            radio23.setNome("Rádio Liberdade  FM - 87.9");
            radio23.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8527/stream\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio23.setCidadeuf("Altônia - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://img.radios.com.br/radio/lg/radio13600_1439401453.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio23.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio24 = new Radio();
            radio24.setId(24);
            radio24.setNome("Rádio Difusora Regional AM - 590");
            radio24.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.com.br:1935/difusoraregional/aovivo/playlist.m3u8\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio24.setCidadeuf("Cruzeiro do Oeste - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("http://www.difusoraregional.com.br/conteudo/emp2/140/arquivos/logodifusora.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio24.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio25 = new Radio();
            radio25.setId(25);
            radio25.setNome("Rádio Carol FM - 87.9");
            radio25.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://stm6.painelvox.com:6712/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio25.setCidadeuf("Francisco Alves - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("http://pbr.srvsite.com/arquivos/6579/cabecalho-6579-20190314005115.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio25.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio26 = new Radio();
            radio26.setId(26);
            radio26.setNome("Rádio Abdallah FM - 104.1");
            radio26.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://server3.webradios.com.br:9338/9338\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio26.setCidadeuf("Iporã - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://tudoradio.com/img/imagecache/90x90_radio_abdallhafm.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio26.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio27 = new Radio();
            radio27.setId(27);
            radio27.setNome("Rádio Cultura FM - 101.7");
            radio27.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://rvn01.estudioproarte.com.br:9586/;stream/1\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio27.setCidadeuf("Iporã - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://www.cxradio.com.br/img/Radio/Logo/1fef73e2d919f49f23a4fb8dda61f5a3.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio27.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio28 = new Radio();
            radio28.setId(28);
            radio28.setNome("Rádio Ilha FM - 107.1");
            radio28.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://c1.fabricahost.com.br:8003/live\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio28.setCidadeuf("Umuarama - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://socialradio.com.br/storage/9bKxkOCQcc7NM4WZ4tCp2rNN5HPkOHyju6UnSWEb.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio28.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio29 = new Radio();
            radio29.setId(29);
            radio29.setNome("Rádio Inconfidência AM - 840");
            radio29.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://caikron.com.br:1935/rcr_inconfidencia/inconfidencia.stream/playlist.m3u8\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio29.setCidadeuf("Umuarama - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("http://www.radioinconfidenciaam.com.br/userfiles/empresas/eb76deef4e2ad3d859ceb13bd5b55fdb.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio29.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio30 = new Radio();
            radio30.setId(30);
            radio30.setNome("Rádio Ilustrada FM - 102.3");
            radio30.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://controleflash.omegasistemas.net:8656/;stream.mp3\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio30.setCidadeuf("Umuarama - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://tudoradio.com/img/imagecache/90x90_radio_ilustradafm1023.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio30.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio31 = new Radio();
            radio31.setId(31);
            radio31.setNome("Rádio Bianca FM - 94.5");
            radio31.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://65.182.104.113:10110/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio31.setCidadeuf("Umuarama - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://tudoradio.com/img/imagecache/90x90_5b203e6cc7996.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio31.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio32 = new Radio();
            radio32.setId(32);
            radio32.setNome("Rádio Aline FM - 93.7");
            radio32.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://65.182.104.113:10140/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio32.setCidadeuf("Umuarama - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://tudoradio.com/img/imagecache/90x90_5b96eba31c03e.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio32.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio33 = new Radio();
            radio33.setId(33);
            radio33.setNome("Rádio RUP FM - 107.7");
            radio33.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"https://caikron.com.br:8082/unicesumar/rup/playlist.m3u8\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio33.setCidadeuf("Umuarama - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://static.wixstatic.com/media/0e6116_16d447967dc2435b9c5b7a741e455cda~mv2_d_2835_2835_s_4_2.png/v1/crop/x_0,y_107,w_2835,h_2621/fill/w_45,h_41,al_c,q_80,usm_0.66_1.00_0.01/LOGO%20RUP.webp");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio33.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio34 = new Radio();
            radio34.setId(34);
            radio34.setNome("Rádio Olga FM - 102.9");
            radio34.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://143.208.11.104:8202/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio34.setCidadeuf("Cianorte - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://tudoradio.com/img/imagecache/90x90_radio_olgafm1029.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio34.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio35 = new Radio();
            radio35.setId(35);
            radio35.setNome("Rádio Cia FM - 95.9");
            radio35.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://142.54.190.6:9906/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio35.setCidadeuf("Cianorte - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("https://tudoradio.com/img/imagecache/90x90_5c4f085f8a012.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio35.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio36 = new Radio();
            radio36.setId(36);
            radio36.setNome("Rádio Studio Nayty Web");
            radio36.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://stm24.srvaudio.com.br:10074/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio36.setCidadeuf("Rondon - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("http://ps.srvsite.com/arquivos/5218/cabecalho-5218-20191022084809.jpg");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio36.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio37 = new Radio();
            radio37.setId(37);
            radio37.setNome("Rádio R");
            radio37.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://173.236.30.162:8467/;\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio37.setCidadeuf("Rondon - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("http://www.radior.com.br/2017/wp-content/uploads/2018/01/herald_logo@2x.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio37.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio38 = new Radio();
            radio38.setId(38);
            radio38.setNome("Rádio Bota FM - 87.9");
            radio38.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://server01.stmsg.com.br:7150/stream\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio38.setCidadeuf("São Tomé - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("http://www.radiobotafm.com.br/admin/assets/img/logo.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio38.setImagem(img);
                    } catch (IOException e) {
                    }
                }
            }.start();
            //

            //
            final Radio radio39 = new Radio();
            radio39.setId(39);
            radio39.setNome("Rádio Tapejara FM - 101.5");
            radio39.setEndereco("<audio controls=\"\" autoplay=\"\" loop=\"\" style=\"width: 99%; height: 37px\">\n" +
                    "<source src=\"http://177.92.186.22:8000/stream.aac\">\n" +
                    "Seu navegador não suporta o elemento audio\n" +
                    "</audio>");
            radio39.setCidadeuf("Tapejara - PR");

            new Thread() {
                public void run() {
                    Bitmap img = null;

                    try {
                        URL url = new URL("http://www.radiotapejara.com.br/images/logo.png");
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                        InputStream input = conexao.getInputStream();
                        img = BitmapFactory.decodeStream(input);
                        radio39.setImagem(img);
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
            radios.add(radio16);
            radios.add(radio17);
            radios.add(radio18);
            radios.add(radio19);
            radios.add(radio20);
            radios.add(radio21);
            radios.add(radio22);
            radios.add(radio23);
            radios.add(radio24);
            radios.add(radio25);
            radios.add(radio26);
            radios.add(radio27);
            radios.add(radio28);
            radios.add(radio29);
            radios.add(radio30);
            radios.add(radio31);
            radios.add(radio32);
            radios.add(radio33);
            radios.add(radio34);
            radios.add(radio35);
            radios.add(radio36);
            radios.add(radio37);
            radios.add(radio38);
            radios.add(radio39);

            adp_radio = new ADP_Radio(this,radios);
            listView.setAdapter(adp_radio);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Radio radio = (Radio) adapterView.getItemAtPosition(i);
        Toast.makeText(this, "Rádio: "+radio.getNome(), Toast.LENGTH_SHORT).show();

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //webSettings.setUseWideViewPort(true);
        //webSettings.setAllowContentAccess(true);
        //webSettings.setEnableSmoothTransition(true);
        //webSettings.setLoadsImagesAutomatically(true);
        //webSettings.setLoadWithOverviewMode(true);
        //webSettings.setSupportZoom(true);
        //webSettings.setPluginState(WebSettings.PluginState.ON);


        String caminho = radio.getEndereco();
        webView.loadData(caminho,"text/html",null);
        //webView.loadUrl(caminho);
        if(count == 5) {
            showInterstitial();
        }else{
            count++;
        }

    }

    private void showInterstitial() {
        // Show the ad if it's ready. Otherwise toast and restart the game.
        if (!interstitialAd.isLoading() && !interstitialAd.isLoaded()) {
            /*AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();*/

            AdRequest adRequest = new AdRequest.Builder().build();
            interstitialAd.loadAd(adRequest);
        }
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
            count = 0;
        }
    }
}
