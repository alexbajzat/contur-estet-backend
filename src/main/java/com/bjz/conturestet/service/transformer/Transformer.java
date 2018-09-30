package com.bjz.conturestet.service.transformer;

/**
 * Brought to life by bjz on 9/30/2018.
 */
public interface Transformer<A> {

    /***
     *
     * @param target object to be validate and transformed
     * @return  validated and transformed object
     */
    A transform(A target);
}
