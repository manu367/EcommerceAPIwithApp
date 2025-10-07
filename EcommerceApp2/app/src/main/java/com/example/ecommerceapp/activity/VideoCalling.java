package com.example.ecommerceapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ecommerceapp.R;

import io.agora.rtc2.ChannelMediaOptions;
import io.agora.rtc2.Constants;
import io.agora.rtc2.RtcEngine;

public class VideoCalling extends AppCompatActivity {
    private RtcEngine rtcEngine;
    private String appId = "018bfbccb02c4602a1986d4527ed64fd";  // from Agora console
    private String channelName = "testChannel";
    private String token = null; // For production, generate token from server

    private boolean isInCall = false; // track call state

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video_calling);

        TextView callStatus = findViewById(R.id.call_status);
        Button audioCallBtn = findViewById(R.id.audio_call);
        Button muteBtn = findViewById(R.id.mute_btn);
        muteBtn.setEnabled(false);

        // Init Agora engine once
        rtcEngine = AgoraManager.initAgoraEngine(this, appId, new io.agora.rtc2.IRtcEngineEventHandler() {
            @Override
            public void onUserJoined(int uid, int elapsed) {
                runOnUiThread(() -> {
                    Toast.makeText(getApplicationContext(), "User joined: " + uid, Toast.LENGTH_SHORT).show();
                });
            }

            @Override
            public void onUserOffline(int uid, int reason) {
                runOnUiThread(() -> {
                    Toast.makeText(getApplicationContext(), "User left: " + uid, Toast.LENGTH_SHORT).show();
                });
            }
        });
        if (rtcEngine == null) {
            Toast.makeText(this, "Agora Engine init failed!", Toast.LENGTH_LONG).show();
            return; // stop further execution to avoid NPE
        }
        rtcEngine.enableAudio();
        rtcEngine.disableVideo();



//        Button audioCallBtn = findViewById(R.id.autio_call);
        audioCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isInCall) {
                    startAudioCall();
                    audioCallBtn.setText("End Call");
                    callStatus.setText("Call In Progress...");
                    muteBtn.setEnabled(true);
                } else {
                    endAudioCall();
//                    audioCallBtn.setText("Start Audio Call");
                    audioCallBtn.setText("Start Audio Call");
                    callStatus.setText("Call Not Started");
                    muteBtn.setEnabled(false);
                }
            }
        });
    }

    private void startAudioCall() {
        ChannelMediaOptions options = new ChannelMediaOptions();
        options.clientRoleType = Constants.CLIENT_ROLE_BROADCASTER;
        rtcEngine.joinChannel(token, channelName, 0, options);
        Toast.makeText(this, "Call Started", Toast.LENGTH_SHORT).show();
        isInCall = true;
    }

    private void endAudioCall() {
        rtcEngine.leaveChannel();
        Toast.makeText(this, "Call Ended", Toast.LENGTH_SHORT).show();
        isInCall = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (rtcEngine != null) {
            rtcEngine.leaveChannel();
            RtcEngine.destroy();
        }
    }
}
