# EasyGcm
Use this library to add GCM to your project, only in a few minutes !

# Installation

Top Level Gradle :
```
allprojects {
    repositories {
        maven {
            url "http://dl.bintray.com/joxad/maven"
        }
    }
}
```

Project's build.gradle

```
dependencies {
    compile 'com.github.joxad:android-easy-gcm:1.0.2'
}
```

# Utilisation

In whatever class with Context (better in your first launched Activity class) 

## Create EasyGCM
 
```
    new EasyGcm.Builder().context(this).senderId(getString(R.string.app_senderid)).enableLog(true).build();
```


## Get Token
 
  
```
EasyGcm.setTokenListener(new ITokenListener() {
    @Override
        public void onReceived(String token) {
    }
});
           
```

## Notification of Push
```

EasyGcm.setPushListener(new IPushListener() {
    @Override
    public void onReceive(Push push) {
    }
});

```

## Show an Android Notification 

```
EasyNotification.show(1,EasyNotification.generate(null,"Title",R.drawable.common_ic_googleplayservices,"Message","SummaryText",true));
```
