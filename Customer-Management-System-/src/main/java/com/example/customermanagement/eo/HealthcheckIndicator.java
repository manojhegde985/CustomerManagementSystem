package com.example.customermanagement.eo;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;



@Component
public class HealthcheckIndicator implements HealthIndicator {
private final String message_key = "CustomerService";



public Health health() {
if (!isRunningServiceCustomerService()) {
return Health.down().withDetail(message_key, "Not Available").build();
}
return Health.up().withDetail(message_key, "Available").build();
}



private boolean isRunningServiceCustomerService() {
try {
URL url = new URL("http://localhost:8083/customer/getAll");
HttpURLConnection connection = (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
connection.connect();
int code = connection.getResponseCode();
if(code == 200){
return true;
}
else {
return false;
}
}catch (Exception e){
return false;
}
}
}