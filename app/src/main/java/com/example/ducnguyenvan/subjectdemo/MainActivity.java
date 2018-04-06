package com.example.ducnguyenvan.subjectdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    private Button btnAs, btnBh, btnPub, btnRep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView)findViewById(R.id.txt);
        btnAs = (Button)findViewById(R.id.btnAs);
        btnBh = (Button)findViewById(R.id.btnBh);
        btnPub = (Button)findViewById(R.id.btnPub);
        btnRep = (Button)findViewById(R.id.btnRep);

        btnAs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayReceivedValueAs();
            }
        });

        btnBh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayReceivedValueBh();
            }
        });
        btnPub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayReceivedValuePub();
            }
        });
        btnRep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayReceivedValueRep();
            }
        });

    }

    private void displayReceivedValueRep() {
        ReplaySubject<String> subject = ReplaySubject.create();
        txt.setText("subject.onNext(\"One\");\n" +
                "subject.onNext(\"Two\");\n" +
                "subject.onNext(\"Three\");\n" +
                "subject.onComplete();\n" +
                "subject.subscribe(observer1);\n" +
                "subject.subscribe(observer2);");
        Observer<String> observer1 = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                txt.setText( txt.getText() + "\n" + "Observer 1: Item received: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Observer<String> observer2 = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                txt.setText( txt.getText() + "\n" + "Observer 2: Item received: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        subject.onNext("One");
        subject.onNext("Two");
        subject.onNext("Three");
        subject.onComplete();
        subject.subscribe(observer1);
        subject.subscribe(observer2);
    }

    private void displayReceivedValuePub() {
        PublishSubject<String> subject = PublishSubject.create();
        txt.setText("subject.subscribe(observer1);\n" +
                "subject.onNext(\"One\");\n" +
                "subject.onNext(\"Two\");\n" +
                "subject.subscribe(observer2);\n" +
                "subject.onNext(\"Three\");\n" +
                "subject.onComplete();");
        Observer<String> observer1 = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                txt.setText( txt.getText() + "\n" + "Observer 1: Item received: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Observer<String> observer2 = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                txt.setText( txt.getText() + "\n" + "Observer 2: Item received: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        subject.subscribe(observer1);
        subject.onNext("One");
        subject.onNext("Two");
        subject.subscribe(observer2);
        subject.onNext("Three");
        subject.onComplete();
    }

    private void displayReceivedValueBh() {
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("Default");
        txt.setText("subject.subscribe(observer1);\n" +
                "subject.onNext(\"One\");\n" +
                "subject.subscribe(observer2);\n" +
                "subject.onNext(\"Two\");\n" +
                "subject.onNext(\"Three\");\n" +
                "subject.onComplete();");
        Observer<String> observer1 = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                txt.setText( txt.getText() + "\n" + "Observer 1: Item received: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        Observer<String> observer2 = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                txt.setText(txt.getText() + "\n" + "Observer 2: Item received: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        subject.subscribe(observer1);
        subject.onNext("One");
        subject.subscribe(observer2);
        subject.onNext("Two");
        subject.onNext("Three");
        subject.onComplete();

    }

    private void displayReceivedValueAs() {
        AsyncSubject<String> subject = AsyncSubject.create();
        txt.setText("subject.subscribe(observer);\n" +
                "subject.onNext(\"One\");\n" +
                "subject.onNext(\"Two\");\n" +
                "subject.onNext(\"Three\");\n" +
                "subject.onComplete();");
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                txt.setText(txt.getText() + "\n" + "Item received: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        subject.subscribe(observer);
        subject.onNext("One");
        subject.onNext("Two");
        subject.onNext("Three");
        subject.onComplete();
    }
}
