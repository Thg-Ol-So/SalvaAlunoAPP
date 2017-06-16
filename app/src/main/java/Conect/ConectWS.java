package Conect;

/**
 * Created by oliveira on 15/06/17.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by oliveira on 11/05/17.
 */

public class ConectWS {


    public static String pegaHTTP(String url)
    {
        HttpURLConnection con = null;
        URL url_caminho;
        String resposta = null;
        try {
            url_caminho = new URL(url);
            con = (HttpURLConnection) url_caminho.openConnection();
            con.setRequestProperty("Accept-Charset", "UTF-8");
            con.setRequestProperty("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
            resposta = readStream(con.getInputStream());


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resposta;
    }
    public static String readStream(InputStream is)
    {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
    public static boolean VerificaConexao(Context contexto){
        ConnectivityManager cm = (ConnectivityManager) contexto.getSystemService(Context.CONNECTIVITY_SERVICE);//Pego a conectividade do contexto o qual o metodo foi chamado
        NetworkInfo netInfo = cm.getActiveNetworkInfo();//Crio o objeto netInf o que recebe as informacoes da NEtwork
        if(netInfo!=null && cm.getActiveNetworkInfo() != null  && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()){
            return true;
        }
        return false;
    }
}
