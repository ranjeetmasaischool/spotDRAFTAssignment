package com.example.spotDraft.controller;

import org.springframework.context.support.StaticApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

import com.example.spotDraft.Airtable.AirtableApi;

import jakarta.servlet.http.HttpServletRequest;

@org.springframework.web.bind.annotation.RestController
//@RequestMapping("/webhook")
public class RestController {

	 @PostMapping
	    public ResponseEntity<String> handleWebhook(@RequestBody String payload, HttpServletRequest request) {
	       
		 	System.out.print("Aa gaya mai yaha ");
		 	
		 	System.out.print(payload);
		 	
		 	String hookSecret=request.getHeader("X-Hook-Secret");
		 	 if (hookSecret != null) {
		            // Respond with the X-Hook-Secret to confirm the handshake
		            return ResponseEntity.ok()
		                    .header("X-Hook-Secret", hookSecret)
		                    .build();
		        }
		        return ResponseEntity.ok().build();
		 	
	    }
}
