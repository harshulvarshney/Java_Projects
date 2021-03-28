package com.delphix;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author harshul.varshney
 *
 * To test the solution, please run the testForOfficeLocations() unit test.
 */
public class BrightestStarDelphix {

    private List<Location> locations = new ArrayList<>();

    @Before
    public void initTestData() {
        Location boston = new Location("Boston", 42.36, "N", 71.05, "W");
        Location london = new Location("London", 51.51, "N", 0.12, "W");
        Location ncr = new Location("NCR", 28.58, "N", 77.31, "E");
        Location sf = new Location("San Francisco", 37.79, "N", 122.40, "W");
        locations.addAll(Lists.newArrayList(boston, london, ncr, sf));
    }

    @Test
    public void testForOfficeLocations() throws ServiceException {
        String apiUrl = "https://ssd-api.jpl.nasa.gov/fireball.api";
        String startDate = "2017-01-01";
        FireballDao dao = new FireballDaoImpl(apiUrl);
        FireballService service = new FireballServiceImpl(dao);
        BrightestStarDelphix brightestStarDelphix = new BrightestStarDelphix();
        Pair<String, Double> resp = brightestStarDelphix.fireball(service, startDate, locations);
        System.out.println("Brightest was " + resp.getKey() + " with brightness=" + resp.getValue());
        Assert.assertTrue(resp.getKey().equalsIgnoreCase("boston"));
    }

    @Test(expected = ServiceException.class)
    public void testForIncorrectApiLocation() throws ServiceException {
        String apiUrl = "https://ssdxyz-api.jpl.nasa.gov/fireball.api";
        String startDate = "2017-01-01";
        FireballDao dao = new FireballDaoImpl(apiUrl);
        FireballService service = new FireballServiceImpl(dao);
        BrightestStarDelphix brightestStarDelphix = new BrightestStarDelphix();
        brightestStarDelphix.fireball(service, startDate, locations);
    }



    // /* jfjkvkdvm // / //
    public static void main(String[] args) {
        JUnitCore.main("Solution");
        //comment-out below lines
        String apiUrl = "https://ssd-api.jpl.nasa.gov/fireball.api";
        String startDate = "2017-01-01";
        FireballDao dao = new FireballDaoImpl(apiUrl);
        FireballService service = new FireballServiceImpl(dao);
        BrightestStarDelphix brightestStarDelphix = new BrightestStarDelphix();
        brightestStarDelphix.initTestData();
        Pair<String, Double> resp = null;
        try {
            resp = brightestStarDelphix.fireball(service, startDate, brightestStarDelphix.locations);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        System.out.println("Brightest was " + resp.getKey() + " with brightness=" + resp.getValue());

    }

    public Pair<String, Double> fireball(FireballService service, String startDate, List<Location> locations) throws ServiceException {
        return service.getBrightestLocation(startDate, "2021-01-01", locations);
    }

}

enum Direction {

    E,
    W,
    N,
    S;

}

class Location {

    private String name;
    private double latitude;
    private double longitude;
    private Direction latDir;
    private Direction lonDir;

    public Location(String name, double latitude, String latitudeDirection, double longitude, String longitudeDirection) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.latDir = Direction.valueOf(latitudeDirection);
        this.lonDir = Direction.valueOf(longitudeDirection);
    }
    public Location(double latitude, String latitudeDirection, double longitude, String longitudeDirection) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.latDir = Direction.valueOf(latitudeDirection);
        this.lonDir = Direction.valueOf(longitudeDirection);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Direction getLatDir() {
        return latDir;
    }

    public void setLatDir(Direction latDir) {
        this.latDir = latDir;
    }

    public Direction getLonDir() {
        return lonDir;
    }

    public void setLonDir(Direction lonDir) {
        this.lonDir = lonDir;
    }
}

/**
 * DTO class for record fetched from Fireball API
 */
class DataRecord {

    private LocalDate date;
    private Location location;
    private double energy;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }
}

/**
 * returns the brightest location from input locations, after filtering the data fetched from Fireball API
 */
interface FireballService {

    Pair<String, Double> getBrightestLocation(String startDate, String endDate, List<Location> locations) throws ServiceException;

}

