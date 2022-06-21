package com.google.sps.data;


/** An Person that contacts me. */
public final class Person {

  private final String name;
  private final String email;
  private final String phoneNumber;
  private final long timestamp;

  public Person(String name, String email,String phoneNumber, long timestamp) {
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.timestamp = timestamp;
  }
}
