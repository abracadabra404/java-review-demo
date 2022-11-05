package com.review.thread.current.aqs;

import java.io.Serializable;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program java-review-demo
 * @description: AQS concurrent
 * @author: xuyaxi
 * @create: 2022/11/05 14:54
 */
public class Mutex implements Serializable {


    /**
     * 静态内部类，继承AQS
     */
    private static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 是否处于占用状态
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    private final Sync sync = new Sync();

    public void lock(){
        sync.acquire(1);
    }

    public void tryLock(){
        sync.tryAcquire(1);
    }

    public void unlock(){
        sync.release(1);
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }

}
