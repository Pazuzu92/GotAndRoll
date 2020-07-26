package com.example.gotandroll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView moneyCount;
    private ImageView slot1, slot2, slot3, smallSlot1, smallSlot2, smallSlot3, smallSlot4,
            smallSlot5, smallSlot6;
    private Wheel wheel1, wheel2, wheel3;
    private SmallWheel smallWheel1, smallWheel2, smallWheel3, smallWheel4, smallWheel5, smallWheel6;
    private boolean isStarted;
    private int money = 0;

    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slot1 = findViewById(R.id.slot1);
        slot2 = findViewById(R.id.slot2);
        slot3 = findViewById(R.id.slot3);
        smallSlot1 = findViewById(R.id.small_slot1);
        smallSlot2 = findViewById(R.id.small_slot2);
        smallSlot3 = findViewById(R.id.small_slot3);
        smallSlot4 = findViewById(R.id.small_slot4);
        smallSlot5 = findViewById(R.id.small_slot5);
        smallSlot6 = findViewById(R.id.small_slot6);
        moneyCount = findViewById(R.id.money_count);
        ImageView btnSpin = findViewById(R.id.spin_btn);
        ImageView btnShare = findViewById(R.id.share_btn);
        moneyCount.setText(money +"");

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareCompat.IntentBuilder.from(MainActivity.this)
                        .setType("text/plain")
                        .setChooserTitle("Share URL")
                        .setText("http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)
                        .startChooser();
            }
        });

        btnSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isStarted) {
                    wheel1.stopWheel();
                    wheel2.stopWheel();
                    wheel3.stopWheel();
                    smallWheel1.stopWheel();
                    smallWheel2.stopWheel();
                    smallWheel3.stopWheel();
                    smallWheel4.stopWheel();
                    smallWheel5.stopWheel();
                    smallWheel6.stopWheel();

                    if (wheel1.currentIndex == wheel2.currentIndex && wheel2.currentIndex == wheel3.currentIndex) {
                        money = money+10000;
                        moneyCount.setText(money +"");
                    } else if (wheel1.currentIndex == wheel2.currentIndex || wheel2.currentIndex == wheel3.currentIndex
                            || wheel1.currentIndex == wheel3.currentIndex) {
                        money = money + 500;
                        moneyCount.setText(money +"");
                    } else {
                        moneyCount.setText("");
                    }

                    isStarted = false;

                } else {

                    wheel1 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    slot1.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(0, 200));

                    wheel1.start();

                    wheel2 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    slot2.setImageResource(img);

                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                    wheel2.start();

                    wheel3 = new Wheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    slot3.setImageResource(img);

                                }
                            });
                        }
                    }, 200, randomLong(150, 400));

                    wheel3.start();

                    smallWheel1 = new SmallWheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    smallSlot1.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(0, 200));

                    smallWheel1.start();

                    smallWheel2 = new SmallWheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    smallSlot2.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(0, 200));

                    smallWheel2.start();
                    smallWheel3 = new SmallWheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    smallSlot3.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(0, 200));

                    smallWheel3.start();
                    smallWheel4 = new SmallWheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    smallSlot4.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(0, 200));

                    smallWheel4.start();
                    smallWheel5 = new SmallWheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    smallSlot5.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(0, 200));

                    smallWheel5.start();
                    smallWheel6 = new SmallWheel(new Wheel.WheelListener() {
                        @Override
                        public void newImage(final int img) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    smallSlot6.setImageResource(img);
                                }
                            });
                        }
                    }, 200, randomLong(0, 200));

                    smallWheel6.start();
                    isStarted = true;
                }
            }
        });
    }
}