class FireballServiceImpl implements FireballService {

    private final FireballDao fireballDao;

    public FireballServiceImpl(FireballDao fireballDao) {
        this.fireballDao = fireballDao;
    }

    @Override
    public Pair<String, Double> getBrightestLocation(String startDate, String endDate, List<Location> locations) throws ServiceException {

        if(StringUtils.isEmpty(endDate))
            endDate = LocalDate.now().format(DateTimeFormatter.ISO_DATE);

        List<DataRecord> records = null;
        try {
            records = fireballDao.getDataInRange(startDate, endDate);
        } catch (PersistanceException e) {
            throw new ServiceException("Failed to fetch records from Fireball API, " + e.getMessage());
        }

        if(records.isEmpty())
            return Pair.of(null, null);

        Double maxOfAll = Double.MIN_VALUE;
        String brightestLocation = null;
        for(Location l: locations) {
            Double maxAtThisLocation = maxBrightnessAtLocation(records, l, 15, 15);
            if(maxAtThisLocation > maxOfAll) {
                maxOfAll = maxAtThisLocation;
                brightestLocation = l.getName();
            }
        }

        return Pair.of(brightestLocation, maxOfAll);
    }

    private Double maxBrightnessAtLocation(List<DataRecord> records, Location l, double min, double max) {

        double maxEnergy = Double.MIN_VALUE;
        double latMin = l.getLatitude() - min;
        double latMax = l.getLatitude() + max;
        double longMin = l.getLongitude() - min;
        double longMax = l.getLongitude() + max;

        for (DataRecord fireball : records) {
            if (fireball.getLocation().getLatDir() == l.getLatDir() && fireball.getLocation().getLonDir() == l.getLonDir()) {
                if (fireball.getLocation().getLatitude() >= latMin && fireball.getLocation().getLatitude() <= latMax
                        && fireball.getLocation().getLongitude() >= longMin && fireball.getLocation().getLongitude() <= longMax) {
                    if (maxEnergy < fireball.getEnergy()) {
                        maxEnergy = fireball.getEnergy();
                    }
                }
            }
        }

        return maxEnergy;
    }
}

/**
 * calls repository to get data within a date range
 */
interface FireballDao {

    List<DataRecord> getDataInRange(String startDate, String endDate) throws PersistanceException;

}

/**
 * Provide implementation for fetching data from Fireball API
 */
class FireballDaoImpl implements FireballDao {

    private final String URL;
    private final HttpClient httpClient;

