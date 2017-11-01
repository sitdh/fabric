package com.sitdh.thesis.fabric;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseAdminConfiguration {

	public FirebaseAdminConfiguration() throws IOException {
		
		FirebaseOptions options = new FirebaseOptions
				.Builder()
				.setCredentials(
						GoogleCredentials.fromStream(new ClassPathResource("serviceAccountKey.json").getInputStream()))
				.setDatabaseUrl("")
				.build();
		
		FirebaseApp.initializeApp(options, "scg-controls");
	}
}
