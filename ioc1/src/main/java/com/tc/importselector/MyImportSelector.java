package com.tc.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Auther: tianchao
 * @Date: 2020/2/4 14:24
 * @Description:
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{ImportSelectorObject.class.getName()};
    }
}
