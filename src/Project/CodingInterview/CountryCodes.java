//package Project.CodingInterview;
//
//
//import com.sun.net.httpserver.HttpPrincipal;
//import netscape.javascript.JSObject;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//class Result  {
//
//    private static final HttpClient httpClient = HttpClient.newHttpClient();
//
//    public static String fetchResponse(String url) throws Exception {
//
//        HttpRequest httpRequest = HttpRequest.newBuilder().
//                uri(URI.create(url)).GET().build();
//
//        HttpResponse<String>  response =   httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//        return response.body();
//
//    }
//    public static String getPhoneNumbers(String country, String phoneNumber) throws Exception {
//        String url = "https://jsonmock.hackerrank.com/api/countries?name=" + country;
//        String response = fetchResponse(url);
//
//
//
//        JSONObject rootObject = new JSONObject(response);
//        JSONArray dataArray = rootObject.getJSONArray("data");
//
//        if (dataArray.isEmpty()) {
//            return "-1";
//        }
//
//        JSONObject countryData = dataArray.getJSONObject(0);
//        JSONArray callingCodes = countryData.getJSONArray("callingCodes");
//
//        if (callingCodes.isEmpty()) {
//            return "-1";
//        }
//
//
//        String callingCode = callingCodes.getString(callingCodes.length() - 1);
//
//
//        return "+" + callingCode + " " +phoneNumber;
//
//
//
//    }
//}
//
//public class CountryCodes {
//}
