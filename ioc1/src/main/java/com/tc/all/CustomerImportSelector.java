package com.tc.all;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Auther: tianchao
 * @Date: 2020/2/5 16:38
 * @Description:
 */
public class CustomerImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Dog.class.getName()};
    }
}
