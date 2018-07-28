package googleBilling;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.*;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.cloudbilling.Cloudbilling;
import com.google.api.services.cloudbilling.model.ProjectBillingInfo;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.net.*;
import java.util.*;


public class googleBillingDetails {

	 public static void main(String[] args)  throws IOException, GeneralSecurityException {
	        GoogleCredential credential = GoogleCredential.getApplicationDefault();

	        if (credential.createScopedRequired() ) {
	                 credential = credential.createScoped(Arrays.asList("https://developers.google.com/resources/api-libraries/download/cloudbilling/v1/java"));
	        }

	        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
	        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
	        Cloudbilling cloudbillingService = new Cloudbilling.Builder(httpTransport, jsonFactory, credential)
	                .setApplicationName("Foodie Directions 07-22-2018")
	                .build();


	        String name= "projects/Foodie Directions 07-22-2018"; // change this to my project name in the google cloud
	         Cloudbilling.Projects.GetBillingInfo request = cloudbillingService.projects().getBillingInfo(name);
	         ProjectBillingInfo response = request.execute();

	         System.out.println(response.getName());
	        }


}
