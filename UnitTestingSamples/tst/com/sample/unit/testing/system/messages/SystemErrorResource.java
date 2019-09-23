package com.sample.unit.testing.system.messages;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.rules.ExternalResource;

public class SystemErrorResource extends ExternalResource {
    private PrintStream sysErr;
    private final ByteArrayOutputStream mySyserr = new ByteArrayOutputStream();

    @Override
    protected void before() throws Throwable {
        sysErr = System.err;
        System.setErr(new PrintStream(mySyserr));
    }

    @Override
    protected void after() {
        System.setErr(sysErr);
    }

    public String asString() {
        return mySyserr.toString();
    }

}
