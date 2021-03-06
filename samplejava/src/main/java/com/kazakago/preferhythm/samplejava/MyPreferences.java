package com.kazakago.preferhythm.samplejava;

import android.support.annotation.NonNull;

import com.kazakago.preferhythm.PrefClass;
import com.kazakago.preferhythm.PrefField;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@PrefClass
class MyPreferences {

    @PrefField
    int intPrimitive;
    @PrefField
    int intPrimitiveWithInit = 3;

    @PrefField
    long longPrimitive;
    @PrefField
    long longPrimitiveWithInit = 5L;

    @PrefField
    float floatPrimitive;
    @PrefField
    float floatPrimitiveWithInit = 5.0f;

    @PrefField
    boolean booleanPrimitive;
    @PrefField
    boolean booleanPrimitiveWithInit = true;

    @PrefField
    Integer intObject;
    @PrefField
    Integer intObjectWithInit = 9;
    @NonNull
    @PrefField
    Integer intObjectNonNull = 12;

    @PrefField
    Long longObject;
    @PrefField
    Long longObjectWithInit = 15L;
    @NonNull
    @PrefField
    Long longObjectNonNull = 12L;

    @PrefField
    Float floatObject;
    @PrefField
    Float floatObjectWithInit = 15.0f;
    @NonNull
    @PrefField
    Float floatObjectNonNull = 12.0f;

    @PrefField
    Boolean booleanObject;
    @PrefField
    Boolean booleanObjectWithInit = true;
    @NonNull
    @PrefField
    Boolean booleanObjectNonNull = true;

    @PrefField
    String stringObject;
    @PrefField
    String stringObjectWithInit = "foo";
    @NonNull
    @PrefField
    String stringObjectNonNull = "bar";

    @PrefField
    Set<String> stringSetObject;
    @PrefField
    Set<String> stringSetObjectWithInit = new HashSet<>(Arrays.asList("foo", "bar"));
    @NonNull
    @PrefField
    Set<String> stringSetObjectNonNull = new HashSet<>(Arrays.asList("foo", "bar"));

}