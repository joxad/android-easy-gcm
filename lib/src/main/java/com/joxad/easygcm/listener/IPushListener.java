package com.joxad.easygcm.listener;

import com.joxad.easygcm.model.Push;

/**
 * Created by josh on 26/02/16.
 */
public interface IPushListener {
    /***
     * Method called when we receive a push
     * @param push
     */
    public void onReceive(Push push);
}
