package com.mistymorning.housekeeper.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan({ "com.mistymorning.housekeeper.tasks" })
public class SpringTaskConfig {

}
