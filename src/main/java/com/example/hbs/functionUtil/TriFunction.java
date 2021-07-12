package com.example.hbs.functionUtil;

@FunctionalInterface
public interface TriFunction<X, Y, Z, R> {
    R apply(X x, Y y, Z z);
}
