package com.jwt.demo.middleware.redis.lettuce.com.jwt.demo.middleware.redis.publish;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPublish {


    @Test
    public void testPublish() {

        SpelExpressionParser parser = new SpelExpressionParser();
        SpelExpression spelExpression = parser.parseRaw("(true && false) or true");
        System.out.println(spelExpression);
    }

    @Test
    public void testCollect() {
        List<String> list = Stream.of("a", "b", "hello").collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("a", "b", "hello"), list);
    }

    @Test
    public void testMap() {
        List<String> list = Stream.of("a", "b", "hello").map(s -> s.toUpperCase()).collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("A", "B", "HELLO"), list);
    }

    @Test
    public void testFilter() {
        List<String> list = Stream.of("a", "b", "hello").filter(s -> StringUtils.equals("a", s)).collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("a"), list);
    }

    @Test
    public void testFlatMap() {
        List<String> list = Stream.of(Arrays.asList("a", "b", "hello"), Arrays.asList("A", "B", "HELLO"))
                .flatMap(members -> {
                    System.out.println(members);
                    return members.stream();
                }).collect(Collectors.toList());
        Assert.assertEquals(6, list.size());
    }

    @Test
    public void testMaxOrMin() {
        Integer max = Stream.of(1, 2, 3).max(Comparator.comparing(num -> num)).get();
        Assert.assertEquals(3, max.intValue());
        Integer min = Stream.of(1, 2, 3).min(Comparator.comparing(num -> num)).get();
        Assert.assertEquals(1, min.intValue());
    }

    String aaa = null;

    @Test
    public void testAnonymousInnerClass() {
        A<String, Integer> a = new A<String, Integer>() {
            @Override
            public <U, T> U apply(T t) {
                System.out.println(t);
                aaa = "1";
                return (U) Integer.valueOf(1);
            }
        };

        Function<String, String> function = new Function<String, String>() {

            @Override
            public String apply(String s) {
                return "1";
            }
        };
        Object apply = a.apply("1");
        System.out.println(apply);

        List<String> collect = Stream.of("1", "2").map(function).collect(Collectors.toList());
        System.out.println(collect);
    }

    interface A<U,T>{
        <U, T> U apply(T t);
    }

    @Test
    public void testMapToLong() {
        Long a = 1L;
        Long b = 2L;
        Stream.of(a, b)

    }
}
