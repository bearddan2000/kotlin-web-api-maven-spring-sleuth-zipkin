package example.controller;

import java.net.URI
import org.apache.logging.log4j.kotlin.Logging
import org.springframework.beans.factory.annotation.Autowired;
import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
class ZipkinController : Logging {

    @Autowired
    private lateinit var restTemplate: RestTemplate;

    @Bean
    fun getRestTemplate(): RestTemplate {
        return RestTemplate();
    }

    @Bean
    fun defaultSampler(): Sampler {
    	return Sampler.ALWAYS_SAMPLE;
    }

    @GetMapping("/")
    fun zipkinService1(): String
    {
        logger.info("Inside site1");
        val body: String? = restTemplate.getForObject(URI("http://site2:8081/"), String::class.java)
        if (body == null)
        {
          return "empty call"
        }
        return body
    }
}
