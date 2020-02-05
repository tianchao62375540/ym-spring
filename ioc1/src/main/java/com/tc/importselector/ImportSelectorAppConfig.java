package com.tc.importselector;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Auther: tianchao
 * @Date: 2020/2/4 14:24
 * @Description:
 */
@Configuration
@Import(MyImportSelector.class)
public class ImportSelectorAppConfig {
}
