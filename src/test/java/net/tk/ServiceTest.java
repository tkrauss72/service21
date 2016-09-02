package net.tk;

import junit.framework.Assert;

public class ServiceTest {
    @org.junit.Test
    public void serve() throws Exception {
        Assert.assertEquals("service21: test", new Service().serve("test"));
    }

}