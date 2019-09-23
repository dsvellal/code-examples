package com.sample.unit.testing.system.messages;

import org.junit.rules.ExternalResource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SystemOutResource extends ExternalResource {

    private PrintStream sysOut;
    private final ByteArrayOutputStream mySysout = new ByteArrayOutputStream();

    @Override
    protected void before() throws Throwable {
        sysOut = System.out;
        System.setOut(new PrintStream(mySysout));
    }

    @Override
    protected void after() {
        System.setOut(sysOut);
    }

    public String asString() {
        return mySysout.toString();
    }
}