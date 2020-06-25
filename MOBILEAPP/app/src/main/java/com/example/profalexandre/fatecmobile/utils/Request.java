package com.example.profalexandre.fatecmobile.utils;

import android.widget.Toast;

public class Requests{
    private Context context;
    private String url = "http://www.jogodaveia.esy.es/cond_ap/login.php";
    private AsyncHttpClient client;
    private RequestParams params;
    private DB db;
    private static String totalAp="0";
    private static String totalCond="0";
    private static String totalCondAp="0";
    private static List<Condomino> condList;
    private static List<Apartamento> apList;
    private Apartamento[] apVetor;
    private static List<CondAp> condApList;

    public static String getTotalAp() {
        return totalAp;
    }

    public static void setTotalAp(String totalAp) {
        Requests.totalAp = totalAp;
    }

    public static void setTotalCond(String totalCond) {
        Requests.totalCond = totalCond;
    }

    public static void setTotalCondAp(String totalCondAp) {
        Requests.totalCondAp = totalCondAp;
    }

    public static String getTotalCond() {
        return totalCond;
    }

    public static String getTotalCondAp() {
        return totalCondAp;
    }

    public static List<Condomino> getCondList() {
        return condList;
    }

    public static void setCondList(List<Condomino> condList) {
        Requests.condList = condList;
    }

    public static List<Apartamento> getApList() {
        return apList;
    }

    public static void setApList(List<Apartamento> apList) {
        Requests.apList = apList;
    }

    public static List<CondAp> getCondApList() {
        return condApList;
    }

    public static void setCondApList(List<CondAp> condApList) {
        Requests.condApList = condApList;
    }

    public Requests(){

    }



    public void setUrl(String url){
        this.url = url;
    }

    public Requests(Context c){
        context = c;
        client = new AsyncHttpClient();
        params = new RequestParams();
        int DEFAULT_TIMEOUT = 120 * 1000;
        client.setTimeout(DEFAULT_TIMEOUT);
        db = new DB(c);

    }

    public void Login(String login, String senha) {
        params.put("action","validaLogin");
        params.put("login",login);
        params.put("senha",senha);
        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                if(response.equals("1")){
                    db.setLog(1);
                    if (context instanceof Activity) {
                        ((Activity) context).finish();
                    }
                    Intent intent = new Intent(context, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
                else{
                    Toast.makeText(context.getApplicationContext(), "Login inválido!!", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }


        });
    }

    public void selectTotalAp(){
        params.put("action","total");
        client.post("http://www.jogodaveia.esy.es/cond_ap/ap.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                Requests.setTotalAp(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });



    }

    public void selectTotalCond(){
        params.put("action","total");
        client.post("http://www.jogodaveia.esy.es/cond_ap/cond.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                Requests.setTotalCond(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void selectTotalCondAp(){
        params.put("action","total");
        client.post("http://www.jogodaveia.esy.es/cond_ap/cond_ap.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                Requests.setTotalCondAp(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void selectAllCond(){
        params.put("action", "selectAll");
        client.post("http://www.jogodaveia.esy.es/cond_ap/cond.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                //System.out.println(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void selectAllAp(){
        params.put("action", "selectAll");
        client.post("http://www.jogodaveia.esy.es/cond_ap/ap.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                Gson gson = new Gson();
                //Converte a string para vetor de objts
                apVetor = gson.fromJson(response, Apartamento[].class);
                //Converte o vetor em List e armazena
                Requests.setApList(Arrays.asList(apVetor));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void selectAllCondAp(){
        params.put("action", "selectAll");
        client.post("http://www.jogodaveia.esy.es/cond_ap/cond_ap.php", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                //System.out.println(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}