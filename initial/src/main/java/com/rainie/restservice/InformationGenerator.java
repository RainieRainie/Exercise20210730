package com.rainie.restservice;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.stream.Collectors;


@Service
public class InformationGenerator {

    //    time, ISO date format - current datetime in UTC
    public static String getStringDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        String timestamp = df.format(new Date());
        return timestamp;
    }

    public User getUserInformationGenerator (UserInformationPush userInformationPush) {

        User user = new User();

//        set username
        String username = userInformationPush.getEmail();
        user.setUsername(username);

//        set tags
        String tags = userInformationPush.getTags().stream().collect(Collectors.joining(":"));
        user.setTags(tags);

//        set status
        user.setStatus("active");

//        seg created time
//        user.setCreated(getStringDate());

        return user;
    }

}
