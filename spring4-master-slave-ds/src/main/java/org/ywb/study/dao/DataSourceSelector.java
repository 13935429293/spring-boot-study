package org.ywb.study.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/2/24
 * Time: 13:44
 */
public class DataSourceSelector extends AbstractRoutingDataSource {

    private static final String MASTER = "master";
    private static final String SLAVE = "slave";
    private int slaveSize;
    private AtomicInteger i = new AtomicInteger(0);

    public void setSlaveSize(int slaveSize) {
        this.slaveSize = slaveSize;
    }

    protected Object determineCurrentLookupKey() {
        String context = DataSourceHolder.getContext();
        int index;
        if (SLAVE.equals(context)) {
            if (slaveSize > 1) {
                index = i.get() % slaveSize;
                if (i.getAndIncrement() > slaveSize) {
                    i.set(0);
                }
                return SLAVE + index;
            }
            return SLAVE;
        }
        return MASTER;
    }
}
