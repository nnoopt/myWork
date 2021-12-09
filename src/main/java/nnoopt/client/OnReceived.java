package nnoopt.client;

import nnoopt.AbstractMessage;

public interface OnReceived {
    void onReceive(AbstractMessage msg);
}
