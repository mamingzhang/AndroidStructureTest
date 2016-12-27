package com.example.mamingzhang.androidstructuretest.data.http;

import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.Runner;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.github.dreamhead.moco.Moco.httpServer;
import static com.github.dreamhead.moco.Runner.runner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by mamingzhang on 16/12/27.
 * <p>
 * 相关参考资料：
 * 1. https://github.com/dreamhead/moco/blob/master/moco-doc/usage.md
 */

public class MocoRunnerTest {
    private Runner runner;

    @Before
    public void setUp() {
        HttpServer httpServer = httpServer(8080);
        httpServer.response("MocoRunnerTest");
        runner = runner(httpServer);
        runner.start();
    }

    @After
    public void tearDown() {
        runner.stop();
    }

    @Test
    public void testShouldHttpReturnExpected() throws IOException {
        Content content = Request.Get("http://localhost:8080").execute().returnContent();
        assertThat(content.asString(), is("MocoRunnerTest"));
    }
}
