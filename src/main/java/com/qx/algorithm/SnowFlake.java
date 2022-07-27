package com.qx.algorithm;

/**
 * @author xuan
 * @date 2022/6/22 14:13
 * 雪花算法
 */
public class SnowFlake {


    private long workerId;
    private long datacenterId;
    private long sequence;

    private static long epoch = 1288834974657L;

    private static final long workerIdBits = 5L;
    private static final long datacenterIdBits = 5L;
    private static final long maxWorkerId = ~(-1L << workerIdBits);
    private static final long maxDatacenterId = ~(-1L << datacenterIdBits);
    private static final long sequenceBits = 12L;

    private static final long workerIdShift = sequenceBits;
    private static final long datacenterIdShift = sequenceBits + workerIdBits;
    private static final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private static final long sequenceMask = ~(-1L << sequenceBits);

    private long lastTimestamp = -1L;

    public SnowFlake(long workerId, long datacenterId, long sequence) {

        if (workerId < 0 || workerId > maxWorkerId) {
            throw new IllegalArgumentException();
        }

        if (datacenterId < 0 || datacenterId > maxDatacenterId) {
            throw new IllegalArgumentException();
        }

        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }


    public long getWorkerId() {
        return workerId;
    }

    public long getDatacenterId() {
        return datacenterId;
    }

    public synchronized long nextId() {
        long time = timeGen();
        if (time < lastTimestamp) {
            throw new RuntimeException(String.format("当前时间小于之前的时间，当前时间-> %d,之前的时间-> %d", time, lastTimestamp));
        }

        if (time == lastTimestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                time = tilNextMillis(time);
            }
        } else {
            sequence = 0;
        }
        lastTimestamp = time;
        return ((time-epoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift) | (sequence);
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

}
