package com.celsia.dinamarca.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
@EnableRetry
public class RetryConfiguration {

    @Bean
    public RetryTemplate retryTemplate(
            @Value("${dinamarca.services.configuration.retry.interval:2000}") long interval,
            @Value("${dinamarca.services.configuration.retry.attempts:1}") int attempts) {
        RetryTemplate retryTemplate = new RetryTemplate();
        FixedBackOffPolicy policy = new FixedBackOffPolicy();
        policy.setBackOffPeriod(interval);
        retryTemplate.setBackOffPolicy(policy);
        retryTemplate.setRetryPolicy(new SimpleRetryPolicy(attempts));
        return retryTemplate;
    }

}
