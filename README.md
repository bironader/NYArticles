# NYArticles Android Application

<p float="left">
<img src="screenshots/main.jpg" width = 200>
<img src="screenshots/details.jpg" width = 200>
</>

## About
Android application fetch the mostviewd articles from new york times using https://developer.nytimes.com/

## How to run it
clone repo and add your nytimes api key in your gradle.properties
<img src="screenshots/gradle.prop.PNG">


## This project uses:
- Kotlin
- [Retrofit](http://square.github.io/retrofit/)
- [Gson](https://github.com/google/gson)
- [Dependency injection with Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Android DataBinding Library](https://developer.android.com/topic/libraries/data-binding)
- [Timber](https://github.com/JakeWharton/timber)
- [Glide 3](https://github.com/bumptech/glide)
- [Stetho](http://facebook.github.io/stetho/)
- [OkHttp](https://square.github.io/okhttp/)
- [Mockito](https://site.mockito.org/)
- Clean Architecture guide line
- MVVM as ui pattern and LiveData
- Coroutines

## SonarQube
- [Download java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Download SonarQube](https://www.sonarqube.org/downloads/)
- For windows run StartSonar.bat file
- For mac run sonar.sh start
- Open localhost:9000 panel
- Create new project and add project key
- Run gradlew sonar in android studio terminal

