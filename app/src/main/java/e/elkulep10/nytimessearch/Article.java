package e.elkulep10.nytimessearch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Article implements Serializable {

    public String getWebUrl() {
        return webUrl;
    }
    public String getHeadline() {
        return headline;
    }
    public String getThumNail() {
        return thumNail;
    }

    String webUrl;
    String headline;
    String thumNail;

    public Article (JSONObject jsonObject){

        try{
            this.webUrl = jsonObject.getString("web_url");
            this.headline = jsonObject.getJSONObject("headline").getString("main");

            JSONArray multimedia = jsonObject.getJSONArray("multimedia");

            if(multimedia.length()>0){
                JSONObject multimediaJson = multimedia.getJSONObject(0);
                this.thumNail = "http://www.nytimes.com/" + multimediaJson.getString("url");
            }else {
                this.thumNail = "";
            }

        }catch (JSONException e){
            e.printStackTrace();

        }
    }

    public static ArrayList<Article> fromJSONArray (JSONArray array){

        ArrayList<Article> result = new ArrayList<>();
        for(int x = 0; x < array.length(); x++){
            try{
                result.add(new Article(array.getJSONObject(x)));
            }catch(JSONException e){
                e.printStackTrace();
            }
        }
        return result;
    }

}
