package com.joxad.easygcm.listener;

/**
 * Created by josh on 26/02/16.
 * Listener for the Token of our device
 */
public interface ITokenListener {
    /***
     * @param token
     */
    public void onReceived(final String token);
}
