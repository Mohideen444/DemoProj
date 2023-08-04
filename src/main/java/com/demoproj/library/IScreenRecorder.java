package com.demoproj.library;


import java.io.IOException;

public interface IScreenRecorder {

    void startScreenRecording() throws IOException;
    void stopScreenRecording() throws IOException;
}
