package com.mistymorning.housekeeper.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.mistymorning.housekeeper.listeners" })
public class ListenerConfig {

}
