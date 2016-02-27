# EasyGcm
Use this library to add GCM to your project, only in a few minutes !

# Installation

```gradle
repositories {
    maven {
        url "https://jitpack.io"
    }
}

dependencies {
    compile 'com.github.joxad.EasyGcm:1.0.0'
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

