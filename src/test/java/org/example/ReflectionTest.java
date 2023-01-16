package org.example;

import org.example.annotation.ControllerAnnotation;
import org.example.connector.TempUser;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/*
* @Controller 어노테이션이 설정된 모든 클래스를 찾아 출력
* */
public class ReflectionTest {
    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {
        Reflections reflections = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();
        beans.addAll(reflections.getTypesAnnotatedWith(ControllerAnnotation.class));

        logger.debug("beans: [{}]", beans);
    }

    @Test
    void showClass() {
        Class<TempUser> clazz = TempUser.class;
        logger.debug(clazz.getName());
        logger.debug("User all declared fields: [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
        logger.debug("User all declared constructors: [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
        logger.debug("User all declared methods: [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

    @Test
    void loadClass() throws ClassNotFoundException {
        // Load type 1
        Class<TempUser> classByDotClass = TempUser.class;

        // Load type 2
        TempUser tempUser = new TempUser("wch18735", "password", "name", "email");
        Class<? extends TempUser> classByGetClass = tempUser.getClass();

        // Load type 3
        Class<?> classByForName = Class.forName("org.example.connector.TempUser");

        assertThat(classByDotClass == classByGetClass).isTrue();
        assertThat(classByGetClass == classByForName).isTrue();
        assertThat(classByForName == classByDotClass).isTrue();
    }
}
