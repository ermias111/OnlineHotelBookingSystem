package com.example.hbs.functionUtil;

@FunctionalInterface
public interface QuadFunction<X, Y, Z, V, R> {
    R apply(X x, Y y, Z z, V v);
}
