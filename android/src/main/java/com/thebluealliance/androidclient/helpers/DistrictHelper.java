package com.thebluealliance.androidclient.helpers;

import android.util.Log;

import com.thebluealliance.androidclient.Constants;
import com.thebluealliance.androidclient.models.District;

/**
 * Created by phil on 7/24/14.
 */
public class DistrictHelper {

    /* DO NOT CHANGE ORDER. */
    public static enum DISTRICTS {
        NO_DISTRICT,
        MICHIGAN,
        MID_ATLANTIC,
        NEW_ENGLAND,
        PACIFIC_NORTHWEST;

        public static DISTRICTS fromEnum(int districtEnum){
            switch (districtEnum){
                default:
                case 0: return NO_DISTRICT;
                case 1: return MICHIGAN;
                case 2: return MID_ATLANTIC;
                case 3: return NEW_ENGLAND;
                case 4: return PACIFIC_NORTHWEST;
            }
        }

        public static DISTRICTS fromAbbreviation(String abbrev){
            switch (abbrev){
                case "fim": return MICHIGAN;
                case "mar": return MID_ATLANTIC;
                case "ne":  return NEW_ENGLAND;
                case "pnw": return PACIFIC_NORTHWEST;
                default:    return NO_DISTRICT;
            }
        }

    }

    public static boolean validateDistrictKey(String key){
        try {
            int year = Integer.parseInt(key.substring(0, 4));
            String districtAbbrev = key.substring(4);
            return DISTRICTS.fromAbbreviation(districtAbbrev) != DISTRICTS.NO_DISTRICT;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static String generateKey(String districtAbbrev, int year){
        return year + districtAbbrev;
    }

    public static DISTRICTS districtTypeFromKey(String districtKey){
        String districtAbbrev = districtKey.substring(4);
        return DISTRICTS.fromAbbreviation(districtAbbrev);
    }

    public static District buildDistrictFromUrl(String districtKey, String url){
        int year = Integer.parseInt(url.substring(url.lastIndexOf("/")));
        Log.d(Constants.LOG_TAG, "Creating district for "+year);
        District out = new District();
        out.setKey(year+districtKey);
        out.setYear(year);
        out.setAbbreviation(districtKey);
        out.setEnum(DISTRICTS.fromAbbreviation(districtKey).ordinal());
        return out;
    }

    public static void addFieldByAPIUrl(District district, String url, String data){

    }

}