    public FireballDaoImpl(String url) {
        this.URL = url;
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, managers(), new SecureRandom());
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .sslContext(sslContext)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    private TrustManager[] managers() {
        return new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };
    }

    public static final List<Integer> badRequestCodes = Lists.newArrayList(400, 405);
    public static final List<Integer> serverErrorCodes = Lists.newArrayList(500);
    public static final List<Integer> retryableErrors  = Lists.newArrayList(503);
    public static final List<Integer> successCodes  = Lists.newArrayList(200);

    @Override
    public List<DataRecord> getDataInRange(String startDate, String endDate) throws PersistanceException {
        if(StringUtils.isEmpty(startDate))
            return Collections.emptyList();

        StringBuffer sb = new StringBuffer(URL)
                .append("?")
                .append(FireballConstants.QUERY_DATE_MIN)
                .append(startDate)
                .append("&")
                .append(FireballConstants.QUERY_DATE_MAX)
                .append(endDate)
                .append("&")
                .append(FireballConstants.QUERY_REQUEST_LOCATION)
                .append("true");

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(sb.toString()))
                    .build();

            return prepareData(httpClient.send(request, HttpResponse.BodyHandlers.ofString()));
        }
        catch (IOException | InterruptedException | ParseException ie) {
            //TODO: retry functionality should be implemented here
            throw new PersistanceException("Failed to get response from target API", ie);
        }

    }

    private List<DataRecord> prepareData(HttpResponse httpResponse) throws ParseException, PersistanceException {

        int respCode = httpResponse.statusCode();

        if(successCodes.contains(respCode)) {
            System.out.println("SUCCESS :: got 200 from API");
            return parseResponse(String.valueOf(httpResponse.body()));
        }
        else if (badRequestCodes.contains(respCode)) {
            System.out.println("ERROR :: got " + respCode + " from API");
            throw new IllegalArgumentException(httpResponse.body().toString());
        }
        else if(serverErrorCodes.contains(respCode)) {
            System.out.println("ERROR :: got " + respCode + " from API");
            throw new PersistanceException("Failed to get response from target API | " + httpResponse.body().toString());
        }
        else if (retryableErrors.contains(respCode)) {
            System.out.println("ERROR :: got " + respCode + " from API");
            //TODO: retry functionality should be implemented for such error
            throw new PersistanceException("Failed to get response from target API | " + httpResponse.body().toString());
        } else {
            System.out.println("ERROR :: unidentified response from API");
            return Collections.emptyList();
        }
    }

    private List<DataRecord> parseResponse(String httpResponse) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(httpResponse);

        int count = Integer.parseInt(json.get(FireballConstants.COUNT).toString());

        JSONArray jsonArr = new JSONArray();
        jsonArr.add(json.get(FireballConstants.FIELDS));
        JSONArray jsonFields = (JSONArray) jsonArr.get(0);

        List<String> fields = new ArrayList<>(jsonArr.size());
        for(int i=0; i<jsonFields.size(); i++) {
            fields.add(jsonFields.get(i).toString());
        }
 
        JSONArray array = new JSONArray();
        array.add(json.get(FireballConstants.DATA));

        return getRecords(count, fields, array);
    }
    private List<DataRecord> getRecords(int count, List<String> fields, JSONArray array) {
        List<DataRecord> records = new ArrayList<>(count);
        DataRecord record;

        for (int i = 0; i < count; i++) {
            JSONArray jsonArray = (JSONArray) ((JSONArray) array.get(0)).get(i);

            //As per API docs: date, energy, and impact-e must not be null in a record
            Object energy = jsonArray.get(fields.indexOf(FireballConstants.ENERGY));
            Object lat = jsonArray.get(fields.indexOf(FireballConstants.LAT));
            Object latDir = jsonArray.get(fields.indexOf(FireballConstants.LAT_DIR));
            Object lon = jsonArray.get(fields.indexOf(FireballConstants.LON));
            Object lonDir = jsonArray.get(fields.indexOf(FireballConstants.LON_DIR));

            if(energy == null || StringUtils.isEmpty(energy.toString())
                || lat == null || StringUtils.isEmpty(lat.toString())
                || latDir == null || StringUtils.isEmpty(latDir.toString())
                || lon == null || StringUtils.isEmpty(lon.toString())
                || lonDir == null || StringUtils.isEmpty(lonDir.toString())) {
                continue;
            }

            record = new DataRecord();
            record.setEnergy(Double.parseDouble(energy.toString()));
            record.setLocation(new Location(Double.parseDouble(lat.toString()), latDir.toString(), Double.parseDouble(lon.toString()), lonDir.toString()));
            records.add(record);
        }
        System.out.println(records.size() + " records found !!");
        return records;
    }

}

final class FireballConstants {

    private FireballConstants() {}

    public static final String QUERY_DATE_MIN = "date-min=";
    public static final String QUERY_DATE_MAX = "date-max=";
    public static final String QUERY_REQUEST_LOCATION = "req-loc=";
    public static final String COUNT = "count";
    public static final String DATA = "data";
    public static final String FIELDS = "fields";

    public static final String DATE = "date";
    public static final String LAT = "lat";
    public static final String LAT_DIR = "lat-dir";
    public static final String LON = "lon";
    public static final String LON_DIR = "lon-dir";
    public static final String ENERGY = "energy";


}

/**
 * Custom Exception class for handling errors at persistence (DAO) layer
 */
class PersistanceException extends Exception {
    public PersistanceException(String errorMessage) {
        super(errorMessage);
    }

    public PersistanceException(String errorMessage, Throwable th) {
        super(errorMessage, th);
    }
}

/**
* Custom Exception class for handling errors at Service layer
*/
class ServiceException extends Exception {
    public ServiceException(String errorMessage) {
        super(errorMessage);
    }
}


