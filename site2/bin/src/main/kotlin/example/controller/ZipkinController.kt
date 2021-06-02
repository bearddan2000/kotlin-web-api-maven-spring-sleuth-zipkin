package example.controller;

import org.apache.logging.log4j.kotlin.Logging
import org.springframework.beans.factory.annotation.Autowired;
import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ZipkinController : Logging{

    @Bean
    fun defaultSampler(): Sampler {
    	return Sampler.ALWAYS_SAMPLE;
    }

    @GetMapping("/")
    fun zipkinService1(): String
    {
        logger.info("Inside site2");

        return "Hello\n";
    }
}
