package com.tc.beandefinitionregestor;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Auther: tianchao
 * @Date: 2020/2/4 14:29
 * @Description:
 */
@Configuration
@Import(MyImportBeanDefinitionRegistrar.class)
public class ImportBeanDefinitionRegistrarAppConfig {
}
